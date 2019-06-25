<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<body>
<!-- 分类修改模态框 -->
	<!-- Modal -->
	<div class="modal fade modal fade bs-example-modal-sm" id="editBlogModal"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改分类信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">分类序号</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="classBlogId_update"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">写作时间</label>
							<div class="col-sm-10">
								<p class="form-control-static" id="classBlogUptime_update"></p>
							</div>
						</div>
						<!-- 博客名称 -->
						<div class="form-group">
							<label class="col-sm-2 control-label">博客标题</label>
							<div class="col-sm-6">
								<input type="text" class="form-control"
									id="calssBlogTitle_update_input" name="blogTitle"
									required="required"> <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">所属分类</label>
							<div class="col-sm-6">
								<select class="form-control Third_Class_selete" name="blogTcId">
								
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">博客内容</label>
							<div class="col-sm-10">
								<textarea name="blogArticle" id="calssBlogArticle_update_input" class="form-control" rows="10"></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="editBlogBtn">确认</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Model -->
	<!-- 主体 -->
		<div id="form_of_addclass">
		<h3>条件筛选</h3>
		<form class="form-inline" id="getByTClassForm">
			<div class="form-group">
				<select class="form-control Third_Class_selete" name="blogTcId">
				</select>
			</div>
			<button type="button" class="btn btn-primary" id="getByTClassBtn">筛选</button>
		</form>
	</div>
	<hr/>

	<div class="table-responsive">
		<table class="table table-striped" id="displayClass">
			<thead>
				<tr>
					<th>序号</th>
					<th>标题</th>
					<th>上传时间</th>
					<th>所属分类</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1,001</td>
					<td>Lorem</td>
					<td>Lorem</td>
					<td>
						<button type="button" class="btn btn-danger btn-sm">删除</button>
						<button type="button" class="btn btn-info btn-sm">删除</button>
					</td>
				</tr>

			</tbody>
		</table>
		<div id="page_for_num">
			<!-- <nav>
		  <ul class="pagination">
		    <li>
		      <a href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <li><a href="#">1</a></li>
		    <li><a href="#">2</a></li>
		    <li><a href="#">3</a></li>
		    <li><a href="#">4</a></li>
		    <li><a href="#">5</a></li>
		    <li>
		      <a href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
		 -->
		</div>
		
	</div>
	<!-- 主体END -->
</body>
<script type="text/javascript">
	$(function() {
		//默为第一页
		to_page(1);
		//查询所有三级分类
		getAllThird();
	});
	//查询所有三级分类
	function getAllThird(){
		$(".Third_Class_selete").empty();
		$.ajax({
			url:"${APP_PATH}/getAllThird",
			type:"GET",
			success:function(result){
				$.each(result.extend.tclass,function(index,item){
					var optionEle = $("<option></option>").attr("value",item.tclassificationId)
									.append(item.tclassificationName).appendTo(".Third_Class_selete");
				});
			}
		});
	}
	//页面跳转
	function to_page(pn) {
		$("#displayClass tbody").empty();
		$.ajax({
			url:"${APP_PATH}/getAllBlogs",
			data : "pn=" + pn,
			type:"GET",
			success:function(result){
				//创建表格
				build_tbody(result);
				//3.解析并显示分页跳转数据
				build_page_nav(result);
			}
		});
		
	}
	//创建展示分类的表格
	function build_tbody(result) {
		var pageNum = result.extend.pageInfo.pageNum;
		$.each(result.extend.pageInfo.list, function(index,item) {
			var trEle = $("<tr></tr>");
			var idTd = $("<td></td>").append(item.blogId);
			var titleTd = $("<td></td>").append(item.blogTitle);
			var uptimeTd = $("<td></td>").append(item.blogUptime);
			var BlogOfTcTd = $("<td></td>").append(item.thirdClass.tclassificationName);
			var btnTd = $("<td></td>");
			var preEditBtn = $("<button></button>").addClass("btn btn-info btn-sm").attr("type", "button").append("修改");
			var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm").attr("type", "button").append("删除");
			var blogId = item.blogId;
			var blogTltle = item.blogTitle;
			//注册删除单击事件
			delBtn.click(function() {
				delBlogById(blogId,blogTltle,pageNum);
			});
			preEditBtn.click(function() {
				preEditById(blogId,pageNum);
			});
			btnTd.append(preEditBtn).append(" ").append(delBtn);
			trEle.append(idTd).append(titleTd).append(uptimeTd).append(BlogOfTcTd).append(btnTd);
			$("#displayClass tbody").append(trEle);
		});
	}
	//删除分类
	function delBlogById(blogId, blogTltle,pageNum){
		if (confirm("确定删除【" + blogTltle + "】吗？")) {
			$.ajax({
				url : "${APP_PATH}/delBlogById/" + blogId,
				type : "DELETE",
				success : function(result) {
					layer.msg(result.extend.success);
					to_page(pageNum);
				}
			});
		}
	}
	//修改之前的准备
	function preEditById(blogId,pageNum) {
		$("#editBlogBtn").attr("blogPn",pageNum);
		$.ajax({
			url : "${APP_PATH}/reEditBlog/" + blogId,
			type : "GET",
			success : function(result) {
				$("#classBlogId_update").text(result.extend.blog.blogId);
				$("#classBlogUptime_update").text(result.extend.blog.blogUptime);
				$("#calssBlogTitle_update_input").val(result.extend.blog.blogTitle);
				$("#calssBlogArticle_update_input").val(result.extend.blog.blogArticle);
				$("#editBlogModal select").val([result.extend.blog.blogTcId]); 
			}
		})
		//弹出模态框
		$("#editBlogModal").modal({
			backdrop : "static",
		});
	}
	//修改三级分类
	$("#editBlogBtn").click(function() {
		var id = $("#classBlogId_update").text();
		var pn = $("#editBlogBtn").attr("blogPn");
		$.ajax({
			url : "${APP_PATH}/editBlog/" + id,
			type : "PUT",
			data : $("#editBlogModal form").serialize(),
			success : function(result) {
				if (result.code == 100) {
					layer.msg("修改成功！");
					$("#editBlogModal").modal('hide');
					to_page(pn)
				} else {
					//有哪个字段的错误信息就显示哪个，没用错误信息的字段会显示为undefined
					if (undefined != result.extend.errors.blogTitle) {
						layer.msg(result.extend.errors.blogTitle);
						return false;
					}
					if (undefined != result.extend.errors.blogArticle) {
						layer.msg(result.extend.errors.blogArticle);
					}
				}
			}
		});
	});
	
	//3.解析并显示分页跳转数据
	function build_page_nav(result) {
		//page_for_num
		$("#page_for_num").empty();
		var pageUl = $("<ul></ul").addClass("pagination");
		//首页
		var firstPage = $("<li></li>").append(
				$("<a></a>").attr("href", "#").append("首页"));
		//上一页
		var previousPage = $("<li></li>").append(
				$("<a></a>").append("<span></span>").addClass(
						"glyphicon glyphicon-chevron-left").attr("href", "#"));
		previousPage.click(function() {
			to_page(result.extend.pageInfo.pageNum - 1);
		});
		firstPage.click(function() {
			to_page(1);
		});
		if (result.extend.pageInfo.isFirstPage == true) {
			firstPage = $("<li></li>").append($("<a></a>").append("首页"))
					.addClass("disabled").on('click', function() {
						layer.msg('已经是首页！');
					});
			previousPage = $("<li></li>").append(
					$("<a></a>").append("<span></span>").addClass(
							"glyphicon glyphicon-chevron-left")).addClass(
					"disabled").on('click', function() {
				layer.msg('不存在上一页！');
			});
		}
		//添加到ul
		pageUl.append(firstPage).append(previousPage);
		//遍历添加中间的页码
		$.each(result.extend.pageInfo.navigatepageNums, function(index, item) {
			var pageNumLi = $("<li></li>").append(
					$("<a></a>").attr("href", "#").append(item));
			//添加到ul
			if (result.extend.pageInfo.pageNum == item) {
				pageNumLi.addClass("active");
			}
			//注册跳转事件
			pageNumLi.click(function() {
				to_page(item);
			});
			pageUl.append(pageNumLi);
		});
		//下一页
		var nextPage = $("<li></li>").append(
				$("<a></a>").append("<span></span>").addClass(
						"glyphicon glyphicon-chevron-right").attr("href", "#"));
		//尾页
		var lastPage = $("<li></li>").append(
				$("<a></a>").attr("href", "#").append("尾页"));
		nextPage.click(function() {
			to_page(result.extend.pageInfo.pageNum + 1);
		});
		lastPage.click(function() {
			to_page(result.extend.pageInfo.pages);
		});
		if (result.extend.pageInfo.isLastPage == true) {
			//下一页
			nextPage = $("<li></li>").append(
					$("<a></a>").append("<span></span>").addClass(
							"glyphicon glyphicon-chevron-right")).addClass(
					"disabled").on('click', function() {
				layer.msg('不存在下一页');
			});
			//尾页
			lastPage = $("<li></li>").append(
					$("<a></a>").attr("href", "#").append("尾页")).addClass(
					"disabled").on('click', function() {
				layer.msg('已经是尾页！');
			});

		}
		//添加到ul里
		pageUl.append(nextPage).append(lastPage);
		//得到nav
		var navEle = $("<nav></nav>").append(pageUl);
		navEle.appendTo("#page_for_num");
	};
	//分类筛选
	$("#getByTClassBtn").click(function() {
		$("#displayClass tbody").empty();
		var tclassid = $("#getByTClassForm select").val();
		to_page_byTC(1,tclassid) 
	});
	function to_page_byTC(pn,fkId) {
		$("#displayClass tbody").empty();
		$.ajax({
			url:"${APP_PATH}/getByFK",
			data:{"pn":pn,"blogTcId":fkId},
			type:"GET",
			success:function(result){
				//创建表格
				build_tbody(result);
				//3.解析并显示分页跳转数据
				build_page_byfk_nav(result);
			}
		});
	}
	//3.筛选后，解析并显示分页跳转数据
	function build_page_byfk_nav(result) {
		$("#page_for_num").empty();
		//page_for_num
		var fkId = result.extend.pageInfo.list[0].thirdClass.tclassificationId;
		var pageUl = $("<ul></ul").addClass("pagination");
		//首页
		var firstPage = $("<li></li>").append(
				$("<a></a>").attr("href", "#").append("首页"));
		//上一页
		var previousPage = $("<li></li>").append(
				$("<a></a>").append("<span></span>").addClass(
						"glyphicon glyphicon-chevron-left").attr("href", "#"));
		previousPage.click(function() {
			to_page_byTC(result.extend.pageInfo.pageNum - 1,fkId);
		});
		firstPage.click(function() {
			to_page_byTC(1,fkId);
		});
		if (result.extend.pageInfo.isFirstPage == true) {
			firstPage = $("<li></li>").append($("<a></a>").append("首页"))
					.addClass("disabled").on('click', function() {
						layer.msg('已经是首页！');
					});
			previousPage = $("<li></li>").append(
					$("<a></a>").append("<span></span>").addClass(
							"glyphicon glyphicon-chevron-left")).addClass(
					"disabled").on('click', function() {
				layer.msg('不存在上一页！');
			});
		}
		//添加到ul
		pageUl.append(firstPage).append(previousPage);
		//遍历添加中间的页码
		$.each(result.extend.pageInfo.navigatepageNums, function(index, item) {
			var pageNumLi = $("<li></li>").append(
					$("<a></a>").attr("href", "#").append(item));
			//添加到ul
			if (result.extend.pageInfo.pageNum == item) {
				pageNumLi.addClass("active");
			}
			//注册跳转事件
			pageNumLi.click(function() {
				to_page_byTC(item,fkId);
			});
			pageUl.append(pageNumLi);
		});
		//下一页
		var nextPage = $("<li></li>").append(
				$("<a></a>").append("<span></span>").addClass(
						"glyphicon glyphicon-chevron-right").attr("href", "#"));
		//尾页
		var lastPage = $("<li></li>").append(
				$("<a></a>").attr("href", "#").append("尾页"));
		nextPage.click(function() {
			to_page_byTC(result.extend.pageInfo.pageNum + 1,fkId);
		});
		lastPage.click(function() {
			to_page_byTC(result.extend.pageInfo.pages,fkId);
		});
		if (result.extend.pageInfo.isLastPage == true) {
			//下一页
			nextPage = $("<li></li>").append(
					$("<a></a>").append("<span></span>").addClass(
							"glyphicon glyphicon-chevron-right")).addClass(
					"disabled").on('click', function() {
				layer.msg('不存在下一页');
			});
			//尾页
			lastPage = $("<li></li>").append(
					$("<a></a>").attr("href", "#").append("尾页")).addClass(
					"disabled").on('click', function() {
				layer.msg('已经是尾页！');
			});

		}
		//添加到ul里
		pageUl.append(nextPage).append(lastPage);
		//得到nav
		var navEle = $("<nav></nav>").append(pageUl);
		navEle.appendTo("#page_for_num");
	};
</script>
</html>