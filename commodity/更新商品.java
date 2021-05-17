package 商场管理系统;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class 更新商品 extends JPanel implements ActionListener {
	private JComboBox 商品详情;   //组合框
	private JTextField 编号,名称,数量,进价,售价;
	private JLabel 请输入商品编号,选择更新的内容,输入更新的数据;
	public 更新商品() {
	                                                          	this.setOpaque(false);////////
		    JPanel p0=new JPanel(new GridLayout(10,1,20,20));
		                                                        p0.setOpaque(false);////////
			JLabel 请输入商品编号=new JLabel("请输入商品编号");
			请输入商品编号.setFont(new Font("华文行楷", Font.PLAIN, 30));
			p0.add(请输入商品编号);  
			
			 编号=new JTextField(10);
			 编号.setFont(new Font("宋体",Font.BOLD,20));
				编号.setOpaque(false);
			p0.add(编号);
			
			JLabel 请输入更新名称 =new JLabel("请输入更新名称"); 
			请输入更新名称.setFont(new Font("华文行楷", Font.PLAIN, 30));
			p0.add(请输入更新名称);                                
			
			名称=new JTextField(10);
			名称.setFont(new Font("宋体",Font.BOLD,20));
			名称.setOpaque(false);
			p0.add(名称);
			
			JLabel 请输入更新数量=new JLabel("请输入更新数量");  
			请输入更新数量.setFont(new Font("华文行楷", Font.PLAIN, 30));
			p0.add(请输入更新数量);                                
			
			 数量=new JTextField(10);
			 数量.setFont(new Font("宋体",Font.BOLD,20));
				数量.setOpaque(false);
			p0.add(数量);
			
			JLabel 请输入更新进价=new JLabel("请输入更新进价"); 
			请输入更新进价.setFont(new Font("华文行楷", Font.PLAIN, 30));
			p0.add(请输入更新进价);                                
			
			 进价=new JTextField(10);
			 进价.setFont(new Font("宋体",Font.BOLD,20));
				进价.setOpaque(false);
			p0.add(进价);
			
			JLabel 请输入更新售价=new JLabel("请输入更新售价");   
			请输入更新售价.setFont(new Font("华文行楷", Font.PLAIN, 30));
			p0.add(请输入更新售价);                                
			
			售价=new JTextField(10);
			 售价.setFont(new Font("宋体",Font.BOLD,20));
				售价.setOpaque(false);
			p0.add(售价);
		 
		   JButton 确认=new JButton("确认");
		   确认.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
			p0.add(确认);
			确认.addActionListener(this);
			
			p0.setBackground(Color.white);
			this.add(p0);
			this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="确认") {
			Connection con;          
			PreparedStatement stmt;        //创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库。
		    ResultSet rs;                  //光标位置移动
		    String str1=编号.getText();     
		    String str2=名称.getText();
		    String str3=数量.getText();
		    String str4=进价.getText();
		    String str5=售价.getText();
		    String sql = "update shangpin set 名称=? ,数量=?,进价=?,售价=?where 编号='"+str1+"'"; //str为字符加单引号，双引号内全为整个字符串
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");
		    }
		    catch(ClassNotFoundException f){
		    	System.out.println("SQLException:"+f.getLocalizedMessage());

		    }
		    try {
		    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
		    //建立连接，第一个root为MYSQL用户名，第二个admin为密码。
		    	 // 创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库。
		    	stmt = (PreparedStatement) con.prepareStatement(sql);    
		    	// 在此 PreparedStatement 对象中执行 SQL 语句
		    	stmt.setString(1, str2);	//数字代表第几列 update (表名) set  (列名1)=?,列明2=? where (列名)=？
		    	
		    	stmt.setString(2, str3);
		    	
		    	stmt.setString(3, str4);
		    	
		    	stmt.setString(4, str5);	
		    	JOptionPane.showMessageDialog(this, "更新成功！","系统提示",JOptionPane.WARNING_MESSAGE);
		    	stmt.execute();} //在此 PreparedStatement 对象中执行 SQL 语句，该语句可以是任何种类的 SQL 语句
		    
		    
		    catch (SQLException ex) {
				ex.printStackTrace();
		    	// TODO: handle exception
			}
}
	}
}
