$(function() {
	$('#addBtn').click(function(){
		layer.open({
			type : 2,
			border : [ 0 ],
			title : '用户新增',
			shadeClose : true,
			closeBtn : false,
			content : '/admin/user?p=add',
			area : [ '860px', '500px' ]
		});
	});
});
