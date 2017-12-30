<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/subTestInfo.css" />
<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../js/subTestInfo.js"></script>
</head>
<body>
<h2 id="h2"></h2>
<input type="hidden" id="testId" value="<%=request.getParameter("id")%>">
	<table id="table1" style="display: none;" >
	<tr><td >单选题（<label id="label1"></label>*<label id="label2"></label>'）</td></tr>
		
	</table>
	<table id="table2" style="display: none;"> 
	<tr><td>多选题（<label id="label3"></label>*<label id="label4"></label>'）</td></tr>
		
	</table>
	
</body>
</html>