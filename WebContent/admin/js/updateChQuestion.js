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
				$('#checkSubName').append(
						"<option id='" + json[i].code + "' value='"+json[i].code+"'>"+json[i].value+"</option>");
			}
		}
	});
	$.ajax({
		type : "POST",
		url : "../../questions/getAllsub.do",
		dataType : "json",
		async : false,
		success : function(json) {
			for ( var i in json) {
				$('#checkSubName').append(
						"<option id='" + json[i].code + "' value='"+json[i].code+"'>"+json[i].value+"</option>");
			}
		}
	});
	var id=$("#hiddenId").val();
	$.ajax({
		type : "POST",
		dataType:"json",
		url : "../../questions/getQuestionsById.do",
		data : "id=" + id+"&type="+2,
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
			data : $('#submitform').serialize()+"&type="+2,
			async : false,
			success : function(json) {
				window.history.go(-1);
			}
		});
	});
});
function setInfo(date){
	$('#simple-editor').html(date[0].checkContent);
	$('#checkAnswerA').val(date[0].checkAnswerA);
	$('#checkAnswerB').val(date[0].checkAnswerB);
	$('#checkAnswerC').val(date[0].checkAnswerC);
	$('#checkAnswerD').val(date[0].checkAnswerD);
	var ff=new Array()
	 ff	=date[0].checkAnswer.split(",");
	for(var i in ff){
		if(ff[i]=="A"){$('#A').attr("checked","checked")}
		if(ff[i]=="B"){$('#B').attr("checked","checked")}
		if(ff[i]=="C"){$('#C').attr("checked","checked")}
		if(ff[i]=="D"){$('#D').attr("checked","checked")}
	}
	if(date[0].checkDifficulty==1){$('#jian').attr("selected","selected")}
	if(date[0].checkDifficulty==2){$('#kun').attr("selected","selected")}
	if(date[0].checkSubName==2){$('#2').attr("selected","selected")}
	if(date[0].checkSubName==3){$('#3').attr("selected","selected")}
	if(date[0].checkSubName==4){$('#4').attr("selected","selected")}
	
	
	
	
}