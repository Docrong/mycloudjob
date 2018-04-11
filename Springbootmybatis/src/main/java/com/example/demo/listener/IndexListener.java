package com.example.demo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener//监听器在服务启动时初始化
public class IndexListener implements ServletContextListener{

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
	System.out.println(sce.getServletContext().getAttribute("admin"));
    System.out.println("IndexListener 销毁");
  }
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("IndexListener 初始化");
    ServletContext sct=sce.getServletContext();
    sct.setAttribute("user", "admin");
    System.out.println("存入的账户名是"+sct.getAttribute("user"));
    System.out.println(sct.getServletContextName());
  }
  
}