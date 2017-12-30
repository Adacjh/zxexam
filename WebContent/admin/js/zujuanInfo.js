/**
 * 
 */
$(document)
		.ready(
				function() {
					var zujuanInfo;
					$.ajax({
						type : "POST",
						dataType : 'json',
						url : "../../test/zujuanInfo.do",
						data : "number=1",
						async : false,
						success : function(json) {
							zujuanInfo = json;
						}
					});
					for ( var i in zujuanInfo) {
						$("#table1")
								.append(
										"<tr class='tr1 "+zujuanInfo[i].subjectId+"'><td>"
												+ zujuanInfo[i].subjectId
												+ "</td><td>"
												+ zujuanInfo[i].subName
												+ "</td><td><a href='javaScript:;' onclick='searchInfo("
												+ zujuanInfo[i].subjectBianhao
												+ ")'>"
												+ zujuanInfo[i].subjectName
												+ "</a></td><td>"
												+ zujuanInfo[i].subjectBianhao
												+ "</td><td>"
												+ zujuanInfo[i].testTime
												+ "</td><td>"
												+ zujuanInfo[i].subjectDate
												+ "</td><td style='width: 14%; text-align: center;'>"
												+ "<button type='button' class='btn' onclick='del("
												+ zujuanInfo[i].subjectId
												+ ")'>删除</button>"
												+ "</td></tr>");

					}
				});

function searchInfo(id) {
	window.location.href = "../jsp/subTestInfo.jsp?id=" + id;
}
function del(id){
	$.ajax({
		type : "POST",
		dataType : 'text',
		url : "../../test/delTestInfo.do",
		data : "id="+id,
		async : false,
		success : function(json) {
		$("."+id+"").hide();
		}
	});
}