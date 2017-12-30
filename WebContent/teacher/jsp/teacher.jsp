<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../admin/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../js/teacher.js"></script>

<link rel="stylesheet" href="../css/teacher.css" />
</head>
<body>
	<div id="main">
		<div id="top">
			<div id="top1">
				<p>
					<font>当前用户:${sessionScope.userName}</font>
				</p>
				<input type="hidden" value="${sessionScope.userName}" id="getName" />

				<ul>
					<li><button type="button" class="btn btn-link" id="outSystem">退出系统</button></li>
					<li><button type="button" class="btn btn-link" id="passWordRe">修改密码</button></li>
					<li><button type="button" class="btn btn-link" id="searchScore">成绩查询</button></li>
				</ul>
			</div>
		</div>
		<div id="testChoice">
			<iframe></iframe>
		</div>

	</div>

</body>
</html>