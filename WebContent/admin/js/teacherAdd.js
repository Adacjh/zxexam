/**
 * 
 */
$(document).ready(function() {
	$('#regist').click(function() {
		$.ajax({
			type : "POST",// 提交类型
			url : "../../user/teacherAdd.do",
			dataType : "text",
			data : $('#submitform').serialize(),
			async : false,// 异步
			success : function(json) {
				userInfo = json;
				if (userInfo == "1") {
					window.location.href="../jsp/teacherAdd.jsp";
				}else{
				alert(userInfo)
				}
			}
		});
	});
});