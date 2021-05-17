package 商场管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class 注销用户  {
	
	public  注销用户() {
	                                   System.out.println("准备开始");
	     Connection con;  //
	 	Statement stmt;   //mysql数据库
	 	ResultSet rs;
	 	try {
	 		Class.forName("com.mysql.jdbc.Driver");
	 	} catch (ClassNotFoundException f) {
	 		System.out.println("SQLException:"+f.getLocalizedMessage());
	 	}try {
	 		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin"); 		
	 		System.out.println("数据库连接成功"); 		
			stmt=con.createStatement();
			String sqlstr=" delete from consumer where 账号='"+登录.ID+"'";			
			stmt.executeUpdate(sqlstr);	
			System.out.println("删除成功");
			stmt.close();
			con.close(); 
			                                       System.out.println("注销完成");
		} catch (Exception e) {
			// TODO: handle exception
		}
	     
	     
	}




}
