package org.fmblzf.home.manager.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.fmblzf.home.manager.base.bean.User;
import org.fmblzf.home.manager.base.service.IUserService;
import org.fmblzf.home.manager.common.controller.BaseController;
import org.fmblzf.home.manager.common.utils.JsonUtils;
import org.fmblzf.home.manager.common.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp Maven Webapp 
 * 	 
 * @ClassDecription：用户管理  - 控制器 
 * @ClassName：org.fmblzf.home.manager.base.controller.UserController 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-8 下午12:08:54	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-8 下午12:08:54	 
 * @Tag： 
 * @version V1.0 
 *
 */
@Controller
public class UserController extends BaseController {
	
	/**
	 * 用户服务类 注入
	 */
	@Autowired
	private IUserService userService = null;

	/**
	 * 
	 * @Title: login 
	 * @Description: TODO 用户登录
	 * @param request 方法请求 参数
	 * @param response 方法返回参数
	 * @return 
	 *
	 */
	@RequestMapping(value = "/user_login.do")
	public ModelAndView login(HttpServletRequest request,ModelMap model) {
		System.out.println("测试");
		User requestUser = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		requestUser.setUsername(username);
		requestUser.setPassword(password);
		User temp = userService.login(requestUser);
		if(temp == null){			
			return  new ModelAndView("redirect:/common_error.do");
		}
		LogUtils.log(UserController.class, LogUtils.LogLevel.INFO, requestUser, null);
		model.addAttribute("user", JsonUtils.toJSONString(temp));
		model.addAttribute("type", "user");
		return  new ModelAndView("redirect:/common_sucess.do");
	}
	
	/**
	 * 
	 * @Title: register 
	 * @Description: TODO 用户注册
	 * @param request
	 * @param response
	 * @return 
	 *
	 */
	@RequestMapping(value = "/user_register.do")
	public ModelAndView register(HttpServletRequest request,  Model attr) {
		User requestUser = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		requestUser.setUsername(username);
		requestUser.setPassword(password);
		requestUser.setNickname("测试");
		requestUser.setTel("15330099583");
		requestUser.setRegip("regin");
		requestUser.setRegtime((int)(new Date()).getTime()/1000);
		requestUser.setLastloginip("127.0.0.0");
		requestUser.setLastlogintime("2015-04-07");
		requestUser.setUsertype(Byte.valueOf("1"));
		requestUser.setIslock(Byte.valueOf("1"));
		requestUser.setEmail("123@sd.com");
		requestUser.setAuth("auth");
		requestUser.setUpdatetime((int)(new Date()).getTime()/1000);
		LogUtils.log(getClass(), LogUtils.LogLevel.INFO, requestUser, null);
		int count = userService.register(requestUser);
		if(count>0){
			attr.addAttribute("user", requestUser);
			attr.addAttribute("type", "user");
		}else{			
			attr.addAttribute("user", requestUser);
			attr.addAttribute("type", "user");
		}
		return new ModelAndView("redirect:/common_sucess.do");
	}

}
