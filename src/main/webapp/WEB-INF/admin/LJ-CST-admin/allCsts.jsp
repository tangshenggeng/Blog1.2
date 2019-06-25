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
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<!-- 引用layerUI -->
<script src="${APP_PATH }/static/layer/layer.js"></script>
<title>客户统计</title>
</head>
<body>
	<div class="container">
		<!-- 头部导航 -->
		<!--静态引入header  -->
		<%@ include file="/WEB-INF/admin/LJ-CST-admin/common/header.jsp"%><br>
		<!-- END -->
		<div class="row">
			<!-- 左侧分栏 -->
			<%@ include file="/WEB-INF/admin/LJ-CST-admin/common/left.jsp"%>
			<!-- END -->
			<!-- 主题部分 -->
			<!-- 筛选模态框 -->
			<div id="cst_screen_modal" class="modal fade" tabindex="-1"
				role="dialog">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">
								<span class="glyphicon glyphicon-search"></span> 筛选
							</h4>
						</div>
						<div class="modal-body">

							<form class="form-horizontal">
								<div class="form-group">
									<label for="cst_screen_con" class="col-sm-4 control-label">联系方式</label>
									<div class="col-sm-6">
										<input type="text" id="cst_screen_con" name="cstCon"
											class="form-control" placeholder="联系方式">
									</div>
								</div>
								<div class="form-group">
									<label for="cst_screen_scn" class="col-sm-4 control-label">学校名称</label>
									<div class="col-sm-6">
										<input type="text" id="cst_screen_scn" name="cstScn"
											class="form-control" placeholder="学校名称">
									</div>
								</div>
								<div class="form-group">
									<label for="cst_screen_num" class="col-sm-4 control-label">账&emsp;&emsp;号</label>
									<div class="col-sm-6">
										<input type="text" id="cst_screen_num" name="cstNum"
											class="form-control" placeholder="账号">
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<span class="glyphicon glyphicon-remove"></span> 关闭
							</button>
							<button type="button" class="btn btn-primary" id="cst_screen_btn">
								<span class="glyphicon glyphicon-search"></span> 筛选
							</button>
						</div>
					</div>
				</div>
			</div>
			<!-- 筛选模态框END -->

			<!-- 修改模态框 -->
			<div id="cst_update_modal" class="modal fade" tabindex="-1"
				role="dialog">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">
								<span class="glyphicon glyphicon-edit"></span> 修改
							</h4>
						</div>
						<div class="modal-body">

							<form class="form-horizontal">
								<div class="form-group">
									<label for="cst_update_con" class="col-sm-4 control-label">联系方式</label>
									<div class="col-sm-6">
										<p class="form-control-static" id="cst_update"></p>
									</div>
								</div>
								<div class="form-group">
									<label for="cst_update_scn" class="col-sm-4 control-label">学校名称</label>
									<div class="col-sm-6">
										<input type="text" id="cst_update_scn" name="cstScn"
											class="form-control" placeholder="学校名称">
									</div>
								</div>
								<div class="form-group">
									<label for="cst_update_num" class="col-sm-4 control-label">账&emsp;&emsp;号</label>
									<div class="col-sm-6">
										<input type="text" id="cst_update_num" name="cstNum"
											class="form-control" placeholder="账号">
									</div>
								</div>
								<div class="form-group">
									<label for="cst_update_pwd" class="col-sm-4 control-label">密&emsp;&emsp;码</label>
									<div class="col-sm-6">
										<input type="text" id="cst_update_pwd" name="cstPwd"
											class="form-control" placeholder="密码">
									</div>
								</div>
								<div class="form-group">
									<label for="cst_update_curr" class="col-sm-4 control-label">课&emsp;&emsp;程</label>
									<div class="col-sm-6">
										<input type="text" id="cst_update_curr" name="cstCurr"
											class="form-control" placeholder="课程">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-4 control-label">平&emsp;&emsp;台</label>
									<div class="col-sm-6">
										<select class="form-control" name="cstPlaId">
										</select>
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<span class="glyphicon glyphicon-remove"></span> 关闭
							</button>
							<button type="button" class="btn btn-primary" id="cst_update_btn">
								<span class="glyphicon glyphicon-ok"></span> 修改
							</button>
						</div>
					</div>
				</div>
			</div>
			<!-- 修改模态框END -->
			<div class="col-md-10 date_tb">
				<button id="pre_screen_btn" type="button"
					class="btn btn-primary btn-sm" data-toggle="modal"
					data-target="#cst_screen_modal">
					<span class="glyphicon glyphicon-search"></span> 筛选
				</button>
				<!-- 表格显示数据 -->
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
							<c:forEach items="${pageInfo.list}" var="cst">
								<tr>
									<td>${cst.upTime }</td>
									<td>${cst.cstCon }</td>
									<td>${cst.cstScn }</td>
									<td>${cst.cstNum }</td>
									<td>${cst.cstPwd }</td>
									<td>${cst.cstCurr}</td>
									<td>${cst.platform.plaName}</td>
									<td>
										<button type="button" class="btn btn-warning btn-xs edit_btn"
											value="${cst.cstId }">修改</button>
										<button type="button" class="btn btn-danger btn-xs delete_btn"
											value="${cst.cstId }">删除</button>
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
							<c:if test="${pageInfo.isFirstPage}">
								<!-- 当前页为第一页则不再添加跳转功能 -->
								<li class="disabled"><a>首页</a></li>
								<li class="disabled"><a> <span
										class="glyphicon glyphicon-chevron-left"></span>
								</a></li>
							</c:if>
							<c:if test="${!pageInfo.isFirstPage}">
								<!-- 当不是首页 -->
								<li><a href="${APP_PATH }/csts?pn=1">首页</a></li>
								<li><a href="${APP_PATH }/csts?pn=${pageInfo.pageNum-1}">
										<span class="glyphicon glyphicon-chevron-left"></span>
								</a></li>
							</c:if>
							<c:forEach items="${pageInfo.navigatepageNums }" var="page_num">
								<!-- 当前页码高亮显示 -->
								<c:if test="${pageInfo.pageNum == page_num }">
									<li class="active"><a>${page_num }</a></li>
								</c:if>
								<c:if test="${pageInfo.pageNum != page_num }">
									<li><a href="${APP_PATH }/csts?pn=${page_num}">${page_num}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${pageInfo.isLastPage}">
								<!-- 当前页为最后一页则不再添加跳转功能 -->
								<li class="disabled"><a aria-label="Next"> <span
										class="glyphicon glyphicon-chevron-right"></span>
								</a></li>
								<li class="disabled"><a>尾页</a></li>
							</c:if>
							<c:if test="${!pageInfo.isLastPage}">
								<!-- 不是最后一页时 -->
								<li><a href="${APP_PATH }/csts?pn=${pageInfo.pageNum+1}">
										<span class="glyphicon glyphicon-chevron-right"></span>
								</a></li>
								<li><a href="${APP_PATH }/csts?pn=${pageInfo.pages}">尾页</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div>
			<!-- END -->
		</div>
	</div>
	<script type="text/javascript">
		//修改客户信息
		$("#cst_update_btn").click(function() {
			//得到客户的id
			var updateId = $("#cst_update_btn").attr("updateId");
			//校验数据
			var updateScn = $("#cst_update_scn").val();
			var updateNum = $("#cst_update_num").val();
			var updatePwd = $("#cst_update_pwd").val();
			var updateCurr = $("#cst_update_curr").val();
			//验证未输入
			var reg_null = /\S/;
			if (!reg_null.test(updateScn) | !reg_null.test(updateNum) | !reg_null.test(updatePwd) | !reg_null.test(updateCurr)) {
				layer.msg("无法更新！有空白输入框！");
			} else {
				$.ajax({
					url : "${APP_PATH}/editCst/" + updateId,
					type : "PUT",
					data : $("#cst_update_modal form").serialize(),
					success : function(result) {
						//alert(result.code)
						if (result.code == 100) {
							$("#cst_update_modal").modal('hide');
							layer.msg("修改成功！");
							setTimeout(function() {
								window.location.reload();//刷新当前页面.
							}, 800);
						} else {
							layer.msg("修改失败！");
						}
					}
				});
			}
		});
		//查询所有平台
		function findAllPla(ele) {
			$(ele).empty();
			$.ajax({
				url : "${APP_PATH}/plats",
				type : "GET",
				success : function(result) {
					//console.log(result);
					//遍历显示到select中
					$.each(result.extend.plats, function() {
						var optionEle = $("<option></option>").append(this.plaName).attr("value", this.plaId);
						optionEle.appendTo(ele);
					});
				}
			});
		}
		//点击修改按钮，把cstId传给模态框的修改按钮
		$(document).on("click",".edit_btn",function(){
			$("#cst_update_modal form")[0].reset();
			//查询到所有平台信息
			findAllPla("#cst_update_modal select");
			//把对应客户的id传过来，给修改提交按钮
			var updateId = $(this).val();
			$("#cst_update_btn").attr("updateId", updateId);
			//弹出模态框
			$("#cst_update_modal").modal({
				backdrop : "static",
			});
			editCst(updateId)
		});
		
		//抽取出修改方法
		function editCst(updateId){
			$.ajax({
				url : "${APP_PATH}/preEdit/" + updateId,
				type : "GET",
				success : function(result) {
					//alert(result.code)
					var cstPreUpDate = result.extend.cstById;
					if (result.code == 100) {
						$("#cst_update").text(cstPreUpDate.cstCon);
						$("#cst_update_scn").val(cstPreUpDate.cstScn)
						$("#cst_update_modal select").val([ cstPreUpDate.cstPlaId ]);
						$("#cst_update_num").val(cstPreUpDate.cstNum);
						$("#cst_update_pwd").val(cstPreUpDate.cstPwd);
						$("#cst_update_curr").val(cstPreUpDate.cstCurr);
					} else {
						layer.msg("系统错误！");
					}
				}
			});
		}
		//假删除一个用户
		$(document).on("click",".delete_btn",function(){
			var delId = $(this).val();
			$.ajax({
				url : "${APP_PATH}/delCst/" + delId,
				type : "PUT",
				success : function(result) {
					//删除成功
					if (result.code == 100) {
						layer.msg("删除成功！");
						setTimeout(function() {
							window.location.reload();//刷新当前页面.
						}, 800);
					} else {
						layer.msg("删除失败！");
					}
				}
			});
		});

		/* 重置表单 */
		$("#pre_screen_btn").click(function() {
			$("#cst_screen_modal form")[0].reset();
		});

		//筛选
		$("#cst_screen_btn").click(
				function() {
					//验证用户是否添加了条件，如果没有提醒输入条件
					var screen_con = $("#cst_screen_con").val();
					var screen_scn = $("#cst_screen_scn").val();
					var screen_num = $("#cst_screen_num").val();
					//验证未输入
					var reg_null = /\S/;
					var reg_con = /^[a-zA-Z0-9_-]{6,20}$/;
					if (!reg_null.test(screen_scn) & !reg_null.test(screen_num) & !reg_null.test(screen_con)) {
						layer.msg("至少添加一个条件");
						return false;
					} else if (!reg_con.test(screen_con) & reg_null.test(screen_con)) {
						layer.msg("联系方式格式为6-20位的字母、数字、-、_");
						return false;
					}
					$.ajax({
						url : "${APP_PATH}/screenCsts",
						type : "POST",
						data : $("#cst_screen_modal form").serialize(),
						success : function(result) {
							//alert("aaa");
							if (result.extend.pageInfo.list.length == 0) {
								layer.msg("没有符合该条件的客户");
							} else {
								$('#cst_screen_modal').modal('hide');
								layer.msg("查询到" + result.extend.pageInfo.list.length + "位客户");
								//把之前表格里的数据清空重新添加
								$(".cst_tb tbody").html("");
								//把之前分页里的数据清空重新添加
								$("#cst_page").html("");
								//遍历所有客户
								var csts = result.extend.pageInfo.list;
								$.each(csts, function(index, item) {
									var upTimeEle = $("<td></td>").append(item.upTime)
									var conEle = $("<td></td>").append(item.cstCon);
									var scnEle = $("<td></td>").append(item.cstScn);
									var numEle = $("<td></td>").append(item.cstNum);
									var pwdEle = $("<td></td>").append(item.cstPwd);
									var currEle = $("<td></td>").append(item.cstCurr);
									var plaEle = $("<td></td>").append(item.platform.plaName);
									var editBtn = $("<button></button>").addClass("btn btn-warning btn-xs edit_btn").append(" 修改");
									//创建编辑按钮时，为员工添加一个自定义属性，用来表示当前员工的Id
									editBtn.attr("value", item.cstId);
									var delBtn = $("<button></button>").addClass("btn btn-danger btn-xs delete_btn").append(" 删除");
									//创建删除按钮时，为员工添加一个自定义属性，用来表示当前员工的Id
									delBtn.attr("value", item.cstId);
									var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
									var trEle = $("<tr></tr>").append(upTimeEle).append(conEle).append(scnEle).append(numEle).append(pwdEle).append(currEle).append(plaEle)
									.append(btnTd).appendTo(".cst_tb tbody");
								});
							}
						}
					});
				});
	</script>
<script src="${APP_PATH }/static/js/common.js"></script>
</body>
</html>