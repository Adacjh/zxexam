<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../admin/js/jquery-1.7.2.js"></script>
<link rel="stylesheet" href="../css/passWordRe.css" />
<script type="text/javascript" src="../js/passWordRe.js"></script>
</head>
<body>
<form id="submitform">
<table>
<tr><td>请输入原密码</td><td><input type="text" id="oldPassWork"/></td></tr>
<tr><td>请输入新密码</td><td><input type="text" id="userPassword" name="userPassword"/></td></tr>
<tr><td>确认新密码</td><td><input type="text" id="userPasswordAgain" name="userPasswordAgain"/></td></tr>
<tr><td><button id="save" type="button">修改密码</button></td></tr>
</table>
</form>
</body>
</html>