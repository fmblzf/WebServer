package test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.fmblzf.home.manager.base.bean.User;
import org.fmblzf.home.manager.base.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
/**
 * 
 * 用户服务类单元测试
 * @author Administrator
 *
 */
public class UserServiceTest extends BaseSpringJunitTest {

	private static final Logger logger = Logger.getLogger(UserServiceTest.class);
	
	@Autowired
	private IUserService service;
	
	@Test
	public void register(){		
		User u = new User();
		u.setUsername("ceshi");
		u.setPassword("123456");
		u.setNickname("测试");
		u.setTel("15330099583");
		u.setRegip("regin");
		u.setRegtime((int)(new Date()).getTime()/1000);
		u.setLastloginip("127.0.0.0");
		u.setLastlogintime("2015-04-07");
		u.setUsertype(Byte.valueOf("1"));
		u.setIslock(Byte.valueOf("1"));
		u.setEmail("123@sd.com");
		u.setAuth("auth");
		u.setUpdatetime((int)(new Date()).getTime()/1000);
		int count = service.register(u);	
		logger.info(JSON.toJSONStringWithDateFormat(count, "yyyy-MM-dd HH:mm:ss"));
	} 
	@Test
	public void login(){		
		User u = new User();
		u.setUsername("ceshi");
		u.setPassword("123456");
		User user = service.login(u);
		logger.info(JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd HH:mm:ss"));
	}
}
