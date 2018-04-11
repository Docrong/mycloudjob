package ioc.iocsample;  
/** 
 * 学校类 
 * @author lhy 
 * 
 */  
public class School {  
   private String name;  
   public School(String name)  
   {  
       this.name=name;  
   }  
   public void printInfo()  
   {  
       System.out.println("该学校的名称是："+name);  
   }  
}  