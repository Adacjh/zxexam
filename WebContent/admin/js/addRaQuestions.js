/**
 * 
 */
$(document).ready(function(){
	$.ajax({
		type : "POST",
		url : "../../questions/getAllsub.do",
		dataType : "json",
		async : false,
		success : function(json) {
			for ( var i in json) {
				$('#radioSubName').append(
						"<option id='" + json[i].code + "' value='"+json[i].code+"'>"+json[i].value+"</option>");
			}
		}
	});
	$('button').click(function (){
	var jj=	$('#simple-editor').html();
	$('input#xianshi').val(jj);
		var errorMessage;
		$.ajax({
			type : "POST",
			dataType : 'text',
			url : "../../questions/addRaQuestion.do",
			data : $('#submitform').serialize(),
			async : false,
			success : function(json) {
				errorMessage = json;
				alert(errorMessage)
				window.location.href = "../jsp/addRaQuestions.jsp";
			}
		});
	});
})