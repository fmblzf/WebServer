package org.fmblzf.home.manager.app.common;

import org.fmblzf.home.manager.common.exception.NoMethodException;
import org.fmblzf.home.manager.common.exception.NoServiceException;
import org.fmblzf.home.manager.common.exception.ServiceException;
import org.fmblzf.home.manager.common.utils.ReflectUtils;
import org.fmblzf.home.manager.common.utils.SpringContextUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 
 * @Copy：2016-fmblzf
 * @ProjectName：webapp-Maven-Webapp
 * 
 * @ClassDecription：@Service分流器，控制调用不同的service和方法
 * @ClassName：org.fmblzf.home.manager.app.DispatcherService
 * @Creator：zhaofeng
 * @CreatTime：2016-4-10 下午7:30:37
 * @FixPerson：zhaofeng
 * @FixTime：2016-4-10 下午7:30:37
 * @Tag：
 * @version V1.0
 * 
 */
public class DispatcherService {

	/**
	 * 
	 * @Title: dispatcher
	 * @Description: TODO 分流@Service，执行service具体的方法
	 * @param jsonObject  从前台获取的数据集合
	 * @return
	 * 
	 */
	public static ActionMessage dispatcher(JSONObject jsonObject) {
		String serviceName = jsonObject.getString("service");
//		String methodName = jsonObject.getString("method");
		Object baseService = null;
		try {
			baseService = SpringContextUtils.getBean(serviceName);
		} catch (NoServiceException e) {
			//未找到对应的服务
			return ActionMessage.getActionMessage(e);
		}
		Object result = null;
		try {
			result = ReflectUtils.invoke(baseService, "action", new Class[]{Object.class,JSONObject.class}, new Object[]{baseService,jsonObject});
		} catch (NoMethodException e) {
			// TODO Auto-generated catch block
			//未找到对应服务的方法
			return ActionMessage.getActionMessage(e);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			//未找到对应服务的方法
			return ActionMessage.getActionMessage(e);
		}
		//设置返回的数据
		ActionMessage action = ActionMessage.getActionMessage(null);
		action.setData(result);
		return action;
	}
}
