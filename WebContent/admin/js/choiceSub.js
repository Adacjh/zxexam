/**
 * 
 */
$(document).ready(
		function() {
			$.ajax({
				type : "POST",
				url : "../../questions/getAllsub.do",
				dataType : "json",
				async : false,
				success : function(json) {
					for ( var i in json) {
						$('#subName').append(
								"<option id='" + json[i].code + "' value='"+json[i].code+"'>"+json[i].value+"</option>");
					}
				}
			});
		});