<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/searchScoreInfo.css" />
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../admin/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../js/searchScoreInfo.js"></script>
</head>
<body>
<input type="hidden" value="<%=request.getParameter("id")%>" id="userId"/>
<table id="table1"  class="table" >
<tr><td>试卷名</td><td>考试时间</td><td>考生</td><td>总分</td><td>得分</td></tr>
</table>
</body>
</html>