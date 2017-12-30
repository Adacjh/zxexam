/**
 * 
 */
$(document).ready(function() {
	$("#onLineTest").click(function() {
		$('iframe').attr("src", "testChoice.jsp");//选择考试试卷
	});
	$("#outSystem").click(function() {
		window.location.href = "../../jsp/login.jsp"
	});
	$("#searchScore").click(function() {
		$('iframe').attr("src", "searchScore.jsp");//查询成绩
	});
	$("#update").click(function (){
		$('iframe').attr("src", "../../teacher/jsp/passWordRe.jsp");
	});
});
