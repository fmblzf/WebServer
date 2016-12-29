package org.fmblzf.home.manager.common.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp Maven Webapp 
 * 	 
 * @ClassDecription：系统工具	 
 * @ClassName：org.fmblzf.home.manager.common.utils.SystemUtils 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-20 下午3:58:03	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-20 下午3:58:03	 
 * @Tag： 
 * @version V1.0 
 *
 */
public class SystemUtils {

	/**
	 * 
	 * @Title: getServerPositivePath 
	 * @Description: TODO 获取服务器的网路路径
	 * @param request
	 * @return 
	 *
	 */
	public static String getServerPositivePath(HttpServletRequest request){
		String protocol = request.getProtocol();
		String ip = request.getLocalAddr();
		int port = request.getServerPort();
		if("HTTP/1.1".equals(protocol)){
			protocol = "http://";
		}
		return protocol+ip+":"+port;
	}
	
}
