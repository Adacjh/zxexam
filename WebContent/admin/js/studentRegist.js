/**
 * 
 */
$(document).ready(function() {
	var errorMessage;
	$('#regist').click(function (){
		$.ajax({
			type : "POST",//提交类型
			url : "../../user/stuRegist.do",
			dataType : "text",
			data : $('#submitform').serialize(),//提交form标签下所有的name值
			async : false,//异步
			success : function(json) {
				errorMessage = json;
				alert(errorMessage)
				if(errorMessage=="注册成功"){
					window.location.href = "../../jsp/login.jsp";
				}
					
				
			}
		});
	});
	
	
});