/**
 * 
 */
$(document).ready(function() {
	var testName;
	$.ajax({//选择试卷
		type : "POST",// 提交类型
		url : "../../student/getTestInfo.do",
		dataType : "json",
		async : false,// 异步
		success : function(json) {
			for (i in json) {
				$("#testInfo").append("<option value="+json[i].subjectBianhao+">"+json[i].subjectName+"</option>");
			}
		}
	});
	$("#startTest").click(function (){
		var testId=$("#testInfo").val();
		window.location.href="../jsp/test.jsp?testId="+testId;
	});	
});