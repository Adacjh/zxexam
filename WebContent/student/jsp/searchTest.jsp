<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../admin/js/jquery-1.7.2.js"></script>
<link rel="stylesheet" href="../css/searchTest.css" />
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/searchTest.js"></script>
</head>
<body>
<h2 style="text-align: center;" id="bt"></h2>
<input type="hidden" value="<%=request.getParameter("testId")%>" id="testId"/>

<input type="hidden" value="<%=request.getParameter("userId")%>" id="userId"/>
<input type="hidden" value="<%=request.getParameter("sScore")%>" id="sScore"/>
<table id="table1" class="table">
	<tr id="dan"><td >一、单选题（<label id="label1"></label>*<label id="label2"></label>'）</td></tr>
	</table>
	<table id="table2" class="table">
	<tr id="duo"><td>二、多选题（<label id="label3"></label>*<label id="label4"></label>'）</td></tr>
		
	</table>
</body>
</html>