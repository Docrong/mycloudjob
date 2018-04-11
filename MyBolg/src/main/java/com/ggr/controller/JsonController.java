package com.ggr.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ggr.temp.Person;
import com.ggr.util.UtilTools;

import ch.qos.logback.core.util.FileUtil;

@RestController 
@RequestMapping("") 
public class JsonController { 
    @RequestMapping("getPerson") 
    public Map<String,Object> getPerson(HttpServletRequest request,HttpServletResponse response){ 
        Map<String,Object> param = new HashMap<String, Object>(); 
        Person person=new Person("张三","25","13812345678","湖北省武汉市江夏区藏龙岛");
        String s = person.getPhones().toString(); 
        System.out.println(s); 
        param.put("person",person); 
        
        /**
         * 清空session
         */
           
        return param; 
    } 
    
    @RequestMapping("/upload")
	public Map upload(HttpServletRequest request,@RequestParam(value="myFileName")MultipartFile file) throws IllegalStateException, IOException {
    	System.out.println("进入");
		String pathRoot = request.getSession().getServletContext().getRealPath("upload"); 
		String fileName = file.getOriginalFilename();//获取图片名称
		String path = pathRoot+"\\"+fileName;
		System.out.println(path);
		  File dest = new File(path);
  	    // 检测是否存在目录
  	    if (!dest.getParentFile().exists()) {
  	        dest.getParentFile().mkdirs();// 新建文件夹
  	    }
  	    file.transferTo(dest);// 文件写入
  	    
		String path2="D:\\aim\\upload"+"\\"+fileName;
		UtilTools.copyFile(path, path2);
    	Map map=new HashMap();
    	map.put("errno", 0);
    	path="http://localhost:8069/upload/"+fileName+"";
    	List list=new ArrayList();
    	list.add(path);
    	map.put("data", list);
    	
    	
    	System.out.println("map-->"+map);
    	
    	
    	
    	return map;
    	
	}
    
    @RequestMapping("/testuploadimg")
    public String testuploadimg(@RequestParam("file") MultipartFile file){
    	try {
    	    if (file.isEmpty()) {
    	        return "文件为空";
    	    }
    	    // 获取文件名
    	    String fileName = file.getOriginalFilename();
    	    System.out.println("上传的文件名为：" + fileName);
    	    // 获取文件的后缀名
    	    String suffixName = fileName.substring(fileName.lastIndexOf("."));
    	    System.out.println("文件的后缀名为：" + suffixName);
    	    
    	    // 设置文件存储路径
    	    String filePath = "D://aim//";
    	    String path = filePath + fileName + suffixName;

    	    File dest = new File(path);
    	    // 检测是否存在目录
    	    if (!dest.getParentFile().exists()) {
    	        dest.getParentFile().mkdirs();// 新建文件夹
    	    }
    	    file.transferTo(dest);// 文件写入
    	    return "hello2";
    	    } catch (IllegalStateException e) {
    	        e.printStackTrace();
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	    }
    	    return "上传失败";
    	}
    
  //文件下载相关代码
    @RequestMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "aim_test.txt";// 设置文件名，根据业务需要替换成要下载的文件名
        if (fileName != null) {
            //设置文件路径
            String realPath = "D://aim//";
            File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
    
    @RequestMapping("/clickAjax")
    public Map clickAjax(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	Map map=new HashMap();
    	String name=request.getParameter("name");
    	String age=request.getParameter("age");
    	System.out.println("name:"+name+",age:"+age);
    	List l=new ArrayList();
    	l.add("测试");
    	map.put("姓名", "张三");
    	map.put("年龄", "22");
    	map.put("性别", "男");
    	map.put("data", l);
    	System.out.println("map:"+map);
    	
  	    request.getSession().invalidate();

    	
		return map;
	}
    
      @RequestMapping("/count") 
      @ResponseBody 
      public String count(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){ 
    	  try{ //把sessionId记录在浏览器 
    	      Cookie c = new Cookie("JSESSIONID", URLEncoder.encode(httpServletRequest.getSession().getId(), "utf-8")); 
    	      c.setPath("/"); 
    	      //先设置cookie有效期为2天，不用担心，session不会保存2天 
    	      c.setMaxAge( 48*60 * 60); 
    	      httpServletResponse.addCookie(c); 
    	    }catch (Exception e){ 
    	      e.printStackTrace(); 
    	    } 
    	    HttpSession session = httpServletRequest.getSession(); 
    	    Object count=session.getServletContext().getAttribute("count"); 
    	    return "count : "+count; 
    	  } 
    
} 
