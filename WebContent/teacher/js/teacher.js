/**
 * 
 */
$(document).ready(function(){
	$('#searchScore').click(function (){
		$('iframe').attr("src", "scoreInfo.jsp");
	});
	$("#outSystem").click(function() {
		window.location.href = "../../jsp/login.jsp"
	});
	$("#passWordRe").click(function() {
		$('iframe').attr("src", "../jsp/passWordRe.jsp");
	});
})