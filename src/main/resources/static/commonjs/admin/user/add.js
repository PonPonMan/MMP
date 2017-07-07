$(function() {
	$('#closeBtn').click(function() {
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	});
	$('#form').validate({
		rules:{
			username:{
				required:true,
				minlength:6,
				maxlength:20
			},
			password:{
				required:true,
				minlength:6,
			},
			repassword:{
				equalTo:'#password',
			}
		},
		messages:{
			username:{
				required:'请输入账号',
				minlength:'输入最少6个字符',
				maxlength:'输入最多20个字符'
			},
			password:{
				required:'请输入密码',
				minlength:'输入最少6个字符',
			},
			repassword:{
				equalTo:'两次密码输入不一致'
			}
		}
	});
	$('#saveBtn').click(function() {
		$('#form').submit();
	});
});
