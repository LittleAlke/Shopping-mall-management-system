package �̳�����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class ע���û�  {
	
	public  ע���û�() {
	                                   System.out.println("׼����ʼ");
	     Connection con;  //
	 	Statement stmt;   //mysql���ݿ�
	 	ResultSet rs;
	 	try {
	 		Class.forName("com.mysql.jdbc.Driver");
	 	} catch (ClassNotFoundException f) {
	 		System.out.println("SQLException:"+f.getLocalizedMessage());
	 	}try {
	 		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin"); 		
	 		System.out.println("���ݿ����ӳɹ�"); 		
			stmt=con.createStatement();
			String sqlstr=" delete from consumer where �˺�='"+��¼.ID+"'";			
			stmt.executeUpdate(sqlstr);	
			System.out.println("ɾ���ɹ�");
			stmt.close();
			con.close(); 
			                                       System.out.println("ע�����");
		} catch (Exception e) {
			// TODO: handle exception
		}
	     
	     
	}




}
