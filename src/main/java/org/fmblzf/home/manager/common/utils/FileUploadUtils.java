package org.fmblzf.home.manager.common.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.fmblzf.home.manager.common.iter.ListenerEvent;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 
 * @Copy：2016-fmblzf 
 * @ProjectName：webapp Maven Webapp 
 * 	 
 * @ClassDecription：文件上传工具类	 
 * @ClassName：org.fmblzf.home.manager.common.utils.FileUploadUtils 	 
 * @Creator：zhaofeng	 
 * @CreatTime：2016-4-8 下午5:58:21	 
 * @FixPerson：zhaofeng  
 * @FixTime：2016-4-8 下午5:58:21	 
 * @Tag： 
 * @version V1.0 
 *
 */
public class FileUploadUtils {
	/**
	 * 文件保存的文件夹的名称
	 */
	private static final String root = "upload";
	/**
	 * 
	 * @Title: upload 
	 * @Description: TODO 文件上传方法
	 * @param request 客户端发出的请求参数
	 * @param muKey MultipartFile对应的request中的key
	 * @param listener 监听回调函数，监听图片是否上传成功，或者也可以实现，图片上传完成之后的后续操作
	 * @return 回传图片上传后的服务器地址
	 *
	 */
	public static String[] upload(HttpServletRequest request,String muKey,ListenerEvent listener){
		MultipartHttpServletRequest muHttpServletRequest = (MultipartHttpServletRequest)request;
		//muKey是上传文件客户端的key值
		List<MultipartFile> files = muHttpServletRequest.getFiles(muKey);
		List<String> savePaths = new ArrayList<String>();
		if(files == null || files.size() == 0)
			return  null;
		for(int i = 0 ; i < files.size() ; i++){
			MultipartFile file = files.get(i);
			String savePath = saveFile(request,file);
			if(savePath != null)
				savePaths.add(savePath);
		}
		String[] savePathArr = new String[savePaths.size()];
		savePaths.toArray(savePathArr);
		return savePathArr;
	}
	/**
	 * 
	 * @Title: upload 
	 * @Description: TODO 多文件上传
	 * @param files
	 * @param request
	 * @param listener
	 * @return 
	 *
	 */
	public static String[] upload(MultipartFile[] files,HttpServletRequest request,ListenerEvent listener){
		if(files == null || files.length == 0)
			return  null;
		List<String> savePaths = new ArrayList<String>();
		for(int i = 0 ; i < files.length ; i++){
			MultipartFile file = files[i];
			String savePath = saveFile(request,file);
			if(savePath != null)
				savePaths.add(savePath);
		}
		String[] savePathArr = new String[savePaths.size()];
		savePaths.toArray(savePathArr);
		return savePathArr;
	}
	/**
	 * 
	 * @Title: saveFile 
	 * @Description: TODO 保存文件
	 * @param request
	 * @param file
	 * @return 
	 *
	 */
	public static String saveFile(HttpServletRequest request,MultipartFile file){
		if(file == null)
			return  null;
		String path = request.getSession().getServletContext().getRealPath(root);
		LogUtils.log(FileUploadUtils.class, LogUtils.LogLevel.INFO, path, null) ;
        String fileName = file.getOriginalFilename();  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }    
        //保存 文件
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            LogUtils.log(FileUploadUtils.class, LogUtils.LogLevel.ERROR, file, e) ;
            return null;
        }  
        String filePath = request.getContextPath()+"/"+root+"/"+fileName;
		return filePath;
	}
	
}
