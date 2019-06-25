<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<meta charset="UTF-8">
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${APP_PATH }/static/js/jQuery2.0-min.js"></script>
<!--加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。-->
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link href="${APP_PATH }/static/BAMStatic/css/BAManage.css"
	rel="stylesheet">
<script src="${APP_PATH }/static/wangEditor-3.1.1/wangEditor.js"></script>
<script src="${APP_PATH }/static/layer/layer.js"></script>
<title>博客系统后台</title>
<style type="text/css">
</style>
</head>
<body>
	<%@include file="common/header.jsp" %> 
	<div class="container-fluid">
		<div class="col-sm-3 col-md-2 sidebar">
			<div class="panel panel-default">
		    <div class="panel-heading" role="tab" id="headingTwo">
		      <h4 class="panel-title">
		        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
		          	分类管理
		        </a>
		      </h4>
		    </div>
		    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
		      <div class="panel-body">
		      	<a class="navbar-brand" href="#" id="tofclass">一级分类管理</a>
				<a class="navbar-brand" href="#" id="tosclass">二级分类管理</a>
				<a class="navbar-brand" href="#" id="totclass">三级分类管理</a>
		      </div>
		    </div>
		  </div>
		  <div class="panel panel-default">
		    <div class="panel-heading" role="tab" id="headingThree">
		      <h4 class="panel-title">
		        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
		          	博客管理
		        </a>
		      </h4>
		    </div>
		    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
		      <div class="panel-body">
		      	<a class="navbar-brand" href="#" id="toManageBlog">博客管理</a>
				<a class="navbar-brand" href="#" id="toWriteBlog">编写博客</a>
		      </div>
		    </div>
		  </div>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="manage_class">
			<h1>欢迎光临</h1>
		</div>
	</div>
</body>
<script type="text/javascript">
	$("#tofclass").click(function () {
		$.ajax({
			url:"${APP_PATH}/toManageFirstClass",
			type:"GET",
			success:function(result){
				$("#manage_class").html(result);
			}
		});
	});
	$("#tosclass").click(function () {
		$.ajax({
			url:"${APP_PATH}/toManageSecondClass",
			type:"GET",
			success:function(result){
				$("#manage_class").html(result);
			}
		});
	});
	$("#totclass").click(function () {
		$.ajax({
			url:"${APP_PATH}/toManageThirdClass",
			type:"GET",
			success:function(result){
				$("#manage_class").html(result);
			}
		});
	});
	$("#toManageBlog").click(function () {
		$.ajax({
			url:"${APP_PATH}/toManageBlog",
			type:"GET",
			success:function(result){
				$("#manage_class").html(result);
			}
		});
	});
	$("#toWriteBlog").click(function () {
		$.ajax({
			url:"${APP_PATH}/toWriteBlog",
			type:"GET",
			success:function(result){
				$("#manage_class").html(result);
			}
		});
	});
</script>
</html>