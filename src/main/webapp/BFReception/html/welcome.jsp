<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<meta charset="UTF-8">
<link rel="shortcut icon" href="${APP_PATH}/myico/myico6.ico" type="image/x-icon" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="${APP_PATH }/BFReception/res/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="${APP_PATH }/BFReception/res/css/main.css">
<script src="${APP_PATH }/static/js/jQuery2.0-min.js"></script>
<!--加载meta IE兼容文件-->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
<script type="text/javascript">
	var path = '<%=request.getContextPath()%>'
</script>
<style type="text/css">
.title .seclass {
	padding-left: 10px;
	padding-bottom: 10px;
	display: inline;
}

#hot_blogs p{
	height: 200px;
}
</style>
</head>
<body>
	<div class="header">
		<div class="menu-btn">
			<div class="menu"></div>
		</div>
		<h1 class="logo">
			<a> <span>MYBLOG</span> <img
				src="${APP_PATH }/BFReception/res/img/logo2.png"> 蛮吉
			</a>
		</h1>
		<div class="nav">
			<a href="${APP_PATH }/toHome" class="active">HOME</a> 
			<a href="${APP_PATH }/toStudyNote">学习笔记</a>
			<a href="${APP_PATH }/toDreamNote">虚妄之言</a>
			<a href="${APP_PATH }/toAboutMe">关于</a>
		</div>
		<ul class="layui-nav header-down-nav">
			<li class="layui-nav-item"><a href="${APP_PATH }/toHome" class="active">HOME</a></li>
			<li class="layui-nav-item"><a href="${APP_PATH }/toStudyNote">学习笔记</a></li>
			<li class="layui-nav-item"><a href="${APP_PATH }/toDreamNote">虚妄之言</a></li>
			<li class="layui-nav-item"><a href="${APP_PATH }/toAboutMe">关于</a></li>
		</ul>
		<p class="welcome-text">
			<button type="button" class="layui-btn layui-btn-radius layui-btn-normal" onclick="layer.msg('暂未开启')">登录</button>
			<button type="button" class="layui-btn layui-btn-radius layui-btn-normal" onclick="layer.msg('暂未开启')">注册</button>
		</p>
	</div>

	<div class="banner">
		<div class="cont w1000">
			<div class="title">
				<h3>
					MY<br />BLOG
				</h3>
				<h4>well-balanced heart</h4>
			</div>
			<div class="amount">
				<p>
					<span class="text">日志</span><span class="daily-record"></span>
				</p>
			</div>
		</div>
	</div>

	<div class="content">
		<div class="cont w1000">
			<div class="title">
				 <button type="button" class="layui-btn layui-btn-radius layui-btn-danger">最新文章  <i class="layui-icon">&#xe670;</i></button>
			</div>
			<div class="list-item">
				<div class="item">
					<div class="layui-fluid">
						<div class="layui-row" id="hot_blogs">
							
							
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>

	<div class="footer-wrap" style="background-color: #221531 ">
		<div class="footer w1000" style="text-align: center;">
			<p style="color: #C7DDEF;">©&nbsp;2019&nbsp;tsg.ink&nbsp;蛮吉&nbsp;|&nbsp;友情链接&nbsp;|&nbsp;<a href="https://v3.bootcss.com/" target="_blank">Bootstrap中文网</a>|&nbsp;<a href="https://www.layui.com/" target="_blank">Layui</a></p>
		</div>
	</div>
	<script src="${APP_PATH}/BFReception/res/js/contr/wel_contr.js"></script>
	<script type="text/javascript" src="${APP_PATH }/BFReception/res/layui/layui.js"></script>
	<script type="text/javascript">
	   layui.config({
	      base: '${APP_PATH}/BFReception/res/js/util/'
	    }).use(['element','laypage','form','menu'],function(){
	      element = layui.element,laypage = layui.laypage,form = layui.form,menu = layui.menu;
	      menu.init();
	      menu.submit()
	    })
	</script>
</body>
</html>