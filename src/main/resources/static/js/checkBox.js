$(function() {
	$('.checkAll').click(function() {
		$(".checkOne").prop("checked", $(".checkAll").prop("checked"));
	});
	$(".checkOne").click(function() {
		var allChecked = true;
		$(".checkOne").each(function() {
			if ($(this).prop("checked") == false) {
				allChecked = false;
			}
		});
		if (allChecked) {
			$(".checkAll").prop("checked", true);
		} else {
			$(".checkAll").prop("checked", false);
		}
	});
});
function getCheck() {
	var chk_value = [];// 定义一个数组
	$('.checkOne:checked').each(function() {// 遍历每一个名字为interest的复选框，其中选中的执行函数
		chk_value.push($(this).val());// 将选中的值添加到数组chk_value中
	});
	return chk_value;
}
