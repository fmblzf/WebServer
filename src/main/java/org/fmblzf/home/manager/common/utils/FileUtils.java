package org.fmblzf.home.manager.common.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件操作类
 * 
 * @Copy：2016-fmblzf
 * @ProjectName：webapp Maven Webapp
 * 
 * @ClassDecription：
 * @ClassName：org.fmblzf.home.manager.common.utils.FileUtils
 * @Creator：zhaofeng
 * @CreatTime：2016-7-26 下午3:53:17
 * @FixPerson：zhaofeng
 * @FixTime：2016-7-26 下午3:53:17
 * @Tag：
 * @version V1.0
 * 
 */
public class FileUtils {
	/**
	 * 读取文件
	 * 
	 * @Title: readFile
	 * @Description: TODO
	 * @param path
	 * @return
	 * 
	 */
	public static String readFile(String path) {

		return "";
	}

	/**
	 * 写入文件
	 * 
	 * @Title: writeFile
	 * @Description: TODO
	 * @param data
	 * @param filePath
	 * @param isappend
	 * 
	 */
	public static void writeFile(String data, String filePath, boolean isappend) {
		BufferedWriter out = null;
		File file = new File(filePath);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String now = df.format(new Date());// new Date()为获取当前系统时间
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file, isappend)));
			out.write(now+"----"+data+"\r\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
