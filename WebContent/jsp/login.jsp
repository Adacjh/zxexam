<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/login.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css" />
</head>
<body>
	<form id="submitform1">
		<div id="passWordDiv">
		<b id="b">X</b>
			<table  id="tableDiv">
				<tr>
					<td colspan="2" style="text-align: center;"><h2>密码重置</h2></td>
				</tr>
				<tr><td id="userNick">用户账号</td><td ><input type="text" id="userAccountNumber" name="userAccountNumber" class="blurYz"/></td></tr>
				<tr><td >用户电话</td><td><input type="text" id="userPhone" name="userPhone" class="blurYz"/></td></tr>
				
				<tr class="rightShow"><td >密码</td><td><input type="text" id="userPassword" name="userPassword"/></td></tr>
				<tr  class="rightShow"><td >确认密码</td><td><input type="text" id="userPasswordAgain" name="userPasswordAgain"/></td></tr>
		<tr><td colspan="2" style="text-align: center;"><button type="button" id="rePassWord">密码重置</button></td></tr>
			</table>

		</div>
	</form>
	<form id="submitform">
		<div id="d1">
			<div id="div2">
				<table border="0">
					<tr>
						<td>请选择身份</td>
						<td><select name="userRole" id="userRole">
								<option value="1" selected="selected" id="admin">管理员</option>
								<option value="2" id="teacher">教师</option>
								<option value="3" id="student">考生</option>
						</select></td>
					</tr>
					<tr>
						<td id="name">管理员</td>
						<td><input type="text" name="userAccountNumber" id="userName"></td>
					</tr>
					<tr>
						<td><br>密码</td>
						<td><br> <input type="password" name="userPassword"></td>
					</tr>
					<tr>
						<td colspan=""><input type="button" value="登录" id="login" /></td>
						<td colspan="" id=><input type="button" value="注册"
							id="regist" /> <input type="button" value="忘记密码"
							id="forgetPassWord" /></td>
					</tr>



				</table>

			</div>
		</div>
	</form>
</body>
</html>