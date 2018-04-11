package control;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.StudentMapper;
import entity.Student;

//根据配置文件生成sqlsessionfactory
/**
* Created by zekai on 2017/6/10.
*/
public class Main {
  public static void main(String[] args) throws Exception {
      //io加载配置文件
      InputStream in=Main.class.getResourceAsStream("../resource/mybatis-cfg.xml");
      //用构建器构建一个inputstream
      SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);

      SqlSession session=factory.openSession();
     //取得mapper对象 调用mapper方法
      StudentMapper mapper=session.getMapper(StudentMapper.class);
      Student student=new Student();
      student.setId(20);
      student.setAge(28);
      student.setName("alowang");
      student.settId(2);
   //   mapper.insertStudent(student);
     // student=mapper.selectOneById(2);
      List<Student> studentList=mapper.selectAllStudent();
      System.out.println("列表->"+studentList);
      //记得提交 不提交等于啥都没干
      session.commit();
      //关闭资源
      session.close();
      System.out.println(factory);
      }
  }
