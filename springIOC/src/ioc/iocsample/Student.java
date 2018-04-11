package ioc.iocsample;  
/** 
 * 学生类 
 * @author lhy 
 * 
 */  
public class Student {  
  public int id;  
  public String name;  
  private School school;  
public int getId() {  
    return id;  
}  
public void setId(int id) {  
    this.id = id;  
}  
public String getName() {  
    return name;  
}  
public void setName(String name) {  
    this.name = name;  
}  
public School getSchool() {  
    return school;  
}  
public void setSchool(School school) {  
    this.school = school;  
}    
}  