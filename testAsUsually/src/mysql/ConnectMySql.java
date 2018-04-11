package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConnectMySql {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		ResultSet rs=null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/password";
		String user="test";
		String password="test";
		try{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd h:m:s");
			Scanner sc=new Scanner(System.in);
			System.out.println("--请输入数字--1:查看所有密码  2:修改密码 3:新增密码");
			String index=sc.nextLine();
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			if(conn!=null){
				Statement state=conn.createStatement();
				String sql="";
				 if(index.equals("1")){
					 sql="select * from password where deleted='0'";
					 rs=state.executeQuery(sql);
					 while(rs.next()){
						 System.out.printf("网站:"+rs.getString("web")+" 账号:"+rs.getString("user")+"  密码:"+rs.getString("password")+"\n");
					 }
					 rs.close();
				 }else
				 if(index.equals("2")){
					 String webuser="";
					 System.out.println("请输入网站网址:");
					 String web=sc.nextLine();
					 System.out.println("请输入修改密码:");
					 String webPassword=sc.nextLine();
					 String date=sdf.format(new Date());
					 rs= state.executeQuery("select user from password where deleted='0'");
					 while(rs.next()){
						 webuser=rs.getString("user");
					 }
					 sql="update password p set p.deleted='1' where p.web='"+web+"'";
					 state.execute(sql);
					 sql="insert into password (web,deleted,user,password,createTime) values('"+web+"','0','"+webuser+"','"+webPassword+"','"+date+"')";
					 state.execute(sql);
				 }else
				 if(index.equals("3")){
					 System.out.println("请输入网站网址:");
					 String web=sc.nextLine();
					 System.out.println("请输入账号:");
					 String webuser=sc.nextLine();
					 System.out.println("请输入初始密码:");
					 String webPassword=sc.nextLine();
					 String date=sdf.format(new Date());
					 sql="insert into password (web,deleted,user,password,createTime) values('"+web+"','0','"+webuser+"','"+webPassword+"','"+date+"')";
					 state.execute(sql);
					 state.close();
				 }else
				 if(index.equals("4")){
					 
				 }
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			conn.close();
			
		}
		System.out.println("--查询结束");
	}
}
