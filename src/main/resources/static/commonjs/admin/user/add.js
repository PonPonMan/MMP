$(function() {
	$('#closeBtn').click(function() {
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	});
//	$('#form').validate({
//		submitHandler : function(form) {
//			var $form = $(form), data = $form.serialize(); //序列化表单数据
//			//这里是jquery表单验证通过的时候执行的操作，比如这里，表单验证通过的时候执行了jquery的ajax的post操作      
////			$.post('js/test.json', {
////				data : data
////			}, function(d) {
////				if (d.Flag) {
////					alert("如果返回为真，将执行这里代码")
////				} else {
////
////				}
////			}, 'json');
//		}
//	});
	$('#form').validate();
	$('#saveBtn').click(function() {
		$('#form').submit();
	});
});
