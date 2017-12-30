<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
	<div>
		<select id="subName"><option value="0" id="choice"></option></select>
		<button id="qr">确认</button>
	</div>
	<input type="hidden" id="type"
		value="<%=request.getParameter("type")%>">
	<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="../js/choiceSub.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							
							var type = $('#type').val();
							if (type == '1') {
								$('#choice').text('--请选择单选题科目--');

							} else if (type == '2') {
								$('#choice').text('--请选择多选题科目--');
							}
							$('#qr')
									.click(
											function() {
												var subId = $('#subName').val();
												if (subId == '0') {
													alert("请选择正确的科目")
												} else {
													if (type == '1') {
														window.location.href = "../jsp/RadioQuestionsInfo.jsp?subId="
																+ subId;
													} else {
														window.location.href = "../jsp/CheckQuestionsInfo.jsp?subId="
																+ subId;
													}
												}

											});
						});
	</script>
</body>

</html>