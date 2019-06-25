$(function() {
	//查询博客总数量
	find_count_blogs();
	
	//查询最新博客
	find_new_blog();
	
});
function find_count_blogs() {
	$.ajax({
		url:path+"/count_blogs",
		type:"GET",
		success:function(result){
			$(".banner .cont .amount .daily-record").empty();
			//alert(result.msg);
			$(".banner .cont .amount .daily-record").append(result.extend.num_blogs);
		}
	});
}

function find_new_blog() {
	var hotBlogs = $("#hot_blogs");
	hotBlogs.empty();
	$.ajax({
		url:path+"/getNewBlogs/"+0,
		data:"pn="+1,
		type:"GET",
		success:function(result){
			/*<div class="layui-col-xs12 layui-col-sm6 layui-col-md6">
				<div class="item-cont">
					<h3>
						空间立体效果图，完美呈现最终效果
						<button class="layui-btn layui-btn-danger new-icon">new</button>
					</h3>
					<h5>2019/5/12</h5>
					<p>室内设计作为一门新兴的学科，尽管还只是近数十年的事，但是人们有意识地对自己生活、生产活动的室内进行安排布置，甚至美化装饰，赋予室内环境以所祈使的气氛，却早巳从人类文明伊始的时期就已存在</p>
					<a href="details.html" class="go-icon"></a>
				</div>
			</div>*/
			$.each(result.extend.newBlogs.list,function(index,item){
				var mainDiv = $("<div></div>").addClass("layui-col-xs12 layui-col-sm6 layui-col-md6");
				var itemDiv = $("<div></div>").addClass("item-cont");
				var h3Ele = $("<h3></h3>").append(item.blogTitle);
				var newBtn = $("<button></button>").addClass("layui-btn layui-btn-danger new-icon").append("new").appendTo(h3Ele);
				var upTime = $("<h5></h5>").append(item.blogUptime);
				//切割字符
				var art = item.blogArticle.slice(0,150)+"...";
				var pEle = $("<p></p>").append(art);
				var aEle = $("<a></a>").addClass("go-icon").attr("href","readBlog/"+item.blogId);
				itemDiv.append(h3Ele).append(upTime).append(pEle).append(aEle).appendTo(mainDiv);
				hotBlogs.append(mainDiv);
			});
		}
	});
}














