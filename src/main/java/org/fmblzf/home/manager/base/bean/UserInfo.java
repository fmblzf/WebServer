package org.fmblzf.home.manager.base.bean;

import org.fmblzf.home.manager.common.bean.BaseSuperEntity;
/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp-Maven-Webapp 
 * 	 
 * @ClassDecription：用户信息实体类	 
 * @ClassName：org.fmblzf.home.manager.base.bean.UserInfo 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-10 下午7:24:39	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-10 下午7:24:39	 
 * @Tag： 
 * @version V1.0 
 *
 */
public class UserInfo extends BaseSuperEntity   {
    private Integer id;

    private Integer userid;

    private Byte type;

    private String name;

    private String tel;

    private Integer districtLv1;

    private Integer districtLv2;

    private Integer districtLv3;

    private Integer picNum;

    private String address;

    private Byte cardtype;

    private String cardno;

    private Byte sex;

    private String birthday;

    private String provincename;

    private String cityname;

    private String countyname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Integer getDistrictLv1() {
        return districtLv1;
    }

    public void setDistrictLv1(Integer districtLv1) {
        this.districtLv1 = districtLv1;
    }

    public Integer getDistrictLv2() {
        return districtLv2;
    }

    public void setDistrictLv2(Integer districtLv2) {
        this.districtLv2 = districtLv2;
    }

    public Integer getDistrictLv3() {
        return districtLv3;
    }

    public void setDistrictLv3(Integer districtLv3) {
        this.districtLv3 = districtLv3;
    }

    public Integer getPicNum() {
        return picNum;
    }

    public void setPicNum(Integer picNum) {
        this.picNum = picNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Byte getCardtype() {
        return cardtype;
    }

    public void setCardtype(Byte cardtype) {
        this.cardtype = cardtype;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename == null ? null : provincename.trim();
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    public String getCountyname() {
        return countyname;
    }

    public void setCountyname(String countyname) {
        this.countyname = countyname == null ? null : countyname.trim();
    }
}