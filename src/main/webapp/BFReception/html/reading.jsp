<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link rel="shortcut icon" href="${APP_PATH}/myico/myico4.ico" type="image/x-icon" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <title>阅读文章</title>
  <link rel="stylesheet" type="text/css" href="${APP_PATH }/BFReception/res/layui/css/layui.css">
  <link rel="stylesheet" type="text/css" href="${APP_PATH }/BFReception/res/css/main.css">
<!--加载meta IE兼容文件-->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
<style type="text/css">
#blogArticle{
	padding-bottom: 200px;
}
#blogArticle ol li{
	 list-style-type:decimal;
}
#blogArticle ul li{
	list-style-type:square;
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
			<a href="${APP_PATH }/toHome">HOME</a> 
			<a href="${APP_PATH }/toStudyNote">学习笔记</a>
			<a href="${APP_PATH }/toDreamNote">虚妄之言</a>
			<a href="${APP_PATH }/toAboutMe">关于</a>
		</div>
		<ul class="layui-nav header-down-nav">
			<li class="layui-nav-item"><a href="${APP_PATH }/toHome">HOME</a></li>
			<li class="layui-nav-item"><a href="${APP_PATH }/toStudyNote">学习笔记</a></li>
			<li class="layui-nav-item"><a href="${APP_PATH }/toDreamNote">虚妄之言</a></li>
			<li class="layui-nav-item"><a href="${APP_PATH }/toAboutMe">关于</a></li>
		</ul>
		<p class="welcome-text">
			<button type="button" class="layui-btn layui-btn-radius layui-btn-normal">登录</button>
			<button type="button" class="layui-btn layui-btn-radius layui-btn-normal">注册</button>
		</p>
	</div>


  <div class="content whisper-content leacots-content details-content">
    <div class="cont w1000">
      <div class="whisper-list">
        <div class="item-box">
          <div class="review-version">
              <div class="form-box">
                <div class="article-cont" >
                  <div class="title">
                    <h3>${getBlogById.blogTitle }</h3>
                    <p class="cont-info"><span class="data">${getBlogById.blogUptime }</span></p>
                  </div>
                  <div id="blogArticle">${getBlogById.blogArticle }</div>
                </div>
                
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
  <script type="text/javascript" src="${APP_PATH }/BFReception/res/layui/layui.js"></script>
  <script src="${APP_PATH}/BFReception/res/js/contr/reading.js"></script>
  <script type="text/javascript">
   layui.config({
      base: '${APP_PATH }/BFReception/res/js/util/'
    }).use(['element','laypage','form','menu'],function(){
      element = layui.element,laypage = layui.laypage,form = layui.form,menu = layui.menu;
      menu.init();
      menu.submit()
    })
  </script>
</body>
</html>