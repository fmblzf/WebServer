package org.fmblzf.home.manager.app;

import javax.servlet.http.HttpServletRequest;

import org.fmblzf.home.manager.app.common.ActionMessage;
import org.fmblzf.home.manager.app.common.DispatcherService;
import org.fmblzf.home.manager.common.controller.BaseController;
import org.fmblzf.home.manager.common.utils.FileUploadUtils;
import org.fmblzf.home.manager.common.utils.LogUtils;
import org.fmblzf.home.manager.common.utils.SystemUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp Maven Webapp 
 * 	 
 * @ClassDecription：移动端接口控制器入口类
 * @ClassName：org.fmblzf.home.manager.app.AppController 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-8 下午12:11:01	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-8 下午12:11:01	 
 * @Tag： 
 * @version V1.0 
 *
 */
@Controller
public class AppController extends BaseController {

	/**
	 * 
	 * @Title: action 
	 * @Description: TODO 移动端接口入口方法 - 纯数据操作，不包含文件上传
	 * @param actionMessage 数据字符串化，传输过来
	 * @return 
	 *
	 */
	@RequestMapping(value = "/data.do")
	public @ResponseBody ActionMessage action(@RequestParam("data")String data){
		LogUtils.log(this.getClass(), LogUtils.LogLevel.INFO, data, null);
		JSONObject jsonObject = JSONObject.parseObject(data);
		ActionMessage message = DispatcherService.dispatcher(jsonObject);
		return message;
	}
	/**
	 * 
	 * @Title: action 
	 * @Description: TODO 测试服务器连接
	 * @return 
	 *
	 */
	@RequestMapping(value = "/test.do")
	public @ResponseBody String test(@RequestParam("data")String data){
		LogUtils.log(this.getClass(), LogUtils.LogLevel.INFO, data, null);
		JSONObject jsonObject = JSONObject.parseObject(data);
		
		return "Sucess!";
	}
	 
	/**
	 * 
	 * @Title: action 
	 * @Description: TODO 移动端接口入口方法 - 除了数据外，带有文件上传
	 * @param actionMessage 数据字符串化，传输过来
	 * @param request 文件输出请求流
	 * @return 
	 *
	 */
	@RequestMapping(value = "/multipart.do",method=RequestMethod.POST,headers="Content-Type=multipart/form-data")
	public @ResponseBody ActionMessage action(@RequestParam("data")String data,HttpServletRequest request){
		String[] savePaths = FileUploadUtils.upload(request, "files", null);		
		//图片上传成功之后再进行数据操作，可以保持同步
		LogUtils.log(this.getClass(), LogUtils.LogLevel.INFO, data, null);
		JSONObject jsonObject = JSONObject.parseObject(data);
		jsonObject.put("savePaths", savePaths);
		ActionMessage message = DispatcherService.dispatcher(jsonObject);
		String fileSavePath = SystemUtils.getServerPositivePath(request);
		for(int i = 0 ; i < savePaths.length ; i++){
			savePaths[i] = fileSavePath+savePaths[i];
		}
		message.setFiles(savePaths);
		return message;
	}
	/**
	 * 
	 * @Title: action 
	 * @Description: TODO 实现多文件上传
	 * @param files
	 * @param request
	 * @return 
	 *
	 */
	@RequestMapping(value = "/upload.do",method = RequestMethod.POST,headers="Content-Type=multipart/form-data")
	public @ResponseBody ActionMessage action(@RequestParam("files")MultipartFile[] files,HttpServletRequest request){
		String[] savePaths = FileUploadUtils.upload(files,request, null);		
		String fileSavePath = SystemUtils.getServerPositivePath(request);
		for(int i = 0 ; i < savePaths.length ; i++){
			savePaths[i] = fileSavePath+savePaths[i];
		}
		ActionMessage message = ActionMessage.getActionMessage(null);
		message.setFiles(savePaths);
		return message;
	}
	
	
}
