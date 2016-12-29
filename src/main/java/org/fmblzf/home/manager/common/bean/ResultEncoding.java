package org.fmblzf.home.manager.common.bean;

/**
 * 
 * @Copy：2016-fmblzf
 * @ProjectName：webapp Maven Webapp
 * 
 * @ClassDecription：结果编码类
 * @ClassName：org.fmblzf.home.manager.common.bean.ResultEncoding
 * @Creator：zhaofeng
 * @CreatTime：2016-4-8 下午2:20:06
 * @FixPerson：zhaofeng
 * @FixTime：2016-4-8 下午2:20:06
 * @Tag：
 * @version V1.0
 * 
 */
public class ResultEncoding {
	/**
	 * 交互成功-编码
	 */
	public static final int ACTION_SUCESS = 200;
	/**
	 * 交互失败-缺少对应的服务 编码
	 */
	public static final int ACTION_FAIL_NOSERVICE = 201;
	/**
	 * 交互失败-缺少对应的方法 编码
	 */
	public static final int ACTION_FAIL_NOMETHOD = 202;
	/**
	 * 交互失败-缺少对应的参数 编码
	 */
	public static final int ACTION_FAIL_NOARGUMENTS = 203;
	/**
	 * 交互异常 -编码
	 */
	public static final int ACTION_EXCEPTION = 204;

	/**
	 * 
	 * @Title: getMsgBycode 
	 * @Description: TODO 根据编码获取对应的描述
	 * @param code
	 * @return 
	 *
	 */
	public static String getMessageBycode(int code) {
		String message = "";
		switch (code) {
		case ACTION_SUCESS:
			message = "操作成功";
			break;
		case ACTION_FAIL_NOSERVICE:
			message = "没有找到对应的服务";
			break;
		case ACTION_FAIL_NOMETHOD:
			message = "没有找到对应的方法";
			break;
		case ACTION_FAIL_NOARGUMENTS:
			message = "缺少必要的参数";
			break;
		case ACTION_EXCEPTION:
			message = "请联系服务器端管理员";
			break;
		default:
			break;
		}
		return message;
	}
}
