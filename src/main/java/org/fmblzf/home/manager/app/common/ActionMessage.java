package org.fmblzf.home.manager.app.common;

import org.fmblzf.home.manager.common.bean.ResultEncoding;
import org.fmblzf.home.manager.common.exception.BaseException;

/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp Maven Webapp 
 * 	 
 * @ClassDecription：与移动客户端交互过程中的实体类	 
 * @ClassName：org.fmblzf.home.manager.common.bean.ActionMessage 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-8 下午2:23:46	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-8 下午2:23:46	 
 * @Tag： 
 * @version V1.0 
 *
 */
public class ActionMessage {
	/**
	 * 交互结果状态-默认不成功
	 * 200为成功状态
	 * 
	 */
	private int status=-1;
	/**
	 * 
	 * @Title: getStatus 
	 * @Description: TODO 获取状态值
	 * @return 
	 *
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * 
	 * @Title: setStatus 
	 * @Description: TODO  给状态赋值
	 * @param status 
	 *
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * 传输数据
	 */
	private Object data = null;
	/**
	 * 
	 * @Title: getData 
	 * @Description: TODO 获取对应的数据
	 * @return 
	 *
	 */
	public Object getData() {
		return data;
	}
	/**
	 * 
	 * @Title: setData 
	 * @Description: TODO 设置对应的数据
	 * @param data 
	 *
	 */
	public void setData(Object data) {
		this.data = data;
	}
	/**
	 * 错误信息内容
	 */
	private String errorMsg = null;
	/**
	 * 
	 * @Title: getErrorMsg 
	 * @Description: TODO 获取错误信息
	 * @return 
	 *
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
	/**
	 * 
	 * @Title: setErrorMsg 
	 * @Description: TODO 设置错误信息
	 * @param errorMsg 
	 *
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	/**
	 * 成功信息
	 */
	private String successMsg = null;
	/**
	 * 
	 * @Title: getSuccessMsg 
	 * @Description: TODO 获取成功返回信息
	 * @return 
	 *
	 */
	public String getSuccessMsg() {
		return successMsg;
	}
	/**
	 * 
	 * @Title: setSuccessMsg 
	 * @Description: TODO 设置成功信息
	 * @param successMsg 
	 *
	 */
	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
	/**
	 * 说明
	 */
	private String explain = "";
	/**
	 * 
	 * @Title: getExplain 
	 * @Description: TODO 设置说明内容
	 * @return 
	 *
	 */
	public String getExplain() {
		return explain;
	}
	/**
	 * 
	 * @Title: setExplain 
	 * @Description: TODO 获取设置内容
	 * @param explain 
	 *
	 */
	public void setExplain(String explain) {
		this.explain = explain;
	}
	/**
	 * 文件路径集合
	 */
	private String[] files = null;
	/**
	 * 
	 * @Title: getFiles 
	 * @Description: TODO 获取文件路径
	 * @return 
	 *
	 */
	public String[] getFiles() {
		return files;
	}
	/**
	 *  
	 * @Title: setFiles 
	 * @Description: TODO 设置文件路径
	 * @param files 
	 *
	 */
	public void setFiles(String[] files) {
		this.files = files;
	}
	/**
	 * 
	 * @Title: getActionMessage 
	 * @Description: TODO 根据异常信息返回对应的交互结果
	 * @param e
	 * @return 
	 *
	 */
	public static ActionMessage getActionMessage(BaseException e){
		ActionMessage action = new ActionMessage();
		if(e == null){
			action.setStatus(ResultEncoding.ACTION_SUCESS);
			action.setSuccessMsg("操作成功");			
		}else{			
			action.setStatus(e.getStatus());
			action.setErrorMsg(e.getMessage());
			action.setExplain(e.getExplain());
		}
		return action;
	}

}
