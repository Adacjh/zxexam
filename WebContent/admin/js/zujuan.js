/**
 * 
 */
$(document)
		.ready(
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
					$('#button1')
							.click(
									function() {//添加题型
										$("#table1")
												.append(
														"<tr><td><div class='form-group'>"
																+ "<select name='zujuanType' class='form-control'>"
																+ "<option value='0'>--选择题型--</option>"
																+ "<option value='1'>单选题</option>"
																+ "<option value='2'>多选题</option>"
																+ "</select></div></td><td><div class='form-group'>"
																+ "<select name='zujuanDifficulty' class='form-control'>"
																+ "<option value='0'>--选择难度--</option>"
																+ "<option value='1'>简单</option>"
																+ "<option value='2'>困难</option></select>"
																+ "</div></td><td><div class='form-group'>"
																+ "<input type='text' class='form-control' placeholder='试题数量' name='zujuanNumber'>"
																+ "</div></td><td><div class='form-group'>"
																+ "<input type='text' class='form-control' placeholder='每题分值' name='zujuanScore'>"
																+ "</div></td><td onclick='del(this)'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 
																+ "<button class='btn btn-primary' id='bun1'>删除</button></td></tr>");

									});
					$('#button2').click(function() {//自动组卷
						var jsObject;
						if($('#subName').val()!='0'&&$('#testTime').val()!=""){
						$.ajax({
							type : "POST",
							dataType : 'text',
							url : "../../test/addTest.do",
							data : $('#submitform').serialize(),
							async : false,
							success : function(json) {
								if(json=='success'){
									window.location.href="../jsp/zujuan.jsp";
								}else {
									alert(json)
								}
							}
						});
						}else{
						
							 alert("请选择正确的科目")
						}
						
					});

				});
function del(id) {
	$(id).parent().remove();
}
