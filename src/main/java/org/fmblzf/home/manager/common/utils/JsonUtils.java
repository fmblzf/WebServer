package org.fmblzf.home.manager.common.utils;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp Maven Webapp 
 * 	 
 * @ClassDecription：jsonObject工具类	 
 * @ClassName：org.fmblzf.home.manager.common.utils.JsonUtils 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-19 下午4:51:21	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-19 下午4:51:21	 
 * @Tag： 
 * @version V1.0 
 *
 */
public class JsonUtils {

	/**
	 * 
	 * @Title: parseJSONObject 
	 * @Description: TODO 将java对象转化成json对象
	 * @param javaObject POJO，自定义对象，数组，集合，枚举类等等，返回的json对象和json数组
	 * @return 
	 *
	 */
	public static Object parseJSONObject(Object javaObject){
		Object object = JSONObject.toJSON(javaObject);
		return object;
	}
	
	
	/**
	 * 
	 * @Title: getJsonString 
	 * @Description: TODO 获取实体类的json字符串
	 * @return 
	 *
	 */
	public static String toJSONString(Object obj) {		
		return JSON.toJSONString(obj);
	}
	/**
	 * 
	 * @Title: parseObject 
	 * @Description: TODO 将json字符串 转化成 对应的实体
	 * @param jsonString
	 * @param clazz
	 * @return 
	 *
	 */
	public static <T> T parseObject(String jsonString,Class<T> clazz){
		Object obj = JSON.parseObject(jsonString, clazz);
		return clazz.cast(obj);
	}

	/**
	 * 
	 * @Title: parseArray 
	 * @Description: TODO 将json字符串 转化成对应实体的集合
	 * @param jsonString
	 * @param clazz
	 * @return 
	 *
	 */
	public <T> List<T> parseArray(String jsonString,Class<T> clazz){
		List<T> list = JSON.parseArray(jsonString, clazz);
		return list;
	}
	
}
