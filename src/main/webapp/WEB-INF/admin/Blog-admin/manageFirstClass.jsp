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
	<div class="modal fade modal fade bs-example-modal-sm" id="editFCModal"
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
								<p class="form-control-static" id="classFCId_update"></p>
							</div>
						</div>
						<!-- 分类名称 -->
						<div class="form-group">
							<label for="email_add_input" class="col-sm-2 control-label">分类名称</label>
							<div class="col-sm-6">
								<input type="text" class="form-control"
									id="calssFCName_update_input" name="fclassificationName"
									required="required"> <span class="help-block"></span>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="editTCBtn">确认</button>
				</div>
			</div>
		</div>
	</div>

	<div id="form_of_addclass">
		<h3>添加一级分类</h3>
		<form class="form-inline" id="addClassForm">
			<div class="form-group">
				<label for="exampleInputName2">名称：</label> <input type="text"
					class="form-control" id="className" name="fclassificationName"
					placeholder="学习笔记" required="required">
			</div>
			<button type="button" class="btn btn-primary" id="addClassBtn">添加</button>
		</form>
	</div>
	<hr/>
	<div class="table-responsive">
		<table class="table table-striped" id="displayClass">
			<thead>
				<tr>
					<th>序号</th>
					<th>名称</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		//查询所有二级分类
		getAllFirstClass();
	});
	function getAllFirstClass() {
		$("#displayClass tbody").empty();
		$("#className").val("");
		$.ajax({
			url : "${APP_PATH}/getFirstClass",
			type : "GET",
			success : function(result) {
				//创建表格
				build_tbody(result);
			}
		});
	}
	//添加一级分类
	$("#addClassBtn").click(function() {
		var className = $("#className").val();
		$.ajax({
			url : "${APP_PATH}/addFirstClass",
			type : "POST",
			data : $("#addClassForm").serialize(),
			success : function(result) {
				if (result.code == 100) {
					$("#a_first_Class").empty();
					$("#className").val("");
					layer.msg("添加【" + className + "】成功！");
					getAllFirstClass()
				} else {
					layer.msg(result.extend.error);
					if (undefined != result.extend.errors.fclassificationName) {
						//有哪个字段的错误信息就显示哪个，没用错误信息的字段会显示为undefined
						layer.msg(result.extend.errors.fclassificationName);
					}
				}
			}
		});
	});
	//创建展示分类的表格
	function build_tbody(result) {
		$.each(result.extend.firstClass, function(index, item) {
			var trEle = $("<tr></tr>");
			var idTd = $("<td></td>").append(item.fclassificationId);
			var nameTd = $("<td></td>").append(item.fclassificationName);
			var btnTd = $("<td></td>");
			var preEditBtn = $("<button></button>").addClass("btn btn-info btn-sm").attr("type", "button").append("修改");
			var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm").attr("type", "button").append("删除");
			var fcId = item.fclassificationId;
			var name = item.fclassificationName;
			//注册删除单击事件
			delBtn.click(function() {
				delTcById(fcId, name);
			});
			preEditBtn.click(function() {
				preEditById(fcId);
			})
			btnTd.append(preEditBtn).append(" ").append(delBtn);
			trEle.append(idTd).append(nameTd).append(btnTd);
			$("#displayClass tbody").append(trEle);
		});
	}
	//删除分类
	function delTcById(fcId, name) {
		if (confirm("确定删除【" + name + "】吗？")) {
			$.ajax({
				url : "${APP_PATH}/delTcById/" + fcId,
				type : "DELETE",
				success : function(result) {
					if (result.code == 100) {
						layer.msg(result.extend.success);
						getAllFirstClass();
					} else {
						layer.msg(result.extend.error);
					}
				}
			});
		}
	}
	//修改前的操作，回显
	function preEditById(fcId) {
		$.ajax({
			url : "${APP_PATH}/getTcById/" + fcId,
			type : "GET",
			success : function(result) {
				$("#classFCId_update").text(result.extend.getFcById.fclassificationId);
				$("#calssFCName_update_input").val(result.extend.getFcById.fclassificationName);
			}
		})
		//弹出模态框
		$("#editFCModal").modal({
			backdrop : "static",
		});
	}
	$("#editTCBtn").click(function() {
		var id = $("#classFCId_update").text();
		$.ajax({
			url : "${APP_PATH}/editFc/" + id,
			type : "PUT",
			data : $("#editFCModal form").serialize(),
			success : function(result) {
				if (result.code == 100) {
					layer.msg("修改成功！");
					$("#editFCModal").modal('hide');
					getAllFirstClass();
				} else {
					layer.msg(result.extend.error);
					if (undefined != result.extend.errors.fclassificationName) {
						//有哪个字段的错误信息就显示哪个，没用错误信息的字段会显示为undefined
						layer.msg(result.extend.errors.fclassificationName);
					}
				}
			}
		});
	});
</script>
</html>