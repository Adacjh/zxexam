/**
 * 
 */
$(document).ready(function() {
	var teacherInfo;
	var size;
	$.ajax({
		type : "POST",
		dataType : 'json',
		url : "../../user/getTeacherInfo.do",
		data : "number=1",
		async : false,
		success : function(json) {
			teacherInfo = json;
		}
	});
	$.ajax({
		type : "POST",
		dataType : 'json',
		url : "../../user/getPageInfo1.do",
		async : false,
		success : function(json) {
			size = json;
		}
	});
	$('#infoSize').html(size[0].pageSum)
	for(var i in teacherInfo){
		$("#table1").append(
				"<tr class='tr1'><td>" +teacherInfo[i].userId +
				"</td><td>" + teacherInfo[i].userName +
				"</td><td>" + teacherInfo[i].userAccountNumber +
				"</td><td>" + teacherInfo[i].userPassword +
				"</td><td>" + teacherInfo[i].userValue +
				"</td><td>" + teacherInfo[i].userPhone +
				"</td><td>" + teacherInfo[i].userDate +
				"</td><td style='width: 14%; text-align: center;'>" +
				"<button type='button' class='btn' onclick='del("+teacherInfo[i].userId+")'>删除</button>" +
						"</td></tr>"
				);
		
	}
});


function del(id){
	var teacherInfo;
	var pageSum=$('#infoSize').html();
	var pageId=$('#pageId').html();
	var pageNumber;
	var page;
	$.ajax({
		type : "POST",
		dataType : 'json',
		url : "../../user/delTeacherInfo.do",
		data : "userId="+id+"&pageId="+pageId,
		async : false,
		success : function(json) {
			teacherInfo = json;
			pageSum=pageSum-1;
			$('#infoSize').html(pageSum);
			if (pageSum <= 5) {
				pageNumber = 1;
				
			} else if (pageSum % 5 != 0) {
				pageNumber = (pageSum / 5) + 1;
			} else {
				pageNumber= pageSum / 5;
			}
			var ss=(pageId-1)*5;
			if(pageSum<ss){
				pageId=pageId-1;
			}
			pageNav.go(pageId, pageNumber, false);
		}
	});
	$('.tr1').remove();
	for(var i in teacherInfo){
		$("#table1").append(
				"<tr class='tr1'><td>" +teacherInfo[i].userId +
				"</td><td>" + teacherInfo[i].userName +
				"</td><td>" + teacherInfo[i].userAccountNumber +
				"</td><td>" + teacherInfo[i].userPassword +
				"</td><td>" + teacherInfo[i].userValue +
				"</td><td>" + teacherInfo[i].userPhone +
				"</td><td>" + teacherInfo[i].userDate +
				"</td><td style='width: 14%; text-align: center;'>" +
				"<button type='button' class='btn' onclick='del("+teacherInfo[i].userId+")'>删除</button>" +
						"</td></tr>"
				);
		
	}
}
function start(number){
	var number={
			"number":number
	}
	$.ajax({
		type : "POST",
		dataType : 'json',
		url : "../../user/getTeacherInfo.do",
		data : number,
		async : false,
		success : function(json) {
			teacherInfo = json;
		}
	});
	$('.tr1').remove();
	for(var i in teacherInfo){
		$("#table1").append(
				"<tr class='tr1'><td>" +teacherInfo[i].userId +
				"</td><td>" + teacherInfo[i].userName +
				"</td><td>" + teacherInfo[i].userAccountNumber +
				"</td><td>" + teacherInfo[i].userPassword +
				"</td><td>" + teacherInfo[i].userValue +
				"</td><td>" + teacherInfo[i].userPhone +
				"</td><td>" + teacherInfo[i].userDate +
				"</td><td style='width: 14%; text-align: center;'>" +
				"<button type='button' class='btn' onclick='del("+teacherInfo[i].userId+")'>删除</button>" +
						"</td></tr>"
				);
		
	}
}