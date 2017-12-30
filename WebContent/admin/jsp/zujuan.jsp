<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/zujuan.css" />
<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../js/zujuan.js"></script>
</head>
<body>
	<h2 style="text-align: center;">自动组卷</h2>
	<div id="button">
		<button class="btn btn-primary" id="button1">增加题型</button>
		<button class="btn btn-primary" id="button2">自动组卷</button>
	</div>
	<form id="submitform">
		<table style="margin: 50px auto" id="table1">
			<tr>
				<td colspan="5">
						<select class="form-control" id="subName" name="subName" style="width: 198px; float: left;">
							<option value="0">--选择科目--</option>
						</select>
					<input type="text" class="form-control" placeholder="请输入试卷名称"
							name="zujuanName" style="width: 198px; float: left;">
							<input type="text" class="form-control" placeholder="请输入考试时间(分钟)"
							name="testTime" id="testTime" style="width: 198px; float: left;margin-bottom: 10px;">
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<select name="zujuanType" class="form-control">
							<option value="0">--选择题型--</option>
							<option value="1">单选题</option>
							<option value="2">多选题</option>

						</select>
					</div>
				</td>
				<td>
					<div class="form-group">
						<select name="zujuanDifficulty" class="form-control">
							<option value="0">--选择难度--</option>
							<option value="1">简单</option>
							<option value="2">困难</option>
						</select>
					</div>
				</td>
				<td>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="试题数量"
							name="zujuanNumber">
					</div>
				</td>
				<td><div class="form-group">
						<input type="text" class="form-control" placeholder="每题分值"
							name="zujuanScore"> <input type="hidden" name="len"
							id="len" />
					</div></td>

				<td onclick='del(this)'>&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="btn btn-primary" id="bun1">删除</button>
				</td>

			</tr>
		</table>
	</form>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>