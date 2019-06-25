$(function() {
	//查询学习笔记下的所有二级分类
	find_study_seclass();
	
	//查询最新博客
	//find_new_blog();
	
});
//得到所有二级分类，建立时间线
function find_study_seclass() {
	var study_time = $("#study_time");
	study_time.empty();
	$.ajax({
		url:path+"/getAllSecond",
		type:"GET",
		success:function(result){
			/*<li class="layui-timeline-item">
				<i class="layui-icon layui-timeline-axis">&#xe63f;</i>
				<div class="layui-timeline-content layui-text">
					<h3 class="layui-timeline-title">JAVA <i class="layui-icon">&#xe715;</i></h3>
				       
				</div>
			</li>*/
			
			$.each(result.extend.allSecond,function(index,item){
				if(item.scFcId == 1){
					var timelineiIEle = $("<i>&#xe63f;</i>").addClass("layui-icon layui-timeline-axis");
					var h3I = $("<i>&#xe715;</i>").addClass("layui-icon");
					var h3Ele = $("<h3></h3>").addClass("layui-timeline-title").append(item.sclassificationName).append(h3I);
					var divEle = $("<div></div>").addClass("layui-timeline-content layui-text").append(h3Ele);
					var id =item.sclassificationId;
					find_thclass(divEle,id);
					var liEle = $("<li></li>").addClass("layui-timeline-item").append(timelineiIEle).append(divEle);
					study_time.append(liEle);
				}
			});
		}
	});
}
//查询对应的三级分类
function find_thclass(divEle,id) {
	$.ajax({
		url:path+"/getAllThclassByFk/"+id,
		type:"GET",
		success:function(result){
		/*	<button class="layui-btn layui-btn-radius">JAVA基础</button>
		       <button class="layui-btn layui-btn-radius">JAVA基础</button>*/
			$.each(result.extend.thClassByFK,function(index,item){
				var btnEle =$("<button></button>").addClass("layui-btn layui-btn-radius").append(item.tclassificationName);
				var id = item.tclassificationId;
				btnEle.click(function() {
					find_blogs_fk(id,1);
				});
				divEle.append(btnEle);
			});
		}
	});
}
//根据外键查询博客
function find_blogs_fk(id,pn) {
	$("#blogs_by_fk .item").empty();
	$("#blogs_by_fk .blog_page").empty();
	//alert(id);
	$.ajax({
		url:path+"/getNewBlogs/"+id,
		data:"pn="+pn,
		type:"GET",
		success:function(result){
			//创建内容展示
			build_item_box(result);
			//创建分页
			build_page(result,id);
		}
	});
}
function build_item_box(result) {
	var divItem = $("#blogs_by_fk .item");
	/*	<h2>java基础</h2> 
		<div class="whisper-title">
			<i class="layui-icon layui-icon-date"></i><span class="date">2018/06/08</span>
		</div>
		<p class="text-cont">
			一直听说牛油果吃起来像肥皂、肥肉，虽然很难吃，但是价格却很贵，我还是想尝试一下。今天公司新到了新西兰牛油果，这是新西兰牛油果是第一次在中国上市，个头比普通牛油果大了一倍，被誉为“超牛果”。好奇心驱使我尝了一颗，第一次吃牛油果没有见识，切开牛油果费了好大劲，切成了这样。
		</p>
		<div class="op-list">
				<p>阅读全文</p>
		</div>
		*/
	$.each(result.extend.newBlogsWhitFk.list,function(index,item){
		var titleI = $("<i></i>").addClass("layui-icon layui-icon-date");
		var titleSpan = $("<span></span>").addClass("date").append(item.blogUptime);
		var titleDiv = $("<div></div>").addClass("whisper-title").append(titleI).append(titleSpan);
		var h2Ele = $("<h2></h2>").append(item.blogTitle);
		//切割字符
		var art = item.blogArticle.slice(0,150)+"...";
		var pEle = $("<p></p>").addClass("text-cont").append(art);
		var aEle = $("<a></a>").append("阅读全文").attr("href","readBlog/"+item.blogId);
		var readP = $("<p></p>").append(aEle);
		var readDiv = $("<div></div>").addClass("op-list").append(readP);
		divItem.append(h2Ele).append(titleDiv).append(pEle).append(readDiv);
	});
}
function build_page(result,id) {
	/*<button class="layui-btn layui-btn-sm layui-btn-warm">上一页</button>
		<button class="layui-btn layui-btn-sm layui-btn-warm">下一页</button>*/
	var previous = $("<button></button>").addClass("layui-btn layui-btn-sm layui-btn-warm").append("上一页");
	var page_info = result.extend.newBlogsWhitFk;
	if(page_info.hasPreviousPage == false){
		previous.addClass("layui-btn-disabled");
		previous.click(function() {
			layer.msg("不存在上一页！");
		});
	}else{
		previous.click(function() {
			find_blogs_fk(id,page_info.pageNum-1);
		});
	}
	var next = $("<button></button>").addClass("layui-btn layui-btn-sm layui-btn-warm").append("下一页");
	if(page_info.hasNextPage == false){
		next.addClass("layui-btn-disabled");
		next.click(function() {
			layer.msg("不存在下一页！");
		});
	}else{
		next.click(function() {
			find_blogs_fk(id,page_info.pageNum+1);
		});
	}
	$("#blogs_by_fk .blog_page").append(previous).append(next);
}









