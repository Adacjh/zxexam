/**
 * 
 */
$(document)
		.ready(
				function() {
					var radioQuestionsInfo;
					var subId=$("#subId").val();
					$.ajax({
						type : "POST",
						dataType : 'json',
						url : "../../questions/getRaQuestions.do",
						data : "number=1&subId="+subId,
						async : false,
						success : function(json) {
							radioQuestionsInfo = json;
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
					for ( var i in radioQuestionsInfo) {
						var ii=parseInt(i)+1;
						$("#table1")
								.append(
										"<tr class="
												+ radioQuestionsInfo[i].radioId
												+ "><td>"
												+ ii
												+ "、&nbsp;&nbsp;"
												+ radioQuestionsInfo[i].radioContent
												+ "</td><td style='width: 14%; text-align: center;'>"
												+ "<button type='button' class='btn' onclick='del("
												+ radioQuestionsInfo[i].radioId
												+ ")'>删除</button><button type='button' class='btn' onclick='update("
												+ radioQuestionsInfo[i].radioId
												+ ")'>修改</button>"
												+ "</td></tr><tr class="
												+radioQuestionsInfo[i].radioId
									        	+"><td>"
												+ "A.&nbsp;&nbsp;&nbsp;&nbsp;"
												+ radioQuestionsInfo[i].radioAnswerA
												+ "</td></tr><tr class="
												+radioQuestionsInfo[i].radioId
									        	+"><td>"
												+ "B.&nbsp;&nbsp;&nbsp;&nbsp;"
												+ radioQuestionsInfo[i].radioAnswerB
												+ "</td></tr><tr class="
												+radioQuestionsInfo[i].radioId
									        	+"><td>"
												+ "C.&nbsp;&nbsp;&nbsp;&nbsp;"
												+ radioQuestionsInfo[i].radioAnswerC
												+ "</td></tr><tr class="
												+radioQuestionsInfo[i].radioId
									        	+"><td>"
												+ "D.&nbsp;&nbsp;&nbsp;&nbsp;"
												+ radioQuestionsInfo[i].radioAnswerD
												+ "</td></tr><tr class="
												+radioQuestionsInfo[i].radioId
									        	+"><td>"
												+ "答案:&nbsp;&nbsp;&nbsp;&nbsp;"
												+ radioQuestionsInfo[i].radioAnswer
												+ "</td></tr>");
					}
				});
function del(id) {
	if (window.confirm('你确定要删除试题吗？')) {
		$.ajax({
			type : "POST",
			dataType:"text",
			url : "../../questions/delRaQuestions.do",
			data : "radioId=" + id,
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
	window.location.href="../jsp/updateRaQuestion.jsp?id="+id;
}
