package org.fmblzf.home.manager.base.dao;

import java.util.List;

import org.fmblzf.home.manager.base.bean.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    List<UserInfo> getAll();
    
    UserInfo selectByUserInfo(UserInfo u);
}