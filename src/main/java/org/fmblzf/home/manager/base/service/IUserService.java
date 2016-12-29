package org.fmblzf.home.manager.base.service;

import org.fmblzf.home.manager.base.bean.User;
import org.fmblzf.home.manager.base.iter.IAppActionService;

import com.alibaba.fastjson.JSONObject;
/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp Maven Webapp 
 * 	 
 * @ClassDecription：用户服务接口	 
 * @ClassName：org.fmblzf.home.manager.base.service.IUserService 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-8 下午12:10:07	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-8 下午12:10:07	 
 * @Tag： 
 * @version V1.0 
 *
 */
public interface IUserService extends IAppActionService{	

	/**
	 * 
	 * @Description: TODO 用户注册
	 * @Title: register 
	 * @param u 注册的用户信息
	 * @return 
	 *
	 */
	public int register(User u);
	/**
	 * 
	 * @Title: login 
	 * @Description: TODO 用户登录
	 * @param u 登陆用户的信息
	 * @return 
	 *
	 */
	public User login(User u);
	/**
	 * 
	 * @Title: login 
	 * @Description: TODO 用户登录
	 * @param jsonObject json对象
	 * @return 
	 *
	 */
	public User login(JSONObject jsonObject);
}
