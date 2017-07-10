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
	//翻页查询
	var pageForm = $('#form');
	var inputPageNumber =  pageForm.find('input[name=pageNumber]');
	var inputPageSize = pageForm.find('input[name=pageSize]');
	var inputTotal = pageForm.find('input[name=total]');
	$(".selector").pagination({
        items: inputTotal.val(),
	    itemsOnPage: inputPageSize.val(),
	    currentPage: parseInt(inputPageNumber.val()) + 1,
        cssStyle: 'mmp-theme',
        prevText:"上一页",
        nextText:"下一页",
        onPageClick:function(pageNumber){
        	inputPageNumber.val(pageNumber - 1);
        	pageForm.submit();
        }
    });
	//搜索按钮
	$('#searchBtn').click(function(){
		var searchParam = $('#searchParam').val();
		window.location.href="/admin/user/list?searchParam="+searchParam;
	});
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
