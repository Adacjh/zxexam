<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/teacher.css" />
<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../js/teacher.js"></script>
</head>
<body>
<h2>教&nbsp;&nbsp;&nbsp;&nbsp;师&nbsp;&nbsp;&nbsp;&nbsp;管&nbsp;&nbsp;&nbsp;&nbsp;理</h2>
<p align="right">一共有<b id="infoSize"></b>条信息</p>
<table id="table1">
  <tr>
    <td>教师编号</td>
    <td>姓名</td>
    <td>账号</td>
    <td>密码</td>
    <td>性别</td>
    <td>手机号码</td>
    <td>注册时间</td>
    <td>操作</td>
  </tr>
</table>
<div
		style="width: 500px; height: 55px; text-align: center; margin-left: 29%; "id="pageNav">
		<input type="hidden" id="pageNumH">
		
	</div>
	<script type="text/javascript" src="../js/pagenav.cn.js"></script>
	<script type="text/javascript">
		//输出页码,可根据需要重写此方法
		pageNav.go = function(p, pn, ifGo) {
			$("#pageNav").html(this.nav(p, pn));

		}
		window.onload = (function() {
			// optional set
			pageNav.pre = "&laquo;";
			pageNav.next = "&raquo;";
			// p,当前页码,pn,总页面
			//pageNav.fn = function(p,pn){$("#pageinfo").text("当前页:"+p+" 总页: "+pn);};
			//重写分页状态,跳到第三页,总页33页
			$.ajax({
				type : "POST",
				dataType : 'json',
				url : "../../user/getPageInfo1.do",
				async : false,
				success : function(json) {
					jsObject1 = json;
				}
			});
			//$('#userSum').text(jsObject1[0].infoSize);
			var pageSize = jsObject1[0].pageSize;
			//alert("${gopage}")
			pageNav.go(1, pageSize, false);//控制分页数
		});
		$('.table-sort').dataTable({
			"lengthMenu" : false,//显示数量选择 
			"bFilter" : false,//过滤功能
			"bPaginate" : false,//翻页信息
			"bInfo" : false,//数量信息
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [
			{"bVisible": false, "aTargets": [ 3 ]},//控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0 ]
			} // 制定列不参与排序
			]
		});
	</script>
</body>
</html>