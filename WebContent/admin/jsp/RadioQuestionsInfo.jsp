<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/radioQuestionsInfo.css" />
<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../js/radioQuestionsInfo.js"></script>
</head>
<body>
<input type="hidden" id="subId" value="<%=request.getParameter("subId")%>"/>
<h2><font id="subName"></font>&nbsp;&nbsp;基&nbsp;&nbsp;础&nbsp;&nbsp;单&nbsp;&nbsp;选&nbsp;&nbsp;试&nbsp;&nbsp;题&nbsp;&nbsp;管&nbsp;&nbsp;理</h2>
	<table id="table1">
		
	</table>
	
</body>
</html>