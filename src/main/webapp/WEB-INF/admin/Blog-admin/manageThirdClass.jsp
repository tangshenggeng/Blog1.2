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
	<div class="modal fade modal fade bs-example-modal-sm" id="editTCModal"
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
								<p class="form-control-static" id="classTCId_update"></p>
							</div>
						</div>
						<!-- 分类名称 -->
						<div class="form-group">
							<label class="col-sm-2 control-label">分类名称</label>
							<div class="col-sm-6">
								<input type="text" class="form-control"
									id="calssTCName_update_input" name="tclassificationName"
									required="required"> <span class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">所属分类</label>
							<div class="col-sm-4">
								<select class="form-control Second_Class_selete" name="tcScId">
								
								</select>
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
	<!-- 主体 -->
		<div id="form_of_addclass">
		<h3>添加三级分类</h3>
		<form class="form-inline" id="addClassForm">
			<div class="form-group">
				<label for="exampleInputName2">名称：</label> 
				<input type="text" class="form-control" id="className" name="tclassificationName" placeholder="Java基础"> 
				<select class="form-control Second_Class_selete" name="tcScId">
					
				</select>
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
	</div>
	<!-- 主体END -->
</body>
<script type="text/javascript">
	$(function() {
		//查询所有三级分类
		getAllThird();
		//查询所有二级分类
		getAllSecond();
	});
	//查询所有二级分类
	function getAllSecond() {
		$(".Second_Class_selete").empty();
		$.ajax({
			url:"${APP_PATH}/getAllSecond",
			type:"GET",
			success:function(result){
				$.each(result.extend.allSecond,function(index,item){
					var optionEle = $("<option></option>").attr("value",item.sclassificationId)
									.append(item.sclassificationName).appendTo(".Second_Class_selete");
				});
			}
		});
	}
	//添加三级分类
	$("#addClassBtn").click(function() {
		var className = $("#className").val();
		$.ajax({
			url : "${APP_PATH}/addTC",
			type : "POST",
			data : $("#addClassForm").serialize(),
			success : function(result) {
				if (result.code == 100) {
					$("#className").val("");
					layer.msg("添加【" + className + "】成功！");
					getAllThird();
				} else {
					layer.msg(result.extend.error);
					if (undefined != result.extend.errors.tclassificationName) {
						//有哪个字段的错误信息就显示哪个，没用错误信息的字段会显示为undefined
						layer.msg(result.extend.errors.tclassificationName);
						return false;
					}
				}
			}
		});
	});
	//查询所有的三级分类
	function getAllThird(){
		$("#displayClass tbody").empty();
		$("#className").val("");
		$.ajax({
			url : "${APP_PATH}/getThirdWhitSC",
			type : "GET",
			success : function(result) {
				//创建表格
				build_tbody(result);
			}
		});
	}
	//创建展示分类的表格
	function build_tbody(result) {
		$.each(result.extend.whitSC, function(index,item) {
			var trEle = $("<tr></tr>");
			var idTd = $("<td></td>").append(item.tclassificationId);
			var nameTd = $("<td></td>").append(item.tclassificationName);
			var nameOfScTd = $("<td></td>").append(item.secondClass.sclassificationName);
			var btnTd = $("<td></td>");
			var preEditBtn = $("<button></button>").addClass("btn btn-info btn-sm").attr("type", "button").append("修改");
			var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm").attr("type", "button").append("删除");
			var tcId = item.tclassificationId;
			var name = item.tclassificationName;
			//注册删除单击事件
			delBtn.click(function() {
				delTcById(tcId, name);
			});
			preEditBtn.click(function() {
				preEditById(tcId);
			});
			btnTd.append(preEditBtn).append(" ").append(delBtn);
			trEle.append(idTd).append(nameTd).append(nameOfScTd).append(btnTd);
			$("#displayClass tbody").append(trEle);
		});
	}
	//修改之前的准备
	function preEditById(tcId) {
		$.ajax({
			url : "${APP_PATH}/reEditTC/" + tcId,
			type : "GET",
			success : function(result) {
				$("#classTCId_update").text(result.extend.getTCById.tclassificationId);
				$("#calssTCName_update_input").val(result.extend.getTCById.tclassificationName);
				$("#editTCModal select").val([result.extend.getTCById.tcScId]);
			}
		})
		//弹出模态框
		$("#editTCModal").modal({
			backdrop : "static",
		});
	}
	//修改三级分类
	$("#editTCBtn").click(function() {
		var id = $("#classTCId_update").text();
		$.ajax({
			url : "${APP_PATH}/editTC/" + id,
			type : "PUT",
			data : $("#editTCModal form").serialize(),
			success : function(result) {
				if (result.code == 100) {
					layer.msg("修改成功！");
					$("#editTCModal").modal('hide');
					getAllThird();
				} else {
					layer.msg(result.extend.error);
					if (undefined != result.extend.errors.tclassificationName) {
						//有哪个字段的错误信息就显示哪个，没用错误信息的字段会显示为undefined
						layer.msg(result.extend.errors.tclassificationName);
					}
				}
			}
		});
	});
	//删除分类
	function delTcById(tcId, name){
		if (confirm("确定删除【" + name + "】吗？")) {
			$.ajax({
				url : "${APP_PATH}/deltcById/" + tcId,
				type : "DELETE",
				success : function(result) {
					if (result.code == 100) {
						layer.msg(result.extend.success);
						getAllThird();
					} else {
						layer.msg(result.extend.error);
					}
				}
			});
		}
	}
	
	
	
</script>
</html>