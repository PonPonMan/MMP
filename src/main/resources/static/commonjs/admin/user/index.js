function edit(content) {
	layer.open({
		type : 2,
		border : [ 0 ],
		title : '用户编辑',
		shade : 0.1,
		shadeClose : false,
		scrollbar : false,
		closeBtn : 1,
		content : content,
		area : [ '550px', '300px' ]
	});
}
$(function() {
	// 添加按钮
	$('#addBtn').click(function() {
		edit('/admin/user?p=edit');
	});
	// 编辑按钮
	$('.editBtn').click(function() {
		var id = $(this).parents('td:first').attr('data-id');
		edit('/admin/user?p=edit&id=' + id);
	});
	// 删除按钮
	$('.delBtn').click(function() {
		var id = $(this).parents('td:first').attr('data-id');
		layer.confirm('确认删除?', {
			icon : 3,
			title : '提示'
		}, function(index) {
			$.post('/admin/user/delete', {
				'id' : id
			}, function(data) {
				if (!data.error) {
					// 返回正确信息
					parent.location.reload();
				} else {
					// 错误信息处理
					layer.msg(data.message);
				}
			});
		});
	});
	$('#delAllBtn').click(function() {
		var ids = getCheck();
		if (ids.length == 0) {
			layer.msg('请至少选择一条数据进行操作');
			return;
		}
		layer.confirm('确认删除?', {
			icon : 3,
			title : '提示'
		}, function(index) {
			$.post('/admin/user/deleteAll', {
				'ids' : ids
			}, function(data) {
				if (!data.error) {
					// 返回正确信息
					parent.location.reload();
				} else {
					// 错误信息处理
					layer.msg(data.message);
				}
			});
		});
	});
});
