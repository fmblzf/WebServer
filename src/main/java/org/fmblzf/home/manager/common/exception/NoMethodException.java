package org.fmblzf.home.manager.common.exception;

import org.fmblzf.home.manager.common.bean.ResultEncoding;

/**
 * 
 * @Copy：2016-fmblzf
 * @ProjectName：webapp Maven Webapp
 * 
 * @ClassDecription：找不到方法异常
 * @ClassName：org.fmblzf.home.manager.common.exception.NoMethodException
 * @Creator：zhaofeng
 * @CreatTime：2016-4-21 上午10:15:30
 * @FixPerson：zhaofeng
 * @FixTime：2016-4-21 上午10:15:30
 * @Tag：
 * @version V1.0
 * 
 */
public class NoMethodException extends BaseException {

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
	public NoMethodException() {
		setStatus(ResultEncoding.ACTION_FAIL_NOMETHOD);
		setMessage(ResultEncoding.getMessageBycode(getStatus()));
	}
	/**
	 * 
	 * Title:
	 * Description:  有参构造器
	 * @param explain  
	 *
	 */
	public NoMethodException(String explain){
		setExplain(explain);	
		setStatus(ResultEncoding.ACTION_FAIL_NOMETHOD);
		setMessage(ResultEncoding.getMessageBycode(getStatus()));
	}

}
