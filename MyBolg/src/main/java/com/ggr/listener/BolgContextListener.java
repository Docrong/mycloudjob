package com.ggr.listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import com.ggr.util.UtilTools;

/*
 * 注册监听器
 * 监听文件
 */
@WebListener
public class BolgContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String path1=sce.getServletContext().getRealPath("upload");
		String path2="D:\\aim\\upload";
		File path1File=new File(path1);
		File path2File=new File(path2);
		if(path2File.exists()){
			System.out.println("复制文件数量:"+path2File.list().length);;
			UtilTools.copyFolder(path2, path1);
		}else{
			path2File.mkdirs();
		}
		System.out.println("path1:"+path1);
		System.out.println("path2:"+path2);
		System.out.println("Context监听器注册");		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Context监听器销毁");
	}

}
