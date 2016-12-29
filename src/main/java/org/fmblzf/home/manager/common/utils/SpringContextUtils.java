package org.fmblzf.home.manager.common.utils;

import org.fmblzf.home.manager.common.exception.NoServiceException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * @Copy：2016-fmblzf
 * @ProjectName：webapp-Maven-Webapp
 * 
 * @ClassDecription：操作Spring上下文内容
 * @ClassName：org.fmblzf.home.manager.common.utils.SpringContextUtils
 * @Creator：zhaofeng
 * @CreatTime：2016-4-10 下午9:55:13
 * @FixPerson：zhaofeng
 * @FixTime：2016-4-10 下午9:55:13
 * @Tag：
 * @version V1.0
 * 
 */
public class SpringContextUtils implements ApplicationContextAware {
	/**
	 * Spring应用的上下文
	 */
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		SpringContextUtils.applicationContext = applicationContext;
	}
	/**
	 * 
	 * @Title: getBean 
	 * @Description: TODO 根据beanName获取对应的实体类
	 * @param beanName 名称
	 * @return  返回值
	 * @throws NoServiceException 未找到对应的spring bean 异常
	 *
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) throws NoServiceException {
 		checkApplicationContext();
		Object object = null;
		try {
			object = applicationContext.getBean(beanName);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NoServiceException("系统未找到"+beanName+"服务类");
		}
		return (T) object;
	}
	/**
	 * 
	 * @Title: getBean 
	 * @Description: TODO 根据beanName和class获取对应的实体类
	 * @param beanName 名称
	 * @param clazz 对应的class
	 * @return  返回值
	 * @throws NoServiceException 未找到对应的spring bean 异常
	 *
	 */
	public static <T> T getBean(String beanName, Class<T> clazz) throws NoServiceException {
		checkApplicationContext();
		Object object = null;
		try {
			object = applicationContext.getBean(beanName, clazz);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NoServiceException("系统未找到"+beanName+"服务类");
		}		 
		return clazz.cast(object);
	}
	/**
	 * 
	 * @Title: getBean 
	 * @Description: TODO 根据class获取对应的实体类
	 * @param clazz 对应的class
	 * @return  返回值
	 * @throws NoServiceException 未找到对应的spring bean 异常
	 *
	 */
	public static <T> T getBean(Class<T> clazz) throws NoServiceException {
		checkApplicationContext();
		Object object = null;
		try {
			object = applicationContext.getBean(clazz);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NoServiceException("系统未找到"+clazz.getName()+"服务类");
		}
		return clazz.cast(object);
	}

	/**
	 * 
	 * @Title: cleanApplicationContext 
	 * @Description: TODO  清除applicationContext静态变量.
	 *
	 */
	public static void cleanApplicationContext() {
		applicationContext = null;
	}

	/**
	 * 
	 * @Title: checkApplicationContext
	 * @Description: TODO 检查applicationContext是否为空
	 * 
	 */
	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException(
					"applicaitonContext未注入,请在spring.xml中定义SpringContextUtils");
		}
	}

}
