<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/teacherAdd.css" />
<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../js/teacherAdd.js"></script>
</head>
<body>
<div id="main">
	<div id="mid">
		<form id="submitform">
			<table >
				<tr>
					<td colspan="2" id="td1" style="text-align: center;">老师添加</td>
				</tr>
				<tr>
					<td>真实姓名：</td>
					<td><input type="text" name="userName"/></td>
					<td><font color="red" size="2px">* 必填</font></td>
				</tr>
				<tr>
					<td>教师性别：</td>
					<td><input type="radio" name="userSex" value="1" checked="checked"/>男 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="userSex" value="0"/>女
					</td>
				</tr>
				<tr>
					<td>手机号码：</td>
					<td><input type="text" name="userPhone"/></td>
					<td><font color="red" size="2px">* 必填</font></td>
				</tr>
				<tr>
				<td><br/></td>
				</tr>
				<tr>
				    <td class="c1"><input type="button" value="添加" id="regist" /></td>
				</tr>
			</table>
		</form>
	</div>
	</div>
</body>
</html>