<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../js/admin.js"></script>
<link rel="stylesheet" href="../css/admin.css" />
<style type="text/css">
body{margin:0;padding:0;overflow-x:hidden;}
html, body{height:90%;}
img{border:none;}
*{font-family:'微软雅黑';font-size:12px;color:#626262;}
dl,dt,dd{display:block;margin:0;}
a{text-decoration:none;}

#bg{background-image:url(../images/content/dotted.png);}
.container{width:100%;height:100%;margin:auto;}

/*left*/
.leftsidebar_box{width:160px;height:auto !important;overflow:visible !important;height:100% !important;background-color:#3992d0;}
.line{height:2px;width:100%;background-image:url(../images/left/line_bg.png);background-repeat:repeat-x;}
.leftsidebar_box dt{padding-left:40px;padding-right:10px;background-repeat:no-repeat;background-position:10px center;color:#f5f5f5;font-size:14px;position:relative;line-height:48px;cursor:pointer;}
.leftsidebar_box dd{background-color:#317eb4;padding-left:40px;}
.leftsidebar_box dd a{color:#f5f5f5;line-height:20px;}
.leftsidebar_box dt img{position:absolute;right:10px;top:20px;}
.system_log dt{background-image:url(../images/left/system.png)}
.custom dt{background-image:url(../images/left/custom.png)}
.channel dt{background-image:url(../images/left/channel.png)}
.app dt{background-image:url(../images/left/app.png)}
.cloud dt{background-image:url(../images/left/cloud.png)}
.syetem_management dt{background-image:url(../images/left/syetem_management.png)}
.source dt{background-image:url(../images/left/source.png)}
.statistics dt{background-image:url(../images/left/statistics.png)}
.leftsidebar_box dl dd:last-child{padding-bottom:10px;}
</style>
<script type="text/javascript">
</script>
</head>
<body>
<div id="main">
<div id="top">
   <p><font>当前用户:<b id="userNickName"></b></font></p>
   <input type="hidden" value="${sessionScope.userName}" id="getName" />
<%--   <p><font>当前用户:<%=request.getParameter("userName") %></font></p>
  <input type="hidden" value="<%=request.getParameter("userName") %>" id="getName" /> --%>

</div>
<div id="left">
 <div class="container">
	<div class="leftsidebar_box">
		<div class="line"></div>
		<dl class="custom">
			<dt >用户管理<img src="../images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="javaScript:;" id="studentInfo">学生信息管理</a></dd>
			<dd><a href="javaScript:;" id="teacherInfo">教师信息管理</a></dd>
			<dd><a href="javaScript:;" id="teacherAdd">教师添加</a></dd>
		</dl>
	    <dl class="source">
			<dt>查看试题<img src="../images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="javaScript:;" id="radioQuestionsInfo">单选题</a></dd>
			<dd><a href="javaScript:;" id="checkQuestionsInfo">多选题</a></dd>
			
		</dl>
		<dl class="source">
			<dt>增加试题<img src="../images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="javaScript:;" id="addRaQuestionsInfo">单选题</a></dd>
			<dd><a href="javaScript:;" id="addChQuestionsInfo">多选题</a></dd>
			
		</dl>
		<dl class="cloud">
			<dt>组卷管理<img src="images/left/select_xl01.png"></dt>
			<dd class="first_dd"><a href="javaScript:;" id="zujuan">自动组卷</a></dd>
			<dd class="first_dd"><a href="javaScript:;" id="zujuanInfo">查看组卷</a></dd>
		</dl>
		<dl class="system_log">
			<dt><a href="javaScript:;" id="out">退出系统</a></dt>
		</dl>
	</div>
</div>
</div>
<div id="right">
<iframe id="iframe2">
</iframe>
</div>
</div>
<script type="text/javascript">
$(".leftsidebar_box dt").css({"background-color":"#3992d0"});
$(".leftsidebar_box dt img").attr("src","../images/left/select_xl01.png");
$(function(){
	$(".leftsidebar_box dd").hide();
	$(".leftsidebar_box dt").click(function(){
		$(".leftsidebar_box dt").css({"background-color":"#3992d0"})
		$(this).css({"background-color": "#317eb4"});
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".leftsidebar_box dt img").attr("src","../images/left/select_xl01.png");
		$(this).parent().find('img').attr("src","../images/left/select_xl.png");
		$(".menu_chioce").slideUp(); 
		$(this).parent().find('dd').slideToggle();
		$(this).parent().find('dd').addClass("menu_chioce");
	});
})
</script>
</body>
</html>