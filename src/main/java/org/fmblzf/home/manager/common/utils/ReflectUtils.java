package org.fmblzf.home.manager.common.utils;

import java.lang.reflect.Method;

import org.fmblzf.home.manager.common.exception.BaseException;
import org.fmblzf.home.manager.common.exception.NoMethodException;
import org.fmblzf.home.manager.common.exception.ServiceException;


/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp-Maven-Webapp 
 * 	 
 * @ClassDecription：反射工具类	 
 * @ClassName：org.fmblzf.home.manager.common.utils.ReflectUtils 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-16 下午6:24:02	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-16 下午6:24:02	 
 * @Tag： 
 * @version V1.0 
 *
 */
public class ReflectUtils {
	/**
	 * 
	 * @Title: getMethod 
	 * @Description: TODO 通过反射获取方法
	 * @param clazz 对应的实体类
	 * @param methodName 方法名称
	 * @param classes 方法参数类型的集合
	 * @return 
	 *
	 */
	public static Method getMethod(Class<?> clazz,String methodName,Class<?>[] classes){
		Method method = null;
		try {
			method = clazz.getDeclaredMethod(methodName, classes);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			if(clazz.getSuperclass() != null){
				method = getMethod(clazz.getSuperclass(),methodName , classes);
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			LogUtils.log(clazz, LogUtils.LogLevel.ERROR, methodName, e);
		}		
		return method;
	}
	/**
	 * 
	 * @Title: invoke 
	 * @Description: TODO 反射执行方法
	 * @param obj 对应的实体类
	 * @param methodName 方法名称
	 * @param classes 参数类型集合
	 * @param objects 具体的参数
	 * @return
	 * @throws NoMethodException 没有找到对应的方法异常
	 * @throws ServiceException 方法执行失败异常
	 *
	 */
	public static Object invoke(Object obj,String methodName,Class<?>[] classes,Object[] objects) throws NoMethodException, ServiceException{
		
		Method method = getMethod(obj.getClass(), methodName, classes);
		if(method == null){
			LogUtils.log(obj.getClass(), LogUtils.LogLevel.ERROR, methodName, new Exception("找不到对应的方法"+methodName));
			throw new NoMethodException("系统未找到对应的"+methodName+"方法，请联系服务器端管理员");
		}
		//允许调用私有方法
		method.setAccessible(true);
		
		Object object = null;
		try {			
			object = method.invoke(obj, objects);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LogUtils.log(obj.getClass(), LogUtils.LogLevel.ERROR, objects, new Exception("方法-"+method+"-执行失败"));
			LogUtils.log(obj.getClass(), LogUtils.LogLevel.ERROR, objects, e);
			throw new ServiceException("方法-"+methodName+"-执行异常，请联系服务器端管理员");
		} 
		return object;		
	}
	public static Object invoke(Object obj,String methodName,Class<?>[] classes) throws NoSuchMethodException, BaseException{
		return invoke(obj, methodName, classes, new Object[]{});
	}
	public static Object invoke(Object obj,String methodName) throws NoSuchMethodException, BaseException{
		return invoke(obj, methodName, new Class[]{}, new Object[]{});
	}
}
