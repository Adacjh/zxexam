<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../admin/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../js/test.js"></script>
 <link rel="stylesheet" href="../css/test.css" />
<style type="text/css">

h1 {

	font-family:"微软雅黑";

	font-size:40px;

	margin:20px 0;

	border-bottom:solid 1px #ccc;

	padding-bottom:20px;

	letter-spacing:2px;

}

.time-item strong {

	background:#C71C60;

	color:#fff;

	line-height:49px;

	font-size:36px;

	font-family:Arial;

	padding:0 10px;

	margin-right:10px;

	border-radius:5px;

	box-shadow:1px 1px 3px rgba(0,0,0,0.2);

}

#day_show {

	float:left;

	line-height:49px;

	color:#c71c60;

	font-size:32px;

	margin:0 10px;

	font-family:Arial,Helvetica,sans-serif;

}

.item-title .unit {

	background:none;

	line-height:49px;

	font-size:24px;

	padding:0 10px;

	float:left;

}



</style>
</head>
<body>
<div class="time-item">

	<span id="day_show">距离考试结束还有</span>

	<strong id="hour_show">0时</strong>

	<strong id="minute_show">0分</strong>

	<strong id="second_show">0秒</strong>

</div>
<input type="hidden" value="<%=request.getParameter("testId")%>" id="testInfo">
<div id="submitTest"><button type="button" id="submit" onclick="submit()">提交考试</button></div>
<form id="submitform">
<table id="table1">
	<tr><td id="dan">单选题（<label id="label1"></label>*<label id="label2"></label>'）</td></tr>
		
	</table>
	</form>
	<form id="submitform1">
	<table id="table2">
	<tr><td id="duo">多选题（<label id="label3"></label>*<label id="label4"></label>'）</td></tr>
		
	</table>
	</form>
	
</body>



</html>