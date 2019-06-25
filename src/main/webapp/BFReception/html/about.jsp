<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link rel="shortcut icon" href="${APP_PATH}/myico/myico1.ico" type="image/x-icon" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <title>关于我</title>
  <link rel="stylesheet" type="text/css" href="${APP_PATH }/BFReception/res/layui/css/layui.css">
  <link rel="stylesheet" type="text/css" href="${APP_PATH }/BFReception/res/css/main.css">
<!--加载meta IE兼容文件-->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
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
			<a href="${APP_PATH }/toHome">HOME</a> <a
				href="${APP_PATH }/toStudyNote">学习笔记</a> <a
				href="${APP_PATH }/toDreamNote">虚妄之言</a> <a
				href="${APP_PATH }/toAboutMe" class="active">关于</a>
		</div>
		<ul class="layui-nav header-down-nav">
			<li class="layui-nav-item"><a href="${APP_PATH }/toHome">HOME</a></li>
			<li class="layui-nav-item"><a href="${APP_PATH }/toStudyNote"
				class="active">学习笔记</a></li>
			<li class="layui-nav-item"><a href="${APP_PATH }/toDreamNote">虚妄之言</a></li>
			<li class="layui-nav-item"><a href="${APP_PATH }/toAboutMe">关于</a></li>
		</ul>
		<p class="welcome-text">
			<button type="button"
				class="layui-btn layui-btn-radius layui-btn-normal" onclick="layer.msg('暂未开启')">登录</button>
			<button type="button"
				class="layui-btn layui-btn-radius layui-btn-normal" onclick="layer.msg('暂未开启')">注册</button>
		</p>
	</div>
	
  <div class="about-content">
    <div class="w1000">
      <div class="item info">
        <div class="title">
          <h3>我的介绍</h3>
        </div>
        <div class="cont">
          <img src="${APP_PATH }/BFReception/res/img/xc_img1.jpg">
          <div class="per-info">
            <p>
              <span class="name">姓名<i class="layui-icon layui-icon-star-fill"></i>&nbsp;&nbsp;：汤胜庚</span><br />
              <span class="age">年龄<i class="layui-icon layui-icon-face-surprised"></i>&nbsp;&nbsp;：22岁</span><br />
              <span class="Career">职业<i class="layui-icon layui-icon-friends"></i>&nbsp;&nbsp;：码农</span><br />
              <span class="interest">爱好<i class="layui-icon layui-icon-star"></i>&nbsp;&nbsp;：敲代码</span>
            </p>
          </div>
        </div>
      </div>
      <div class="item tool">
        <div class="title">
          <h3>我的技能</h3>
        </div>
        <div class="layui-fluid">
          <div class="layui-row">
            <div class="layui-col-xs6 layui-col-sm3 layui-col-md3">
              <div class="cont-box">
              	
                <p><button class="layui-btn layui-btn-danger layui-btn-radius layui-btn-lg">唱&nbsp;&nbsp;<i class="layui-icon layui-icon-fire"></i></button></p>
              </div>
            </div>
            <div class="layui-col-xs6 layui-col-sm3 layui-col-md3">
              <div class="cont-box">
              
                <p><button class="layui-btn layui-btn-danger layui-btn-radius layui-btn-lg">跳&nbsp;&nbsp;<i class="layui-icon layui-icon-fire"></i></button></p>
              </div>
            </div>
            <div class="layui-col-xs6 layui-col-sm3 layui-col-md3">
              <div class="cont-box">
                <p><button class="layui-btn layui-btn-danger layui-btn-radius layui-btn-lg">rap&nbsp;&nbsp;<i class="layui-icon layui-icon-fire"></i></button></p>
              </div>
            </div>
            <div class="layui-col-xs6 layui-col-sm3 layui-col-md3">
              <div class="cont-box">
                <p><button class="layui-btn layui-btn-danger layui-btn-radius layui-btn-lg">music&nbsp;&nbsp;<i class="layui-icon layui-icon-fire"></i></button></p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="item contact">
        <div class="title">
          <h3>联系方式</h3>
        </div>
        <div class="cont">
          <img src="${APP_PATH }/BFReception/res/img/erweima.jpg">
          <div class="text">
            <p class="WeChat"><i class="layui-icon layui-icon-login-wechat"></i>&nbsp;&nbsp;<span>tsg0903</span></p>
            <p class="qq"><i class="layui-icon layui-icon-login-qq"></i>&nbsp;&nbsp;<span>1528474876</span></p>
            <p class="iphone"><button class="layui-btn layui-btn-danger layui-btn-radius layui-btn-xs">注明来意</button></p>
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
  <script type="text/javascript" src="${APP_PATH }/BFReception/res/layui/layui.js"></script>
  <script type="text/javascript">
    layui.config({
      base: '${APP_PATH }/BFReception/res/js/util/'
    }).use(['element','laypage','form','layer','menu'],function(){
      element = layui.element,laypage = layui.laypage,form = layui.form,layer = layui.layer,menu = layui.menu;
      menu.init();
    })
  </script>
</body>
</html>