/**
 * 
 */
$(document).ready(function() {
	$('#regist').hide();
	$("#passWordDiv").hide();
	$("#forgetPassWord").hide();
	$('#b').click(function() {
		$("#passWordDiv").hide();
	});
	$('#admin').click(function() {
		$('#name').text("管理员");
		$('#regist').hide();
		$("#forgetPassWord").hide();
	});
	$('#teacher').click(function() {
		$("#forgetPassWord").show();
		$('#name').text("教师编号");
		$('#regist').hide();
	});
	$('#student').click(function() {
		$("#forgetPassWord").show();
		$('#name').text("考生账号");
		$('#regist').show();
	});
	$("#forgetPassWord").click(function() {//忘记密码
		$("#passWordDiv").show();
	});
	$('input#login').click(function() {//登录
		var errorMessage;
		$.ajax({
			type : "POST",//请求方式
			dataType : 'text',//接受的数据类型
			url : "../user/userLogin.do",//请求路径
			data : $('#submitform').serialize(),//form表单所有name属性的值
			async : false,
			success : function(json) {
				errorMessage = json;
			}
		});
		if (errorMessage == "1") {
			window.location.href = "../admin/jsp/Admin.jsp"
		} else if (errorMessage == "3") {
			window.location.href = "../student/jsp/StudentTest.jsp"
		} else if (errorMessage == "2") {
			window.location.href = "../teacher/jsp/teacher.jsp?"
		} else {
			alert(errorMessage)
		}
	});

	$('input#regist').click(function() {//注册
		var errorMessage;
		window.location.href = "../admin/jsp/StudentRegist.jsp"

	});
	$("#userAccountNumber").blur(function() {
		if ($("#userAccountNumber").val() == "") {
		} else {
			infoYz();
		}
	});
	$("#userPhone").blur(function() {
		if ($("#userPhone").val() == "") {
		} else {
			infoYz();
		}
	});
	$('#rePassWord').click(function() {//修改密码

	$.ajax({
		type : "POST",
		dataType : 'text',
		url : "../user/userPassWordUpde.do",
		data : $('#submitform1').serialize(),
		async : false,
		success : function(json) {
			if(json=="1"){
				alert("修改成功")
			}else{
				alert(json)
			}
		}
	});
	});
});
function infoYz() {
	$.ajax({
		type : "POST",
		dataType : 'text',
		url : "../user/userInfoYz.do",
		data : $('#submitform1').serialize(),
		async : false,
		success : function(json) {
			errorMessage = json;
			if (errorMessage == "1") {
			} else {
				alert(errorMessage);
			}
		}
	});
}
