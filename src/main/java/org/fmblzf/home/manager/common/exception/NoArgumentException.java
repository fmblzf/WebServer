package org.fmblzf.home.manager.common.exception;

import org.fmblzf.home.manager.common.bean.ResultEncoding;
/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp Maven Webapp 
 * 	 
 * @ClassDecription：未找到对应的参数异常	 
 * @ClassName：org.fmblzf.home.manager.common.exception.NoArgumentException 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-21 上午10:20:10	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-21 上午10:20:10	 
 * @Tag： 
 * @version V1.0 
 *
 */
public class NoArgumentException extends BaseException {
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
	public NoArgumentException() {
		setStatus(ResultEncoding.ACTION_FAIL_NOARGUMENTS);
		setMessage(ResultEncoding.getMessageBycode(getStatus()));
	}
	/**
	 * 
	 * Title:
	 * Description:  有参构造器
	 * @param explain  
	 *
	 */
	public NoArgumentException(String explain){
		setExplain(explain);	
		setStatus(ResultEncoding.ACTION_FAIL_NOSERVICE);
		setMessage(ResultEncoding.getMessageBycode(getStatus()));
	}
}
