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
				"</td><td style='width: 14%; text-align: center;'>" +
				"<button type='button' class='btn' onclick='search("+studentInfo[i].userId+")'>查看</button>" +
						"</td></tr>"
				);
		
	}
});


function search(id){
		window.location.href="../jsp/searchScoreInfo.jsp?id="+id;
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
				"</td><td style='width: 14%; text-align: center;'>" +
				"<button type='button' class='btn' onclick='search("+studentInfo[i].userId+")'>查看</button>" +
						"</td></tr>"
				);
		
	}
}