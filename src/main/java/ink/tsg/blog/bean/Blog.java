package ink.tsg.blog.bean;

import java.sql.Date;

import org.hibernate.validator.constraints.NotBlank;

import ink.tsg.classification.third.bean.ThirdClass;

public class Blog {
    private Integer blogId;
    
    @NotBlank(message="文章标题不能为空！")
    private String blogTitle;

    private Date blogUptime;

    private Integer blogTcId;
    
    @NotBlank(message="文章内容不能为空！")
    private String blogArticle;
    
    private ThirdClass thirdClass; 

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public Date getBlogUptime() {
        return blogUptime;
    }

    public void setBlogUptime(Date blogUptime) {
        this.blogUptime = blogUptime;
    }

    public Integer getBlogTcId() {
        return blogTcId;
    }

    public void setBlogTcId(Integer blogTcId) {
        this.blogTcId = blogTcId;
    }

    public String getBlogArticle() {
        return blogArticle;
    }

    public void setBlogArticle(String blogArticle) {
        this.blogArticle = blogArticle == null ? null : blogArticle.trim();
    }

	public ThirdClass getThirdClass() {
		return thirdClass;
	}

	public void setThirdClass(ThirdClass thirdClass) {
		this.thirdClass = thirdClass;
	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", blogTitle=" + blogTitle + ", blogUptime=" + blogUptime + ", blogTcId="
				+ blogTcId + ", blogArticle=" + blogArticle + ", thirdClass=" + thirdClass + "]";
	}
	
	
	
}