<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<link rel="stylesheet" href="${APP_PATH }/static/css/root_all.css">
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${APP_PATH }/static/js/jQuery2.0-min.js"></script>
<!--加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。-->
<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<!-- 引用layerUI -->
<script src="${APP_PATH }/static/layer/layer.js"></script>
<title>客户统计</title>
</head>
<body>
	<div class="container">
		<!-- 头部导航 -->
		<!--静态引入header  -->
		<%@ include file="/WEB-INF/admin/LJ-CST-admin/common/header.jsp"%>
		<br>
		<!-- END -->
		<div class="row">
			<!-- 左侧分栏 -->
			<%@ include file="/WEB-INF/admin/LJ-CST-admin/common/left.jsp"%>
			<!-- END -->
			<!-- 主题部分 -->
			
				<!-- 表格显示数据 -->
				<div class="col-md-10">
				<div class="cst_tb">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>提交时间</th>
								<th>联系</th>
								<th>学校</th>
								<th>账号</th>
								<th>密码</th>
								<th>课程</th>
								<th>平台</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pageInfo_del.list }" var="cstDel">
								<tr>
									<td>${cstDel.upTime }</td>
									<td>${cstDel.cstCon }</td>
									<td>${cstDel.cstScn }</td>
									<td>${cstDel.cstNum }</td>
									<td>${cstDel.cstPwd }</td>
									<td>${cstDel.cstCurr}</td>
									<td>${cstDel.platform.plaName }</td>
									<td>
										<button type="button" class="btn btn-danger btn-xs clear_btn" value="${cstDel.cstId }">删除</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- END -->
				<!-- 分页 -->
				<div id="cst_page">
					<nav aria-label="Page navigation">
						<ul class="pagination">
							<c:if test="${pageInfo_del.isFirstPage}">
								<!-- 当前页为第一页则不再添加跳转功能 -->
								<li class="disabled"><a>首页</a></li>
								<li class="disabled"><a> <span
										class="glyphicon glyphicon-chevron-left"></span>
								</a></li>
							</c:if>
							<c:if test="${!pageInfo_del.isFirstPage}">
								<!-- 当不是首页 -->
								<li><a href="${APP_PATH }/cstsDel?pn=1">首页</a></li>
								<li><a href="${APP_PATH }/cstsDel?pn=${pageInfo_del.pageNum-1}">
										<span class="glyphicon glyphicon-chevron-left"></span>
								</a></li>
							</c:if>
							<c:forEach items="${pageInfo_del.navigatepageNums }" var="page_num">
								<!-- 当前页码高亮显示 -->
								<c:if test="${pageInfo_del.pageNum == page_num }">
									<li class="active"><a>${page_num }</a></li>
								</c:if>
								<c:if test="${pageInfo_del.pageNum != page_num }">
									<li><a href="${APP_PATH }/cstsDel?pn=${page_num}">${page_num}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${pageInfo_del.isLastPage}">
								<!-- 当前页为最后一页则不再添加跳转功能 -->
								<li class="disabled"><a aria-label="Next"> <span
										class="glyphicon glyphicon-chevron-right"></span>
								</a></li>
								<li class="disabled"><a>尾页</a></li>
							</c:if>
							<c:if test="${!pageInfo_del.isLastPage}">
								<!-- 不是最后一页时 -->
								<li><a href="${APP_PATH }/cstsDel?pn=${pageInfo_del.pageNum+1}">
										<span class="glyphicon glyphicon-chevron-right"></span>
								</a></li>
								<li><a href="${APP_PATH }/cstsDel?pn=${pageInfo_del.pages}">尾页</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
			<!-- END -->
		</div>
	</div>
<script type="text/javascript">
	//彻底删除
	$(".clear_btn").click(function() {
		//得到联系方式
		var cstCon = $(this).parents("tr").find("td:eq(1)").text();
		if(confirm("确定彻底删除【"+cstCon+"】吗？")){
			var delId = $(this).val();
			$.ajax({
				url:"${APP_PATH}/delCstThoroug/"+delId,
				type:"DELETE",
				success:function(result){
					//删除成功
					if (result.code == 100) {
						layer.msg("彻底删除成功！");
						setTimeout(function() {
							window.location.reload();//刷新当前页面.
							}, 800);
					}else{
						layer.msg("彻底删除失败！");
					}
				}
			});
			
		}
		
		
	});

</script>	
<script src="${APP_PATH }/static/js/common.js"></script>
</body>
</html>