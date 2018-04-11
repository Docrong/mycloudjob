package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.AppMessage;
import com.example.demo.listener.IndexListener;
import com.example.demo.service.AppMessageService;


@Controller
@RequestMapping("/appmessage")
public class APPMessageController extends HttpServlet{

    @Autowired
    private AppMessageService service;

    @RequestMapping("/getThree")
    public List<AppMessage> getThreeForMessage(HttpServletRequest request,HttpServletResponse response){
        
       // List<AppMessage> list = service.getMessage();        
    	List list=new ArrayList();
    	
        return list;
    }
    
    @RequestMapping("/getAll")
    public List<AppMessage> getAllMessage(){
        
        List<AppMessage> list = service.getAllMessage();
        int num = list.size();
        if(null!=list && num>3){
            for (int i = 0; i < num-3; i++) {
                list.remove(0);
            }
        }
        return list;
    }

    @RequestMapping("/getByID")
    public List<AppMessage> getMessageById(@RequestParam("id") String id){
        List<AppMessage> list = service.getMessageById(id);
        int num = list.size();
        if(null!=list && num>5){
            for (int i = 0; i < num-5; i++) {
                list.remove(0);
            }
        }
        return list;
    }
    
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public int addMessage(@RequestBody AppMessage appMessage){
        return service.addMessage(appMessage);
    }
    
    @RequestMapping(value="/delMessageById",method=RequestMethod.POST)
    public int delMessageById(@RequestParam("id") String id){
            return service.delMessage(id);
    }
}