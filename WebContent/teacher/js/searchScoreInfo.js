/**
 * 
 */
var userId;
$(document).ready(
		function() {
			var name;
			var time;
			var testInfo;
			 userId=$('#userId').val();
			$.ajax({
				type : "POST",// 提交类型
				url : "../../user/searchUserById.do",
				dataType : "text",
				data:"userId="+userId,
				async : false,// 异步
				success : function(json) {
					name = json;
				}
			});
			$.ajax({
				type : "POST",// 提交类型
				url : "../../student/getTestByUserId.do",
				dataType : "json",
				data:"userId="+userId,
				async : false,// 异步
				success : function(json) {
					testInfo = json;
				}
			});
			for ( var i in testInfo) {
				$('#table1').append(
						"<tr><td><button type='button' class='btn btn-link' onclick='search("+testInfo[i].testId+","+testInfo[i].score+")'>"
								+ testInfo[i].testName + "</button></td><td>"
								+ testInfo[i].date.substring(0, 19)
								+ "</td><td>"+name+"</td><td>" + testInfo[i].sumScore
								+ "</td><td>" + testInfo[i].score
								+ "</td></tr>");
			}
		});
function search(testId,sScore){
	window.location.href="../../student/jsp/searchTest.jsp?testId="+testId+"&sScore="+sScore+"&userId="+userId;
}