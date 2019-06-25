package ink.tsg.cst.bean;

import java.sql.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class Customer {
    private Integer cstId;
    
    //JSR303校验
    @Pattern(regexp="(^[a-zA-Z0-9_-]{6,20}$)",message="联系应为6-20位的字母、数字、-、_")
    private String cstCon;
    
    @NotBlank(message="学校名称格式错误")
    private String cstScn;

    @NotBlank(message="账号格式错误")
    private String cstNum;

    @NotBlank(message="密码格式错误")
    private String cstPwd;
    
    @NotBlank(message="课程格式错误")
    private String cstCurr;

    private Integer cstPlaId;

    private java.sql.Date upTime;

    private Boolean del;
    
    //查询学生时一并查出平台
    private Platform platform;
    


	public Customer(Integer cstId, String cstCon, String cstScn, String cstNum, String cstPwd, String cstCurr,
			Integer cstPlaId, Date upTime, Boolean del) {
		super();
		this.cstId = cstId;
		this.cstCon = cstCon;
		this.cstScn = cstScn;
		this.cstNum = cstNum;
		this.cstPwd = cstPwd;
		this.cstCurr = cstCurr;
		this.cstPlaId = cstPlaId;
		this.upTime = upTime;
		this.del = del;
	}

	public Customer() {
		super();
	}

	public Integer getCstId() {
        return cstId;
    }

    public void setCstId(Integer cstId) {
        this.cstId = cstId;
    }

    public String getCstCon() {
        return cstCon;
    }

    public void setCstCon(String cstCon) {
        this.cstCon = cstCon == null ? null : cstCon.trim();
    }

    public String getCstScn() {
        return cstScn;
    }

    public void setCstScn(String cstScn) {
        this.cstScn = cstScn == null ? null : cstScn.trim();
    }

    public String getCstNum() {
        return cstNum;
    }

    public void setCstNum(String cstNum) {
        this.cstNum = cstNum == null ? null : cstNum.trim();
    }

    public String getCstPwd() {
        return cstPwd;
    }

    public void setCstPwd(String cstPwd) {
        this.cstPwd = cstPwd == null ? null : cstPwd.trim();
    }

    public String getCstCurr() {
        return cstCurr;
    }

    public void setCstCurr(String cstCurr) {
        this.cstCurr = cstCurr == null ? null : cstCurr.trim();
    }

    public Integer getCstPlaId() {
        return cstPlaId;
    }

    public void setCstPlaId(Integer cstPlaId) {
        this.cstPlaId = cstPlaId;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = (java.sql.Date) upTime;
    }

    public Boolean getDel() {
        return del;
    }

    public void isDel(Boolean del) {
        this.del = del;
    }

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	@Override
	public String toString() {
		return "Customer [cstId=" + cstId + ", cstCon=" + cstCon + ", cstScn=" + cstScn + ", cstNum=" + cstNum
				+ ", cstPwd=" + cstPwd + ", cstCurr=" + cstCurr + ", cstPlaId=" + cstPlaId + ", upTime=" + upTime
				+ ", del=" + del + ", platform=" + platform + "]";
	}

}