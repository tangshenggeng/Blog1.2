<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<body>
	<div id="writeNewBlog">
		<form class="form-horizontal">
			<div class="form-group">
				<h3>编写博客</h3>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="blogTitle"
					placeholder="文章标题" id="newBlogTitle">
			</div>
			<div class="form-group">
				<div id="wangEditor">
				</div>
			</div>
			<br>
			<div class="form-group">
				<select class="form-control" name="blogTcId" id="Third_Class_selete">
				</select>
			</div>
			<div class="form-group">
				<textarea class="form-control" name="blogArticle" id="newBlogArticle" required="required" readonly="readonly"></textarea>
			</div>
			<div class="form-group">
				<button type="button" class="btn btn-info" id="addNewBlog">提交</button>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		var E = window.wangEditor
		var editor = new E('#wangEditor')
		var $text1 = $('#newBlogArticle')
		editor.customConfig.onchange = function(html) {
			// 监控变化，同步更新到 textarea
			$text1.val(html)
		},
		editor.customConfig.emotions = [
	        {
	            // tab 的标题
	            title: '默认',
	            // type -> 'emoji' / 'image'
	            type: 'image',
	            // content -> 数组
	            content: [
	                {
	                    alt: '[喵喵]',
	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/7b/2018new_miaomiao_thumb.png'
	                },
	                {
	                    alt: '[doge]',
	                    src: 'http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/a1/2018new_doge02_org.png'
	                }
	           	 ]
	        	},
	        ]
		editor.create();
		// 初始化 textarea 的值
		$text1.val(editor.txt.html());
		
		//得到所有三级分类
		getAllTclass();
		
	})
	function getAllTclass(){
		$("#Third_Class_selete").empty();
		$.ajax({
			url:"${APP_PATH}/getAllThird",
			type:"GET",
			success:function(result){
				$.each(result.extend.tclass,function(index,item){
					var optionEle = $("<option></option>").attr("value",item.tclassificationId)
									.append(item.tclassificationName).appendTo("#Third_Class_selete");
				});
			}
		});
	}
	$("#addNewBlog").click(function () {
		$.ajax({
			url:"${APP_PATH}/addNewBlog",
			type:"POST",
			data:$("#writeNewBlog form").serialize(),
			success:function(result){
				if(result.code==100){
					layer.msg("发表成功！");
				}else{
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
</script>
</html>