<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<meta charset="UTF-8">
<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${APP_PATH }/static/js/jQuery2.0-min.js"></script> 
<!--加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。-->
<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link href="${APP_PATH }/ADLogin/ADLstatic/css/ADLogin.css" rel="stylesheet">
<script src="${APP_PATH }/static/layer/layer.js"></script>
<title>登录</title>
</head>
<body>
	<div class="container">
      <form class="form-signin" id="login_form">
        <h2 class="form-signin-heading"><span class="glyphicon glyphicon-log-in"></span> 请登录</h2>
        
        <div class="has-feedback">
	        <label for="inputUser" class="sr-only">账号</label>
	        <input type="text" name="userName" id="inputUser" class="form-control" placeholder="账号" required="required" aria-describedby="input_username" autofocus="autofocus">
        	<span aria-hidden="true" class="form-control-feedback"></span>
        	<span id="input_username" class="help-block"></span>
        </div>
        <br>
        <div class="has-feedback">
	        <label for="inputPassword" class="sr-only">密码</label>
	        <input type="password" name="userPwd" id="inputPassword" class="form-control" placeholder="密码" required="required" aria-describedby="input_pwd">
        	<span aria-hidden="true" class="form-control-feedback"></span>
        	<span id="input_pwd" class="help-block"></span>
        </div>
        <!-- <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住密码
          </label>
        </div> -->
        <button class="btn btn-lg btn-primary btn-block" type="button" id="intoAd">登录</button>
      </form>
    </div>
</body>
<script type="text/javascript">
	//验证用户名
	$("#inputUser").blur(function() {
		$("#input_username").text("");
		$("#input_pwd").text("");
		var userEle = $("#inputUser").val();
		//alert(userEle);
		var regEle = /^[0-9]{9,12}$/;
		if(!regEle.test(userEle)){
			//验证失败前先其拿出之前的状态
			remove_class("#inputUser");
			$("#inputUser").parent().addClass("has-error");
			$("#inputUser").next().addClass("glyphicon glyphicon-remove");
			//给提交按钮注册属性用于有错误则禁止提交
			$("#inputUser").parent().attr("intova","error");
		}else{
			remove_class("#inputUser");
			$("#inputUser").parent().addClass("has-success");
			$("#inputUser").next().addClass("glyphicon glyphicon-ok");
			$("#inputUser").parent().attr("intova","success");
		}
		vainput();
	}); 
	//验证密码
	$("#inputPassword").blur(function() {
		$("#input_username").text("");
		$("#input_pwd").text("");
		var pwdEle = $(this).val();
		//alert(pwdEle);
		var regEle = /^[a-zA-Z0-9_-]{6,18}$/;
		if(!regEle.test(pwdEle)){
			remove_class("#inputPassword");
			$("#inputPassword").parent().addClass("has-error");
			$("#inputPassword").next().addClass("glyphicon glyphicon-remove");
			$("#inputPassword").parent().attr("intova","error");
		}else{
			remove_class("#inputPassword");
			$("#inputPassword").parent().addClass("has-success");
			$("#inputPassword").next().addClass("glyphicon glyphicon-ok");
			$("#inputPassword").parent().attr("intova","success");
		}
		vainput();
	});
	//校验，给按钮放行
	function vainput(){
		if($("#inputUser").parent().attr("intova")=="error"|$("#inputPassword").parent().attr("intova")=="error"){
			$("#intoAd").attr("disabled","disabled");
		}else{
			$("#intoAd").removeAttr("disabled","disabled");
		}
	}
	//通用的清楚之前状态方法
	function remove_class(ele) {
		$(ele).parent().removeClass("has-error has-success");
		$(ele).next().removeClass("glyphicon glyphicon-remove glyphicon glyphicon-ok");
	}
	//点击登录按钮
	$("#intoAd").click(function() {
		//清除之前的状态
		remove_class("#inputPassword");
		remove_class("#inputUser");
		$("#input_username").text("");
		$("#input_pwd").text("");
		$.ajax({
			url:"${APP_PATH}/validata",
			type:"POST",
			data:$("#login_form").serialize(),
			success:function(result){
				if(result.code == 200){
					if(result.extend.validate.validate_user!=null){
						$("#inputUser").parent().addClass("has-error");
						$("#input_username").text(result.extend.validate.validate_user);
					}else if(result.extend.validate.validate_pwd!=null){
						$("#input_pwd").parent().addClass("has-error");
						$("#input_pwd").text(result.extend.validate.validate_pwd);
					}else{
						layer.msg("登录失败！");
					}
				}else if(result.code == 100){
					window.location.href="${APP_PATH}/loginInto/"+result.extend.success_name+"/"+result.extend.success_pwd
				}else{
					layer.msg("登录失败！");
				}
			}
			
		});
	});
</script>
</html>