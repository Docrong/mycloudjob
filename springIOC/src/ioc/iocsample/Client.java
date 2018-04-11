package ioc.iocsample;  
  
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;  
  
public class Client {  
    public static void main(String[] args) {  
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");  
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student=(Student)factory.getBean("student");
        Student student2=(Student)context.getBean("student");

        System.out.println(student.getName()+","+student.getId());
        System.out.println(student2.getName()+","+student2.getId());

//        student.getSchool().printInfo();  
    }  
}  