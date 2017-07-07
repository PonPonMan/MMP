$(function() {
	$('#addBtn').click(function(){
		layer.open({
			type : 2,
			border : [ 0 ],
			title : '用户新增',
			shade:0.1,
			shadeClose : false,
			scrollbar: false,
			closeBtn : 1,
			content : '/admin/user?p=add',
			area : [ '550px', '300px' ]
		});
	});
});
