<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/studentRegist.css" />
<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../js/studentRegist.js"></script>
</head>
<body>
<div id="main">
	<div id="top"></div>
	<div id="mid">
		<form id="submitform">
			<table >
				<tr>
					<td colspan="2" id="td1"><font size="4.5px"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;考生注册</strong></font></td>
				</tr>
				<tr>
					<td id="td2"><font size="3px">用户账号：</font></td>
					<td><input type="text" name="userAccountNumber"/></td>
					<td><font color="red" size="2px">* 必填</font></td>
				</tr>
				<tr>
					<td id="td2"><font size="3px">真实姓名：</font></td>
					<td><input type="text" name="userName"/></td>
					<td><font color="red" size="2px">* 必填</font></td>
				</tr>
				<tr>
					<td id="td2"><font size="3px">用户密码：</font></td>
					<td><input type="text" name="userPassword"/></td>
					<td><font color="red" size="2px">* 必填</font></td>
				</tr>
				<tr>
					<td id="td2"><font size="3px">确认密码：</font></td>
					<td><input type="text" name="userPasswordAgain"/></td>
					<td><font color="red" size="2px">* 必填</font></td>
				</tr>
				<tr>
					<td id="td2"><font size="3px">用户性别：</font></td>
					<td><input type="radio" name="userSex" value="1"/>男 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="userSex" value="0"/>女
					</td>
				</tr>
				<tr>
					<td id="td2"><font size="3px">手机号码：</font></td>
					<td><input type="text" name="userPhone"/></td>
					<td><font color="red" size="2px">* 必填</font></td>
				</tr>
				<tr>
				<td></td>
				</tr>
				<tr>
				    <td class="c1"><input type="button" value="注册" id="regist" /></td>
					<td class="c1"><input type="reset" value="重置" id="reset" /></td>
				</tr>
			</table>
		</form>
	</div>
	</div>
</body>
</html>