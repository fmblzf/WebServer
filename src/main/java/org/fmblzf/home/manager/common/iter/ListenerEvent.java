package org.fmblzf.home.manager.common.iter;
/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp Maven Webapp 
 * 	 
 * @ClassDecription：接口类		 
 * @ClassName：org.fmblzf.home.manager.common.iter.ListenerEvent 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-8 下午12:10:33	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-8 下午12:10:33	 
 * @Tag： 
 * @version V1.0 
 *
 */
public interface ListenerEvent {
	
	/**
	 * 
	 * @Title: action 
	 * @Description: TODO 接口方法
	 * @param action
	 * @param objects
	 * @return
	 */
	public Object action(int action,Object... objects);
	/**
	 * 文件上传标志
	 */
	public static final int FILE_UPLOAD = 1000;
	
}
