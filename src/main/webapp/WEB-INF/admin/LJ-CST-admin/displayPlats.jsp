<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${APP_PATH }/static/js/jQuery2.0-min.js"></script>
<!--加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。-->
<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<!-- 引用layerUI -->
<script src="${APP_PATH }/static/layer/layer.js"></script>
<title>平台管理</title>
</head>
<body>
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
			<div class="col-md-10" id="platTb">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>平台序号</th>
							<th>平台名称</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
			<!-- 主体部分 -->
		</div>
		<!-- 内容END -->
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url:"${APP_PATH}/plats",
			type:"GET",
			success:function(result){
				//alert(result.msg)				
				//$("#platTb tbody");
				var plaEle = result.extend.plats;
				$.each(plaEle,function(index, item){
					var trEle=$("<tr></tr>");
					var plaIdTd=$("<td></td>").append(item.plaId);
					var palNameTd=$("<td></td>").append(item.plaName);
					var delPlaBtn=$("<button></button>").attr("delPla",item.plaId)
									.addClass("btn btn-danger btn-sm").append("删除");
					var delPlaTd =$("<td></td>").append(delPlaBtn);
					trEle.append(plaIdTd).append(palNameTd).append(delPlaTd).appendTo("#platTb tbody");
				});
			}
		});
	});


</script>

</html>