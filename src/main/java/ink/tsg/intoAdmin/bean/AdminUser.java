package ink.tsg.intoAdmin.bean;

import javax.validation.constraints.Pattern;

public class AdminUser {
    private Integer userId;
    
    @Pattern(regexp="^[0-9]{9,12}$",message="用户名格式错误")
    private String userName;
    
    @Pattern(regexp="^[a-zA-Z0-9_-]{6,18}$",message="密码格式错误")
    private String userPwd;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

	@Override
	public String toString() {
		return "AdminUser [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + "]";
	}
}