package org.fmblzf.home.manager.base.bean;

import org.fmblzf.home.manager.common.bean.BaseSuperEntity;
/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp-Maven-Webapp 
 * 	 
 * @ClassDecription：区域实体类	 
 * @ClassName：org.fmblzf.home.manager.base.bean.District 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-10 下午7:23:44	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-10 下午7:23:44	 
 * @Tag： 
 * @version V1.0 
 *
 */
public class District extends BaseSuperEntity {
    private Integer id;

    private String did;

    private String name;

    private String enname;

    private Byte level;

    private Boolean usetype;

    private Integer upid;

    private Short displayorder;

    private Byte ishot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did == null ? null : did.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname == null ? null : enname.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Boolean getUsetype() {
        return usetype;
    }

    public void setUsetype(Boolean usetype) {
        this.usetype = usetype;
    }

    public Integer getUpid() {
        return upid;
    }

    public void setUpid(Integer upid) {
        this.upid = upid;
    }

    public Short getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(Short displayorder) {
        this.displayorder = displayorder;
    }

    public Byte getIshot() {
        return ishot;
    }

    public void setIshot(Byte ishot) {
        this.ishot = ishot;
    }
}