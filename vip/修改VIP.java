package 商场管理系统;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
public class 修改VIP extends JPanel implements ActionListener{
	private JButton 下一步,重新填写;
	private JLabel 账号,住址,电话,折扣;
	//private JComboBox bm,zw;
	private JTextField zh,zz,dh,zk;
	//private JRadioButton 男,女;
	private JPanel p1,p2,p3;
public 修改VIP() {
	this.setLayout(new GridLayout(1,2,150,0));
	                                                         this.setOpaque(false);////////
	p1=new JPanel(new GridLayout(10,1,0,15));
                                                            	p1.setOpaque(false);////////
	p2=new JPanel(new GridLayout(10,1,0,15));
                                                          	p2.setOpaque(false);////////
	this.add(p1);
	this.add(p2);
	
	账号=new JLabel("账号",JLabel.CENTER);
	 账号.setFont(new Font("华文行楷", Font.PLAIN, 30));
	 p1.add(账号);
	  zh=new JTextField(10);
	  zh.setFont(new Font("宋体",Font.BOLD,20));
	  zh.setOpaque(false);
	  p2.add(zh);
	  
	  住址=new JLabel("住址",JLabel.CENTER);
	  住址.setFont(new Font("华文行楷", Font.PLAIN, 30));
     p1.add(住址);
	     zz=new JTextField(10);
	     zz.setFont(new Font("宋体",Font.BOLD,20));
		 zz.setOpaque(false);
		 p2.add(zz);
		 

	
		
		电话=new JLabel("电话",JLabel.CENTER);
		 电话.setFont(new Font("华文行楷", Font.PLAIN, 30));
		 p1.add(电话);
		  dh=new JTextField(10);
		  dh.setFont(new Font("宋体",Font.BOLD,20));
		  dh.setOpaque(false);
		  p2.add(dh);		
	  
	  
		     折扣=new JLabel("折扣",JLabel.CENTER);
			 折扣.setFont(new Font("华文行楷", Font.PLAIN, 30));
			 p1.add(折扣);
			  zk=new JTextField(10);
			zk.setFont(new Font("宋体",Font.BOLD,20));
			zk.setOpaque(false);
			  p2.add(zk);
	
			  下一步=new JButton("下一步");   
			  下一步.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
				p1.add(下一步);
				下一步.addActionListener(this);
					    
				重新填写=new JButton("重新填写");   
				重新填写.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来				                     
				p2.add(重新填写);
				重新填写.addActionListener(this);		  
				
				this.setVisible(true);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==下一步) {
			Connection con;
			PreparedStatement stmt;
		    System.out.println("已准备修改");                          //测试行
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ce) {
				System.out.println("SQLException:"+ce.getLocalizedMessage());
			}
			try {
				
				String s3=zz.getText();
				String s4=dh.getText();
				String s5=zk.getText();

				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
				String s=zh.getText();			
				String sql ="update vip set 住址=?,电话=?,折扣=? where 账号='"+s+"'" ;								
				stmt=(PreparedStatement) con.prepareStatement(sql);				
				stmt.setString(1,s3);
				stmt.setString(2,s4);
				stmt.setString(3,s5);								
				stmt.execute();				
				JOptionPane.showMessageDialog(null, "修改成功");
				this.setVisible(false);
				System.out.println("修改成功");
			} catch (SQLException f) {
				System.out.println("SQLException:"+f.getLocalizedMessage());
			}
		}
		if (e.getSource()==重新填写) {
			zh.setText("");
			zz.setText("");
			dh.setText("");
			zk.setText("");
		}
		
	}

}
