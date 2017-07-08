$(function() {
	// 放弃保存按钮，直接关闭弹窗
	$('#closeBtn').click(function() {
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	});
	$('#form').validate({
		rules : {
			username : {
				required : true,
				minlength : 6,
				maxlength : 20
			},
			password : {
				required : true,
				minlength : 6,
			},
			repassword : {
				equalTo : '#password',
			}
		},
		messages : {
			username : {
				required : '请输入账号',
				minlength : '输入最少6个字符',
				maxlength : '输入最多20个字符'
			},
			password : {
				required : '请输入密码',
				minlength : '输入最少6个字符',
			},
			repassword : {
				equalTo : '两次密码输入不一致'
			}
		},
		invalidHandler : function() {
			// 验证失败的提示
			return false;
		},
		submitHandler : function() {
			// invalidHandler验证成功后，才会触发submitHandler
			// 判断是新增还是编辑
			var add_or_edit = $('#form').find('input[name="id"]').val() == '';
			var formMethod;
			if (add_or_edit) {
				// 新增
				formMethod = "add";
			} else {
				// 编辑
				formMethod = "update";
			}
			$.post('/admin/user/' + formMethod, $('#form').serialize(), function(data) {
				if (!data.error) {
					// 返回正确信息
					parent.location.reload();
				} else {
					// 错误信息处理
					layer.msg(data.message);
				}
			});
			// 返回false中断表单提交
			return false;
		}
	});
});
