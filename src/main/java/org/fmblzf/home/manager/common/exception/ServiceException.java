package org.fmblzf.home.manager.common.exception;

import org.fmblzf.home.manager.common.bean.ResultEncoding;

/**
 * 
 * @Copy：2016-fmblzf
 * @ProjectName：webapp Maven Webapp
 * 
 * @ClassDecription：服务器端异常
 * @ClassName：org.fmblzf.home.manager.common.exception.ServerException
 * @Creator：zhaofeng
 * @CreatTime：2016-4-20 下午6:08:28
 * @FixPerson：zhaofeng
 * @FixTime：2016-4-20 下午6:08:28
 * @Tag：
 * @version V1.0
 * 
 */
public class ServiceException extends BaseException {

	/**
	 * @Fields serialVersionUID : TODO
	 * 
	 */

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * Title:
	 * Description:  构造器
	 *
	 */
	public ServiceException() {
		setStatus(ResultEncoding.ACTION_EXCEPTION);
		setMessage(ResultEncoding.getMessageBycode(getStatus()));
	}
	/**
	 * 
	 * Title:
	 * Description:  有参构造器
	 * @param explain  
	 *
	 */
	public ServiceException(String explain){
		setExplain(explain);	
		setStatus(ResultEncoding.ACTION_FAIL_NOSERVICE);
		setMessage(ResultEncoding.getMessageBycode(getStatus()));
	}

}
