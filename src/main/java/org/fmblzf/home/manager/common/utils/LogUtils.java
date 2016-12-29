package org.fmblzf.home.manager.common.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import com.alibaba.fastjson.JSON;
/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp Maven Webapp 
 * 	 
 * @ClassDecription：日志操作类	 
 * @ClassName：org.fmblzf.home.manager.common.utils.LogUtils 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-8 下午3:09:03	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-8 下午3:09:03	 
 * @Tag： 
 * @version V1.0 
 *
 */
public class LogUtils {
	
	/**
	 * 
	 * @Copy：2016-fmblzf 
	 * @ProjectName：webapp Maven Webapp 
	 * 	 
	 * @ClassDecription：日志级别枚举类 
	 * @ClassName：org.fmblzf.home.manager.common.utils.LogLevel 	 
	 * @Creator：zhaofeng	 
	 * @CreatTime：2016-4-8 下午3:09:20	 
	 * @FixPerson：zhaofeng  
	 * @FixTime：2016-4-8 下午3:09:20	 
	 * @Tag： 
	 * @version V1.0 
	 *
	 */
	public static enum LogLevel{
		/**
		 * 信息显示类别
		 */
		INFO(Priority.INFO_INT),
		/**
		 * 警告类别
		 */
		WARN(Priority.WARN_INT),
		/**
		 * debug类别
		 */
		DEBUG(Priority.DEBUG_INT),
		/**
		 * 错误信息类别
		 */
		ERROR(Priority.ERROR_INT),
		/**
		 * 重大错误类别
		 */
		FATAL(Priority.FATAL_INT);
		/**
		 * 枚举类的值
		 */
		private int value;
		/**
		 * 
		 * @Title: getValue 
		 * @Description: TODO 获取value的值
		 * @return 
		 *
		 */
		public int getValue() {
			return value;
		}
		/**
		 * 
		 * @Title: setValue 
		 * @Description: TODO 设置value的值
		 * @param value 
		 *
		 */
		public void setValue(int value) {
			this.value = value;
		}
		/**
		 * 
		 * Title: 枚举类 
		 * Description:构造器  
		 * @param value  
		 *
		 */
		private LogLevel(int value){
			this.value = value;
		}
		
	}
	/**
	 * 
	 * @Title: log 
	 * @Description: TODO 打印日志信息
	 * @param claz 所在类的日志
	 * @param level 日志级别
	 * @param object 操作实例
	 * @param t 异常实例
	 *
	 */
	public static void log(Class<?> claz,LogLevel level,Object object,Throwable t){
		if(LogLevel.INFO == level){
			//打印信息类
			Logger.getLogger(claz).info(JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss"),t);			
		}else if(LogLevel.DEBUG == level){
			//打印debug类
			Logger.getLogger(claz).debug(JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss"),t);	
		}else if(LogLevel.WARN == level){
			//打印警告类
			Logger.getLogger(claz).warn(JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss"),t);	
		}else if(LogLevel.ERROR == level){
			//打印错误类
			Logger.getLogger(claz).error(JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss"),t);	
		}else if(LogLevel.FATAL == level){
			//打印重大错误类
			Logger.getLogger(claz).fatal(JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss"),t);	
		}
		String data = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
		//打印log文件日志
		FileUtils.writeFile(data, "D:\\log\\log.txt", true);
		
	}
	
}
