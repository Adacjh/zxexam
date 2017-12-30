/**
 * 
 */
$(document).ready(
		function() {
			var time;
			var testInfo;
			$.ajax({
				type : "POST",// 提交类型
				url : "../../student/getTest.do",//查看已考试卷信息
				dataType : "json",
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
								+ "</td><td>" + testInfo[i].sumScore
								+ "</td><td>" + testInfo[i].score
								+ "</td></tr>");
			}
		});
function search(testId,sScore){//查看详细成绩内容
	window.location.href="../jsp/searchTest.jsp?testId="+testId+"&sScore="+sScore;
}