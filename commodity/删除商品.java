package 商场管理系统;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

public class 删除商品  extends JPanel implements ActionListener{
	private JTextField 编号;
	public 删除商品() {
		                                                   this.setOpaque(false);////////
		   	JPanel p0=new JPanel(new GridLayout(3,1,0,20));
		                                                    	p0.setOpaque(false);////////
			JLabel 请输入商品编号=new JLabel("请输入商品编号");
			请输入商品编号.setFont(new Font("华文行楷", Font.PLAIN, 30));
			p0.add(请输入商品编号);                                
			
			编号=new JTextField(10);
			编号.setFont(new Font("宋体",Font.BOLD,20));
			编号.setOpaque(false);
			p0.add(编号);
			
			JButton 确认=new JButton("删除");
			确认.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
			p0.add(确认);
			确认.addActionListener(this);
			
			p0.setBackground(Color.white);
			this.add(p0);
			this.setVisible(true);
			
	}

	@Override
	public  void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="确认") {
			System.out.print("ssssssssss");
			Connection con;          
			PreparedStatement stmt;        //创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库
		    ResultSet rs;                  //光标位置移动
		    String str=编号.getText();
		    System.out.print("str");
		    String sql = "delete from shangpin where 编号='"+str+"'";
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");
		    }
		    catch(ClassNotFoundException f){
		    	System.out.println("SQLException:"+f.getLocalizedMessage());

		    }
		    try {
		    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
		    //建立连接，第一个root为MYSQL用户名，第二个admin为密码。
		    	stmt = (PreparedStatement) con.prepareStatement(sql);  //创建一个 PreparedStatement 对象来将参数化的 SQL 语句发送到数据库
		    	    stmt.executeUpdate(sql);          //删除整个数据
		    	    JOptionPane.showMessageDialog(this, "删除成功！","系统提示",JOptionPane.WARNING_MESSAGE);
	}
		    
		    catch (SQLException ex) {
				ex.printStackTrace();
		    	// TODO: handle exception
			}
             
		}
	}
}
