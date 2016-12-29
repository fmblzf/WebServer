package test;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.fmblzf.home.manager.base.bean.User;
import org.fmblzf.home.manager.web.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
/**
 * 
 * 测试用户控制类
 * @author Administrator
 *
 */
public class UserControllerTest extends BaseSpringJunitTest  {

	private static final Logger logger = Logger
			.getLogger(UserControllerTest.class);
	
	// 模拟request,response
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	//用户控制 注入
	@Autowired
	private UserController userController;
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	

	// 执行测试方法之前初始化模拟request,response
	@Before
	public void setUp() {
		request = new MockHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
		response = new MockHttpServletResponse();
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	/**
	 * 测试注册
	 */
//	@Test
//	public void registerTest() {
//		request.setParameter("username", "ceshi");
//		request.setParameter("password", "123456");
//		String t = userController.register(request, response);
//		logger.info(JSON.toJSONStringWithDateFormat(t, "yyyy-MM-dd HH:mm:ss"));
//	}
	
	/**
	 * 测试登陆
	 */
//	@Test
//	public void loginTest() {
//		request.setParameter("username", "xiao");
//		request.setParameter("password", "123456");
//		User t = userController.login(request, response);
//		logger.info(JSON.toJSONStringWithDateFormat(t, "yyyy-MM-dd HH:mm:ss"));
//	}
	
	/**
	 * web请求url - 测试登陆
	 */
	@Test
	public void loginWebTest() {		
		MvcResult result;
        String response = "";
        String request = "";
		try {
			result = mockMvc.perform(MockMvcRequestBuilders.post("/user/login").param("username", "xiao").param("password", "123456"))
			        .andDo(MockMvcResultHandlers.print())
			        .andReturn();
			response = result.getResponse().getContentAsString();
			request = ((User)result.getRequest().getAttribute("user")).toString();
			logger.info(JSON.toJSONStringWithDateFormat(response, "yyyy-MM-dd HH:mm:ss"));
			logger.info(JSON.toJSONStringWithDateFormat(request, "yyyy-MM-dd HH:mm:ss"));
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * web请求url - 测试注册
	 */
	@Test
	public void registerWebTest() {		
		MvcResult result;
        String response = "";
		try {
			result = mockMvc.perform(MockMvcRequestBuilders.post("/user/register").param("username", "web-test").param("password", "123456"))
			        .andDo(MockMvcResultHandlers.print())
			        .andReturn();
			response = result.getResponse().getContentAsString();
			logger.info(JSON.toJSONStringWithDateFormat(response, "yyyy-MM-dd HH:mm:ss"));
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * org.junit.Assert.assertEquals
	 * 功能是比较两个参数是否相等，如果相等就说明测试成功；
	 * 否则就测试不成功；
	 * 
	 */

}
