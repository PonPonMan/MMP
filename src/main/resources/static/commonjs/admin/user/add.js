$(function() {
	$('#closeBtn').click(function() {
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	});
	$('#saveBtn').click(function() {
		$('#form').submit();
	});
	$('input[name="repassword"]').blur(function() {
		if($(this).val() != $('input[name="password"]').val()){
			layer.msg('两次密码不一致');
		}
	});
});
