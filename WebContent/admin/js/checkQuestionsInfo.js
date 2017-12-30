/**
 * 
 */
$(document)
		.ready(
				function() {
					var checkQuestionsInfo;
					var subId=$("#subId").val()
					$.ajax({
						type : "POST",
						dataType : 'json',
						url : "../../questions/getChQuestions.do",
						data : "number=1&subId="+subId,
						async : false,
						success : function(json) {
							checkQuestionsInfo = json;
						}
					});
					$.ajax({
						type : "POST",
						dataType : 'text',
						url : "../../questions/getSubName.do",
						data : "subId="+subId,
						async : false,
						success : function(json) {
							$('#subName').html(json);
						}
					});
					for ( var i in checkQuestionsInfo) {
						var ii=parseInt(i)+1;
						$("#table1")
								.append(
										"<tr class="
												+ checkQuestionsInfo[i].checkId
												+ "><td>"
												+ ii
												+ "、&nbsp;&nbsp;"
												+ checkQuestionsInfo[i].checkContent
												+ "</td><td style='width: 14%; text-align: center;'>"
												+ "<button type='button' class='btn' onclick='del("
												+ checkQuestionsInfo[i].checkId
												+ ")'>删除</button><button type='button' class='btn' onclick='update("
												+ checkQuestionsInfo[i].checkId
												+ ")'>修改</button>"
												+ "</td></tr><tr class="
												+ checkQuestionsInfo[i].checkId
												+ "><td>"
												+ "A.&nbsp;&nbsp;&nbsp;&nbsp;"
												+ checkQuestionsInfo[i].checkAnswerA
												+ "</td></tr><tr class="
												+ checkQuestionsInfo[i].checkId
												+ "><td>"
												+ "B.&nbsp;&nbsp;&nbsp;&nbsp;"
												+ checkQuestionsInfo[i].checkAnswerB
												+ "</td></tr><tr class="
												+ checkQuestionsInfo[i].checkId
												+ "><td>"
												+ "C.&nbsp;&nbsp;&nbsp;&nbsp;"
												+ checkQuestionsInfo[i].checkAnswerC
												+ "</td></tr><tr class="
												+ checkQuestionsInfo[i].checkId
												+ "><td>"
												+ "D.&nbsp;&nbsp;&nbsp;&nbsp;"
												+ checkQuestionsInfo[i].checkAnswerD
												+ "</td></tr><tr class="
												+ checkQuestionsInfo[i].checkId
												+ "><td>"
												+ "答案:&nbsp;&nbsp;&nbsp;&nbsp;"
												+ checkQuestionsInfo[i].checkAnswer
												+ "</td></tr>");
					}
				});
function del(id) {
	if (window.confirm('你确定要删除试题吗？')) {
		$.ajax({
			type : "POST",
			dataType : "text",
			url : "../../questions/delchQuestions.do",
			data : "checkId=" + id,
			async : false,
			success : function(json) {
				$("." + id + "").hide();
			}
		});
		return true;
	} else {
		return false;
	}
}
function update(id){
	window.location.href="../jsp/updateChQuestion.jsp?id="+id;
}