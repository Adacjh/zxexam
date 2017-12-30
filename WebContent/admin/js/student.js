/**
 * 
 */
$(document).ready(function() {
	var studentInfo;
	var size;
	$.ajax({
		type : "POST",
		dataType : 'json',
		url : "../../user/getStudentInfo.do",
		data : "number=1",
		async : false,
		success : function(json) {
			studentInfo = json;
		}
	});
	$.ajax({
		type : "POST",
		dataType : 'json',
		url : "../../user/getPageInfo.do",
		async : false,
		success : function(json) {
			size = json;
		}
	});
	$('#infoSize').html(size[0].pageSum)
	for(var i in studentInfo){
		$("#table1").append(
				"<tr class='tr1'><td>" +studentInfo[i].userId +
				"</td><td>" + studentInfo[i].userName +
				"</td><td>" + studentInfo[i].userAccountNumber +
				"</td><td>" + studentInfo[i].userPassword +
				"</td><td>" + studentInfo[i].userValue +
				"</td><td>" + studentInfo[i].userPhone +
				"</td><td>" + studentInfo[i].userDate +
				"</td><td style='width: 14%; text-align: center;'>" +
				"<button type='button' class='btn' onclick='del("+studentInfo[i].userId+")'>删除</button>" +
						"</td></tr>"
				);
		
	}
});


function del(id){
	var studentInfo;
	var pageSum=$('#infoSize').html();
	var pageId=$('#pageId').html();
	var pageNumber;
	var page;
	$.ajax({
		type : "POST",
		dataType : 'json',
		url : "../../user/delStudentInfo.do",
		data : "userId="+id+"&pageId="+pageId,
		async : false,
		success : function(json) {
			studentInfo = json;
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
	for(var i in studentInfo){
		$("#table1").append(
				"<tr class='tr1'><td>" +studentInfo[i].userId +
				"</td><td>" + studentInfo[i].userName +
				"</td><td>" + studentInfo[i].userAccountNumber +
				"</td><td>" + studentInfo[i].userPassword +
				"</td><td>" + studentInfo[i].userValue +
				"</td><td>" + studentInfo[i].userPhone +
				"</td><td>" + studentInfo[i].userDate +
				"</td><td style='width: 14%; text-align: center;'>" +
				"<button type='button' class='btn' onclick='del("+studentInfo[i].userId+")'>删除</button>" +
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
		url : "../../user/getStudentInfo.do",
		data : number,
		async : false,
		success : function(json) {
			studentInfo = json;
		}
	});
	$('.tr1').remove();
	for(var i in studentInfo){
		$("#table1").append(
				"<tr class='tr1'><td>" +studentInfo[i].userId +
				"</td><td>" + studentInfo[i].userName +
				"</td><td>" + studentInfo[i].userAccountNumber +
				"</td><td>" + studentInfo[i].userPassword +
				"</td><td>" + studentInfo[i].userValue +
				"</td><td>" + studentInfo[i].userPhone +
				"</td><td>" + studentInfo[i].userDate +
				"</td><td style='width: 14%; text-align: center;'>" +
				"<button type='button' class='btn' onclick='del("+studentInfo[i].userId+")'>删除</button>" +
						"</td></tr>"
				);
		
	}
}