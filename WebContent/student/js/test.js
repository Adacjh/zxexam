/**
 * 
 */

var j = 0;
var n = 0;
var info;
var info2;
var info3;
var info1;
var daInfo;
var bh;
var number1
var testTime;
$(document)
		.ready(
				function() {
					$("#dan").hide();
					$("#duo").hide();
					var testId = $("#testInfo").val();//获取试卷的ID
					number1 = testId;
					var number;
					testId = testId + "";
					var zuJuan = {
						"questionBh" : testId
					}
					var type;
					$.ajax({//获取单选题
						type : "POST",// 提交类型
						url : "../../student/actionTest.do",
						dataType : "json",
						data : "questionBh=" + testId + "&type=" + 1,
						async : false,// 异步
						success : function(json) {
							info = json;
							daInfo=json;
							info3=json;
						}
					});
					$.ajax({//获取多选题
						type : "POST",// 提交类型
						url : "../../student/actionTest.do",
						dataType : "json",
						data : "questionBh=" + testId + "&type=" + 2,
						async : false,// 异步
						success : function(json) {
							info1 = json;
						}
					});

					for ( var i in info) {//将获取的试题显示到页面上
						j = j + 1;
						$("#table1")
								.append(
										"<tr><td>"
												+ j
												+ "、&nbsp;&nbsp;"
												+ info[i].radioContent
												+ "</td></tr><tr><td>"
												+ "A.&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' id='answer"
												+ j
												+ "' name='answer"
												+ j
												+ "' value='"
												+ info[i].radioId
												+ ","
												+ info[i].score
												+ ",A'/>"
												+ info[i].radioAnswerA
												+ "</td></tr><tr><td>"
												+ "B.&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' id='answer"
												+ j
												+ "' name='answer"
												+ j
												+ "' value='"
												+ info[i].radioId
												+ ","
												+ info[i].score
												+ ",B'/>"
												+ info[i].radioAnswerB
												+ "</td></tr><tr><td>"
												+ "C.&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' id='answer"
												+ j
												+ "' name='answer"
												+ j
												+ "' value='"
												+ info[i].radioId
												+ ","
												+ info[i].score
												+ ",C'/>"
												+ info[i].radioAnswerC
												+ "</td></tr><tr><td>"
												+ "D.&nbsp;&nbsp;&nbsp;&nbsp;<input type='radio' id='answer"
												+ j + "' name='answer" + j
												+ "' value='" + info[i].radioId
												+ "," + info[i].score + ",D'/>"
												+ info[i].radioAnswerD
												+ "</td></tr>");
						$('#label1').html(j);
						
						$('#label2').html(info[0].score);
						if(j>0){
							testTime=info3[0].testTime
						}
						
					}
					if (j > 0) {
						$("#dan").show();
					}
					for ( var d in info1) {
						n = n + 1;
						$("#table2")
								.append(
										"<tr><td>"
												+ n
												+ "、&nbsp;&nbsp;"
												+ info1[d].checkContent
												+ "</td></tr><tr><td>"
												+ "A.&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' id='cAnswer"
												+ n
												+ "' name='cAnswer"
												+ n
												+ "' value='A'/>"
												+ info1[d].checkAnswerA
												+ "</td></tr><tr><td>"
												+ "B.&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' id='cAnswer"
												+ n
												+ "' name='cAnswer"
												+ n
												+ "' value='B'/>"
												+ info1[d].checkAnswerB
												+ "</td></tr><tr><td>"
												+ "C.&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' id='cAnswer"
												+ n
												+ "' name='cAnswer"
												+ n
												+ "' value='C'/>"
												+ info1[d].checkAnswerC
												+ "</td></tr><tr><td>"
												+ "D.&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' id='cAnswer"
												+ n + "' name='cAnswer" + n
												+ "' value='D'/>"
												+ info1[d].checkAnswerD
												+ "</td></tr>");
						$('#label3').html(n);
						if(n>0){
						testTime=info1[0].testTime
						}
						$('#label4').html(info1[0].score);
					}

					if (n > 0) {
						$("#duo").show();
					}
					if(testTime>0){timer(testTime*60);}
					
				});
function testAjax(answer) {
	$.ajax({//保存学生单选题的答案

		type : "POST",// 提交类型
		url : "../../student/testChoiceSave.do",
		dataType : "text",
		data : "answer=" + answer + "&bh=" + bh,
		async : false,// 异步
		success : function(json) {
			info = json;
			bh = info;
		}
	});
}
function testAjax1(answer, testId, cAanwer, score) {//保存学生多选题的答案
	var score = {
		"myAnswer" : answer,
		"testId" : testId,
		"answer" : cAanwer,
		"score" : score,
		"number" : bh
	}
	$.ajax({
		type : "POST",// 提交类型
		url : "../../student/testCheckSave.do",
		dataType : "text",
		data : score,
		async : false,// 异步
		success : function(json) {
			info = json;
			if (info == "") {

			} else {
				bh = info;
			}
		}
	});
}
function testSuccess(number1) {//考试成功显示得分信息
	var score = {
		"testId" : number1,
		"number" : bh
	}
	$.ajax({
		type : "POST",// 提交类型
		url : "../../student/studentTestSave.do",
		dataType : "text",
		data : score,
		async : false,// 异步
		success : function(json) {
			info = json;
			alert("得分" + info);
			window.location.href = "../jsp/testChoice.jsp"
		}
	});
}
function timer(intDiff) {

	window.setInterval(function() {
		var day = 0,

		hour = 0,

		minute = 0,

		second = 0;// 时间默认值

		if (intDiff > 0) {

			day = Math.floor(intDiff / (60 * 60 * 24));

			hour = Math.floor(intDiff / (60 * 60)) - (day * 24);

			minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);

			second = Math.floor(intDiff) - (day * 24 * 60 * 60)
					- (hour * 60 * 60) - (minute * 60);

		}

		if (minute <= 9)
			minute = '0' + minute;

		if (second <= 9)
			second = '0' + second;

		$('#hour_show').html('<s id="h"></s>' + hour + '时');

		$('#minute_show').html('<s></s>' + minute + '分');

		$('#second_show').html('<s></s>' + second + '秒');

		intDiff--;
		if (intDiff == -1) {
			alert("考试时间已到，自动交卷");

			submit();
		}

	}, 1000);

}

function submit() {//提交试卷
	var errer = "未答题"
	for (var i = 1; i <= j; i++) {//j是单选题的数量
		var daan=daInfo[i-1].radioAnswer;//获取答案
		var answer = $("input[name='answer" + i + "']:checked").val();//通过name值获取value值
		if (answer == undefined) {
			var answer1 = $("#answer" + i).val();
			answer1 = answer1.substring(0, answer1.length - 2);
			answer = answer1 + "," + errer+","+daan;
		}else{
			answer=answer+","+daan;
		}
		testAjax(answer);
	}

	for (var c = 1; c <= n; c++) {
		var s = "";
		var h;
		var u = "";
		var o = ",";
		var cTestId = info1[c - 1].checkId
		var cAnswer = info1[c - 1].checkAnswer
		var score = info1[c - 1].score
		$("input[name='cAnswer" + c + "']:checked").each(function() {

			s = this.value;
			h = s;
			u = u + h + o;

			// $('#show').append(this.value
			// + " ");
		});
		if (u == "") {
			testAjax1("未答题", cTestId, cAnswer, score);

		} else {
			testAjax1(u, cTestId, cAnswer, score);
		}

	}
	testSuccess(number1);
}