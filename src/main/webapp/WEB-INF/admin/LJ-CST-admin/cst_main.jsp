<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link rel="stylesheet" href="${APP_PATH }/static/css/root_all.css">
<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${APP_PATH }/static/js/jQuery2.0-min.js"></script> 
<!--加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。-->
<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script> 
<!-- 引用layerUI -->
<title>客户统计</title>

</head>
<body>
	<!-- Preloader -->
	<div class="loader-mask">
		<div class="loader">"Loading..."</div>
	</div>
	<div class="container">
		<!-- 头部导航 -->
		<!--静态引入header  -->
		<%@ include file="/WEB-INF/admin/LJ-CST-admin/common/header.jsp"%>
		<br>
		<!-- 头部导航END -->
		<!-- 内容 -->
		<div class="row">
			<!-- 左侧分栏 -->
			<%@ include file="/WEB-INF/admin/LJ-CST-admin/common/left.jsp"%>
			<!-- 左侧分栏END -->
			<!-- 主体部分 -->
			<div class="col-md-10">
				<h2>已服务 <mark id="cstOfDel"></mark> 位同学！正在服务 <mark id="cstUnDel"></mark> 位同学！</h2>
			</div>
			<!-- 主体部分 -->
		</div>
		<!-- 内容END -->
	</div>
	<script type="text/javascript">
		//已经删除的客户数目
		$(function() {
			$.ajax({
				url:"${APP_PATH}/countCstOfDel",
				type:"GET",
				success:function(result){
					//alert("aaa");
					$("#cstOfDel").text(result.extend.countCstOfDel);
				}
			});
		});
		//未删除的客户数目
		$(function() {
			$.ajax({
				url:"${APP_PATH}/cstUnDel",
				type:"GET",
				success:function(result){
					$("#cstUnDel").text(result.extend.cstUnDel);
				}
			});
		}); 
		//页面加载前的缓冲
		$(window).on('load', function() {
			$('.loader').fadeOut();
			$('.loader-mask').delay(350).fadeOut('slow');
			$(window).trigger("resize");
		}); 
	</script>
</body>
</html>