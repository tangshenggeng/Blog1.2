<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-md-2">
	<div class="panel-group" id="accordion" role="tablist"
		aria-multiselectable="true">
		<div class="panel panel-default">
			<div class="panel-heading" role="tab" id="headingOne">
				<h4 class="panel-title">
					<a role="button" data-toggle="collapse" data-parent="#accordion"
						href="#collapseOne" aria-expanded="true"
						aria-controls="collapseOne"><span class="glyphicon glyphicon-heart"></span> 客户管理 </a>
				</h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in"
				role="tabpanel" aria-labelledby="headingOne">
				<div class="panel-body">
					<ul class="nav nav-pills nav-stacked ">
						<li role="presentation"><a href="${APP_PATH }/csts">查询所有</a></li>
						<li role="presentation"><a href="${APP_PATH }/cstsDel">已删除</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- <div class="panel panel-default">
			<div class="panel-heading" role="tab" id="headingTwo">
				<h4 class="panel-title">
					<a class="collapsed" role="button" data-toggle="collapse"
						data-parent="#accordion" href="#collapseTwo" aria-expanded="false"
						aria-controls="collapseTwo"><span
						class="glyphicon glyphicon-user"></span> 管理员 </a>
				</h4>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel"
				aria-labelledby="headingTwo">
				<div class="panel-body">
					<ul class="nav nav-pills nav-stacked ">
						<li><a href="#"><span class="badge">4</span> 最近添加 </a></li>
						<li>
							<a href="#"><span class="glyphicon glyphicon-pencil"></span> 修改密码</a>
						</li>
						<li>
							<a href="#"><span class="glyphicon glyphicon-alert"></span> 退出系统</a>
						</li>
					</ul>
				</div>
			</div>
		</div> -->


		<%-- <div class="panel panel-default">
	    <div class="panel-heading" role="tab" id="headingtwo">
	      <h4 class="panel-title">
	        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapsetwo" aria-expanded="true" aria-controls="collapsetwo">
				平台管理
	        </a>
	      </h4>
	    </div>
	    <div id="collapsetwo" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingtwo">
	      <div class="panel-body">
	      	<ul class="nav nav-pills nav-stacked ">
				<li role="presentation"><a href="${APP_PATH }/admin/lj_cst/displayPlats.jsp">所有平台</a></li>
			</ul>
	      </div>
	    </div>
	  </div> --%>
	</div>
</div>