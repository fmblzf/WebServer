package org.fmblzf.home.manager.common.exception;

import org.fmblzf.home.manager.common.bean.ResultEncoding;
/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp Maven Webapp 
 * 	 
 * @ClassDecription：未找到服务异常	 
 * @ClassName：org.fmblzf.home.manager.common.exception.NoServiceException 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-21 上午10:17:50	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-21 上午10:17:50	 
 * @Tag： 
 * @version V1.0 
 *
 */
public class NoServiceException extends BaseException {
	/**
	 * @Fields serialVersionUID : TODO
	 * 
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * Title: Description: 构造器
	 * 
	 */
	public NoServiceException() {
		setStatus(ResultEncoding.ACTION_FAIL_NOSERVICE);
		setMessage(ResultEncoding.getMessageBycode(getStatus()));
	}
	/**
	 * 
	 * Title:
	 * Description:  有参构造器
	 * @param explain  
	 *
	 */
	public NoServiceException(String explain){
		setExplain(explain);
		setStatus(ResultEncoding.ACTION_FAIL_NOSERVICE);
		setMessage(ResultEncoding.getMessageBycode(getStatus()));
	}
}
