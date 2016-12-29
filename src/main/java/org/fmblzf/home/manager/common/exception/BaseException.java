package org.fmblzf.home.manager.common.exception;

/**
 * 
 * @Copy：2016-fmblzf
 * @ProjectName：webapp-Maven-Webapp
 * 
 * @ClassDecription：异常基础类
 * @ClassName：org.fmblzf.home.manager.common.exception.BaseException
 * @Creator：zhaofeng
 * @CreatTime：2016-4-16 下午7:06:36
 * @FixPerson：zhaofeng
 * @FixTime：2016-4-16 下午7:06:36
 * @Tag：
 * @version V1.0
 * 
 */
public class BaseException extends Exception {

	/**
	 * @Fields serialVersionUID : TODO
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 异常状态码
	 */
	private int status = -1;
	/**
	 * 
	 * @Title: getStatus 
	 * @Description: TODO 获取状态码
	 * @return 
	 *
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * 
	 * @Title: setStatus 
	 * @Description: TODO 设置状态码
	 * @param status 
	 *
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * 异常信息
	 */
	private String message = "";
	/**
	 * 
	 * 获取异常信息
	 * @see java.lang.Throwable#getMessage() 
	 *
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 
	 * @Title: setMessage 
	 * @Description: TODO 设置异常信息
	 * @param message 
	 *
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 异常说明
	 */
	private String explain = "";
	/**
	 * 
	 * @Title: getExplain 
	 * @Description: TODO 获取异常说明
	 * @return 
	 *
	 */
	public String getExplain() {
		return explain;
	}
	/**
	 * 
	 * @Title: setExplain 
	 * @Description: TODO 设置异常说明
	 * @param explain 
	 *
	 */
	public void setExplain(String explain) {
		this.explain = explain;
	}

}
