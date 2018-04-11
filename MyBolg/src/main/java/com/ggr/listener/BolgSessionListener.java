package com.ggr.listener;

import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 监听session
 * @author gr
 *
 */
@WebListener
public class BolgSessionListener implements HttpSessionListener{

    private final String COUNT_KEY = "sessions";  

	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("session 初始化");
        HttpSession session = event.getSession();  
        ServletContext application = session.getServletContext();  
  
        // 在application范围由一个HashSet集保存所有的session   
        HashSet sessions = (HashSet) application.getAttribute(COUNT_KEY);  
        if (sessions == null) {  
            sessions = new HashSet();  
            application.setAttribute(COUNT_KEY, sessions);  
        }  
  
        // 新创建的session均添加到HashSet集中   
        sessions.add(session);  
  
        // 然后使用sessions.size()获取当前活动的session数，即为“在线人数”   
        System.err.println("sessionCreated 网站在线人数（含未登录的访问） 为：" + sessions.size());  

		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("session 销毁");
		 HttpSession session = event.getSession();  
	        ServletContext application = session.getServletContext();  
	        HashSet sessions = (HashSet) application.getAttribute(COUNT_KEY);
	        if(sessions!=null&&sessions.contains(session)){
	        	sessions.remove(session);
	        }
	        System.out.println(sessions.size());
	        
	}

}
