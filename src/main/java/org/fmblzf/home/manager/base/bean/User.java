package org.fmblzf.home.manager.base.bean;

import org.fmblzf.home.manager.common.bean.BaseSuperEntity;
/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp-Maven-Webapp 
 * 	 
 * @ClassDecription：用户实体类	 
 * @ClassName：org.fmblzf.home.manager.base.bean.User 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-10 下午7:24:11	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-10 下午7:24:11	 
 * @Tag： 
 * @version V1.0 
 *
 */
public class User extends BaseSuperEntity  {
    private Integer userid;

    private String username;

    private String password;

    private String nickname;

    private String tel;

    private String regip;

    private Integer regtime;

    private String lastloginip;

	private String lastlogintime;

    private Byte usertype;

    private Byte islock;

    private String email;

    private String shopid;

    private String auth;

    private Integer updatetime;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getRegip() {
        return regip;
    }

    public void setRegip(String regip) {
        this.regip = regip == null ? null : regip.trim();
    }

    public Integer getRegtime() {
        return regtime;
    }

    public void setRegtime(Integer regtime) {
        this.regtime = regtime;
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip == null ? null : lastloginip.trim();
    }

    public String getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(String lastlogintime) {
        this.lastlogintime = lastlogintime == null ? null : lastlogintime.trim();
    }

    public Byte getUsertype() {
        return usertype;
    }

    public void setUsertype(Byte usertype) {
        this.usertype = usertype;
    }

    public Byte getIslock() {
        return islock;
    }

    public void setIslock(Byte islock) {
        this.islock = islock;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid == null ? null : shopid.trim();
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth == null ? null : auth.trim();
    }

    public Integer getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Integer updatetime) {
        this.updatetime = updatetime;
    }


    @Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username
				+ ", password=" + password + ", nickname=" + nickname
				+ ", tel=" + tel + ", regip=" + regip + ", regtime=" + regtime
				+ ", lastloginip=" + lastloginip + ", lastlogintime="
				+ lastlogintime + ", usertype=" + usertype + ", islock="
				+ islock + ", email=" + email + ", shopid=" + shopid
				+ ", auth=" + auth + ", updatetime=" + updatetime + "]";
	}
}