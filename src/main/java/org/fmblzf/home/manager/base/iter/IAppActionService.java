package org.fmblzf.home.manager.base.iter;

import org.fmblzf.home.manager.common.exception.NoMethodException;
import org.fmblzf.home.manager.common.exception.ServiceException;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp Maven Webapp 
 * 	 
 * @ClassDecription：app交互式的规范	--app需要的服务类必须按照这个规范来实现 
 * @ClassName：org.fmblzf.home.manager.base.iter.IAppAction 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-21 下午5:26:45	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-21 下午5:26:45	 
 * @Tag： 
 * @version V1.0 
 *
 */
public interface IAppActionService {
	/**
	 * 
	 * @Title: action 
	 * @Description: TODO 用于公共方法，实现服务的入口方法，进而分发到不同的方法中去
	 * @param object 对应的类实例
	 * @param jsonObject json数据集
	 * @return 
	 *
	 */
	public abstract Object action(Object object,JSONObject jsonObject)throws ServiceException,NoMethodException;
}
