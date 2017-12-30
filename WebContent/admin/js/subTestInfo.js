/**
 * 
 */
$(document)
		.ready(
				function() {//显示试卷的详细信息
					var bh=$('#testId').val();
					var zuJuan={
							"questionBh":bh
					}
					var subTestInfo;
					$.ajax({//显示单选题
						type : "POST",
						dataType : 'json',
						url : "../../test/subTestInfo.do",
						data : zuJuan,
						async : false,
						success : function(json) {
							
							subTestInfo = json;
							$('#h2').text(json[0].subjectName);
						}
					});
					var subTestInfo1;
					$.ajax({//显示多选题
						type : "POST",
						dataType : 'json',
						url : "../../test/subTestInfo1.do",
						data : zuJuan,
						async : false,
						success : function(json) {
							subTestInfo1 = json;
							$('#h2').text(json[0].subjectName);
							
						}
					});
					var j=0;
					for ( var i in subTestInfo) {
						j=j+1;
						if(j>1){
							$("#table1").show();
						}
						$("#table1")
								.append(
										"<tr><td>"
												+ j
												+ "、&nbsp;&nbsp;"
												+ subTestInfo[i].radioContent
												+ "</td></tr><tr><td>"
												+ "A.&nbsp;&nbsp;&nbsp;&nbsp;"
												+ subTestInfo[i].radioAnswerA
												+ "</td></tr><tr><td>"
												+ "B.&nbsp;&nbsp;&nbsp;&nbsp;"
												+ subTestInfo[i].radioAnswerB
												+ "</td></tr><tr><td>"
												+ "C.&nbsp;&nbsp;&nbsp;&nbsp;"
												+ subTestInfo[i].radioAnswerC
												+ "</td></tr><tr><td>"
												+ "D.&nbsp;&nbsp;&nbsp;&nbsp;"
												+ subTestInfo[i].radioAnswerD
												+ "</td></tr>");
					}
					$('#label1').html(j);
					$('#label2').html(subTestInfo[0].score);
					var n=0;
					for ( var i in subTestInfo1) {
						n=n+1;
						if(subTestInfo1[i].checkContent!=""){
							$("#table2").show();
						}
						$("#table2")
								.append(
										"<tr><td>"
												+ n
												+ "、&nbsp;&nbsp;"
												+ subTestInfo1[i].checkContent
												+ "</td></tr><tr><td>"
												+ "A.&nbsp;&nbsp;&nbsp;&nbsp;"
												+ subTestInfo1[i].checkAnswerA
												+ "</td></tr><tr><td>"
												+ "B.&nbsp;&nbsp;&nbsp;&nbsp;"
												+ subTestInfo1[i].checkAnswerB
												+ "</td></tr><tr><td>"
												+ "C.&nbsp;&nbsp;&nbsp;&nbsp;"
												+ subTestInfo1[i].checkAnswerC
												+ "</td></tr><tr><td>"
												+ "D.&nbsp;&nbsp;&nbsp;&nbsp;"
												+ subTestInfo1[i].checkAnswerD
												+ "</td></tr>");
					}
					$('#label3').html(n);
					$('#label4').html(subTestInfo1[0].score);
				});
