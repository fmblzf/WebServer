package org.fmblzf.home.manager.web.common;

import javax.servlet.http.HttpServletRequest;

import org.fmblzf.home.manager.base.bean.User;
import org.fmblzf.home.manager.common.controller.BaseController;
import org.fmblzf.home.manager.common.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp-Maven-Webapp 
 * 	 
 * @ClassDecription：web端公共的操作的控制器	 
 * @ClassName：org.fmblzf.home.manager.web.common.CommonController 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-16 下午8:14:36	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-16 下午8:14:36	 
 * @Tag： 
 * @version V1.0 
 *
 */
@Controller
public class CommonController extends BaseController {
	/**
	 * 
	 * @Title: sucess 
	 * @Description: TODO 成功界面
	 * @param request
	 * @param model
	 * @return 
	 *
	 */
	@RequestMapping(value="/common_sucess.do")
	public String sucess(HttpServletRequest request,ModelMap model){
		String type = request.getParameter("type");
		String userStr = request.getParameter("user");
		User user = JsonUtils.parseObject(userStr, User.class);
		System.out.println("request['type'] = "+type);
		model.addAttribute("type", "user");
		model.addAttribute("user_str", userStr);
		model.addAttribute("user", user);
		return "common/sucess";
	}
	/**
	 * 
	 * @Title: error 
	 * @Description: TODO 失败界面
	 * @param request
	 * @param model
	 * @return 
	 *
	 */
	@RequestMapping(value="/common_error.do")
	public String error(HttpServletRequest request,Model model){
		return "common/error";
	}
	
}
