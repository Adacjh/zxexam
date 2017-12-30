/**
 * 
 */
var j = 0;
var sScore;
$(document).ready(function() {
	$("#dan").hide();
	$("#duo").hide();
	var testId = $('#testId').val();
	var userId =  $('#userId').val();
	if(userId=="null"){
		userId="kong"
	}
	sScore = $('#sScore').val();
	var testInfo;
	var testInfo1;
	$.ajax({
		type : "POST",// 提交类型
		url : "../../student/setTestByTeseId.do",//通过试卷ID获取试卷单选题信息
		dataType : "json",
		data : "testId=" + testId+"&type=1&id="+userId,
		async : false,// 异步
		success : function(json) {
			testInfo = json;
			$('#label2').html(testInfo[0].mScore);
			appendTestInfo(testInfo,"table1");
		}
	});
	$.ajax({
		type : "POST",// 提交类型
		url : "../../student/setTestByTeseId.do",//通过试卷ID获取试卷多选题信息
		dataType : "json",
		data : "testId=" + testId+"&type=2&id="+userId,
		async : false,// 异步
		success : function(json) {
			testInfo1 = json;
			$('#label4').html(testInfo1[0].mScore);
			appendTestInfo(testInfo1,"table2");
		}
	});
});
function appendTestInfo(testInfo,type) {//将获取的试题显示出来
	var t1=0;
	var t2=0;
	for ( var i in testInfo) {
		if(type=="table1"){
			t1=t1+1;
		}else{
			t2=t2+1;
		}
		j = j + 1;
		$("#"+type+"")
				.append(
						"<tr><td colspan='3'>"
								+ j
								+ "、&nbsp;&nbsp;"
								+ testInfo[i].content
								+ "</td></tr><tr><td colspan='3'>"
								+ "A.&nbsp;&nbsp;&nbsp;&nbsp;"
								+ testInfo[i].answerA
								+ "</td></tr><tr><td colspan='3'>"
								+ "B.&nbsp;&nbsp;&nbsp;&nbsp;"
								+ testInfo[i].answerB
								+ "</td></tr><tr><td colspan='3'>"
								+ "C.&nbsp;&nbsp;&nbsp;&nbsp;"
								+ testInfo[i].answerC
								+ "</td></tr><tr><td colspan='3'>"
								+ "D.&nbsp;&nbsp;&nbsp;&nbsp;"
								+ testInfo[i].answerD
								+ "</td></tr><tr id='"
								+ j
								+ "'><td><b>正确答案:<label id='rAnswer"
								+ j
								+ "' class='zz'>"
								+ testInfo[i].answer
								+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>你的答案:<label id='yAnswer"
								+ j
								+ "' class='zz'>"
								+ testInfo[i].myAnswer
								+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>分值:<label id='mScore"
								+ j
								+ "' class='zz'>"
								+ testInfo[i].mScore
								+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></b></tr>");

		if (testInfo[i].answer == testInfo[i].myAnswer) {//考生答案和正确答案一致时，显示绿色
			$('#' + j + '').css('background-color', 'green');
		} else {
			$('#' + j + '').css('background-color', 'red');//不一致显示红色
		}
	}
	$('#bt').html(testInfo[0].name+"(总分："+testInfo[0].sumScore+"    所得："+sScore+")");
	$('#label1').html(j-t2);
	$('#label3').html(t2);
	if(t2>0){
		$("#duo").show();
	}if(j-t2>0){
		$("#dan").show();
	}
	

}