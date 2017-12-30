/**
 * 
 */
$(document).ready(function (){
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
	var id=$("#hiddenId").val();
	$.ajax({
		type : "POST",
		dataType:"json",
		url : "../../questions/getQuestionsById.do",
		data : "id=" + id+"&type="+1,
		async : false,
		success : function(json) {
			setInfo(json)
		}
	});
	$('#save').click(function (){
		$('#xianshi').val($('#simple-editor').html());
		$.ajax({
			type : "POST",
			dataType : 'text',
			url : "../../questions/updateQuestions.do",
			data : $('#submitform').serialize()+"&type="+1,
			async : false,
			success : function(json) {
				window.history.go(-1);
			}
		});
	});
});
function setInfo(date){
	$('#simple-editor').html(date[0].radioContent);
	$('#radioAnswerA').val(date[0].radioAnswerA);
	$('#radioAnswerB').val(date[0].radioAnswerB);
	$('#radioAnswerC').val(date[0].radioAnswerC);
	$('#radioAnswerD').val(date[0].radioAnswerD);
	$('#radioAnswer').val();
	if(date[0].radioAnswer=="A"){$('#A').attr("checked","checked")}
	if(date[0].radioAnswer=="B"){$('#B').attr("checked","checked")}
	if(date[0].radioAnswer=="C"){$('#C').attr("checked","checked")}
	if(date[0].radioAnswer=="D"){$('#D').attr("checked","checked")}
	if(date[0].radioDifficulty==1){$('#jian').attr("selected","selected")}
	if(date[0].radioDifficulty==2){$('#kun').attr("selected","selected")}
	if(date[0].radioSubName==2){$('#2').attr("selected","selected")}
	if(date[0].radioSubName==3){$('#3').attr("selected","selected")}
	if(date[0].radioSubName==4){$('#4').attr("selected","selected")}
	
	
	
	
}