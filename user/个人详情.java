package 商场管理系统;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.crypto.NullCipher;
import javax.swing.*;
public class 个人详情 extends JPanel  implements ActionListener{
   private JLabel 账号,密码,姓名,电话;
   private JTextField 账号内容, 密码内容,姓名内容,电话内容;
   private JPanel p1,p2,pz;
   public 个人详情() {
	   this.setLayout(new GridLayout(1,2,100,0));
	                                                this.setOpaque(false);////////
	   p1=new JPanel(new GridLayout(10,1,0,20));
	                                                p1.setOpaque(false);//////// 
	   p2=new JPanel(new GridLayout(10,1,0,20));
	                                               p2.setOpaque(false);////////
	   账号=new JLabel("账号",JLabel.CENTER);
	   账号.setFont(new java.awt.Font("华文行楷", 1, 30));
	   p1.add(账号);
	   
	   密码=new JLabel("密码",JLabel.CENTER);
	   密码 .setFont(new java.awt.Font("华文行楷", 1, 30));
	   p1.add(密码);
	   
	   姓名=new JLabel("姓名",JLabel.CENTER);
	   姓名 .setFont(new java.awt.Font("华文行楷", 1, 30));
	   p1.add(姓名);
	   
	   电话=new JLabel("电话",JLabel.CENTER);
	   电话.setFont(new java.awt.Font("华文行楷", 1, 30));
	   p1.add(电话);
	   
	   
	    Connection con;  //
		Statement stmt;   //mysql数据库
		ResultSet rs; 
		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				System.out.println("error"+ex);
			}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//String s=登录.st1;
			rs=stmt.executeQuery("select * from consumer where consumer.账号="+登录.ID);
			                                              System.out.println("已select");
	         while(rs.next()) {
			        String st1=rs.getString("账号");                                  //只能显示第一行的数据
			        String st2=rs.getString("密码");
			        String st3=rs.getString("姓名");
			        String st4=rs.getString("电话");
			      //  String st4=new 登录.用户名.getText();
			                                              System.out.println("已获取信息");
			                   
			       账号内容 =new JTextField(st1);
			       账号内容.setBackground(Color.orange);
			       账号内容.setFont(new java.awt.Font("黑体", 1, 20));
			       p2.add(账号内容);
			       
			       密码内容=new JTextField(st2);
			       密码内容.setBackground(Color.orange);
			       密码内容.setFont(new java.awt.Font("黑体", 1, 20));
			       p2.add(密码内容);
			       
			       姓名内容=new JTextField(st3);
			       姓名内容.setBackground(Color.orange);
			       姓名内容.setFont(new java.awt.Font("黑体", 1, 20));
			       p2.add(姓名内容);
			       
			       电话内容=new JTextField(st4);
			       电话内容.setBackground(Color.orange);
			       电话内容.setFont(new java.awt.Font("黑体", 1, 20));
			       p2.add(电话内容);
			      
			    rs.close();
				stmt.close();
				con.close();
				p1.setBackground(Color.GRAY);
			   this.add(p1);
			   p2.setBackground(Color.GRAY);
			   this.add(p2);
			   this.setBackground(Color.GRAY);
			  this.setVisible(true);
			   break;
			                                     }
					 
   }catch (SQLException f) {
			System.out.println(f);
		}
	}

	/*public static void main(String[] args) {
		new 个人详情();
	}*/
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

	
}
