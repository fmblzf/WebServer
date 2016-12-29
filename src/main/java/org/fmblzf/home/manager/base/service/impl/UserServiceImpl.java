package org.fmblzf.home.manager.base.service.impl;

import org.fmblzf.home.manager.base.bean.User;
import org.fmblzf.home.manager.base.dao.UserMapper;
import org.fmblzf.home.manager.base.service.IUserService;
import org.fmblzf.home.manager.common.exception.NoMethodException;
import org.fmblzf.home.manager.common.exception.ServiceException;
import org.fmblzf.home.manager.common.service.BaseService;
import org.fmblzf.home.manager.common.utils.ReflectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @Copy：2016-fmblzf
 * @ProjectName：webapp Maven Webapp
 * 
 * @ClassDecription：用户服务类
 * @ClassName：org.fmblzf.home.manager.base.service.impl.UserServiceImpl
 * @Creator：zhaofeng
 * @CreatTime：2016-4-8 下午12:09:39
 * @FixPerson：zhaofeng
 * @FixTime：2016-4-8 下午12:09:39
 * @Tag：
 * @version V1.0
 * 
 */
@Service("userService")
public class UserServiceImpl extends BaseService implements IUserService {

	@Autowired
	private UserMapper userMapper = null;

	@Override
	public Object action(Object instance,JSONObject jsonObject) throws ServiceException, NoMethodException {
		// TODO Auto-generated method stub
		JSONObject data = jsonObject.getJSONObject("data");
		User u = JSONObject.toJavaObject(data, User.class);
		String methodName = jsonObject.getString("method");
		Object object = null;
		try {
			object = ReflectUtils.invoke(instance, methodName,
					new Class[] { User.class }, new Object[] { u });
		} catch (NoMethodException e) {
			// TODO Auto-generated catch block
			throw new NoMethodException("客户端配置方法-"+methodName+"未找到，请重新配置或者联系服务端管理员");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("方法-"+methodName+"-执行异常，请联系服务器端管理员");
		}

		return object;
	}
	
	@Override
	public int register(User u) {
		// TODO Auto-generated method stub
		return userMapper.insert(u);
	}

	@Override
	public User login(User u) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByUser(u);
	}

	@Override
	public User login(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		JSONObject data = jsonObject.getJSONObject("data");
		User u = JSONObject.toJavaObject(data, User.class);
		return login(u);
	}

}
