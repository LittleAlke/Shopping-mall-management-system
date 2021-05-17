package 商场管理系统;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
public class 注册VIP extends JPanel implements ActionListener{
   private JButton 下一步,重新填写;
   private JLabel 账号,姓名,性别,住址,电话,折扣,注册时间;
   //private JComboBox bm,zw;
   private JTextField zh,xm,zz,dh,zk,sj;
   private JRadioButton 男,女;
   private JPanel p1,p2,p3;
public  注册VIP() {
		this.setLayout(new GridLayout(1,3,150,0));
		                                         this.setOpaque(false);////////
		p1=new JPanel(new GridLayout(10,1));
		                                         p1.setOpaque(false);////////
		 JLabel j1=new JLabel("注册步骤：");
		 j1.setFont(new Font("华文行楷", Font.PLAIN, 30));
		 JLabel j2=new JLabel("一、填写表单");
		 j2.setFont(new Font("华文行楷", Font.PLAIN, 30));
		 JLabel j3=new JLabel("二、完成注册");
		 j3.setFont(new Font("华文行楷", Font.PLAIN, 30));
		 p1.add(j1);
		 p1.add(j2);
		 p1.add(j3);
		 this.add(p1);
		p2=new JPanel(new GridLayout(10,1,0,15));
		                                          p2.setOpaque(false);////////
		p3=new JPanel(new GridLayout(10,1,0,15));
		                                          p3.setOpaque(false);////////
		this.add(p2);
		this.add(p3);
		
		 账号=new JLabel("账号",JLabel.CENTER);
		 账号.setFont(new Font("华文行楷", Font.PLAIN, 30));
		 p2.add(账号);
		  zh=new JTextField(10);
		  zh.setFont(new Font("宋体",Font.BOLD,20));
		  zh.setOpaque(false);
		  p3.add(zh);
		  
		  姓名=new JLabel("姓名",JLabel.CENTER);
		  姓名.setFont(new Font("华文行楷", Font.PLAIN, 30));
	      p2.add(姓名);
		     xm=new JTextField(10);
		     xm.setFont(new Font("宋体",Font.BOLD,20));
			 xm.setOpaque(false);
			 p3.add(xm);
			 
		  性别=new JLabel("性别",JLabel.CENTER);
		 性别.setFont(new Font("华文行楷", Font.PLAIN, 30));
		  p2.add(性别);
		  ButtonGroup xb=new ButtonGroup();
			 男 =new JRadioButton("男",false);
		     xb.add(男);
			  女 =new JRadioButton("女",false);
			 xb.add(女);
			JPanel p31=new JPanel();
			                                    p31.setOpaque(false);////////
			p31.add(男);
			p31.add(女);
			p3.add(p31);
			
			住址=new JLabel("住址",JLabel.CENTER);
			 住址.setFont(new Font("华文行楷", Font.PLAIN, 30));
			 p2.add(住址);
			  zz=new JTextField(10);
			  zz.setFont(new Font("宋体",Font.BOLD,20));
			  zz.setOpaque(false);
			  p3.add(zz);		
				 
			  电话=new JLabel("电话",JLabel.CENTER);
				 电话.setFont(new Font("华文行楷", Font.PLAIN, 30));
				 p2.add(电话);
				  dh=new JTextField(10);
				  dh.setFont(new Font("宋体",Font.BOLD,20));
				  dh.setOpaque(false);
				  p3.add(dh);
		  
				  折扣=new JLabel("折扣",JLabel.CENTER);
					 折扣.setFont(new Font("华文行楷", Font.PLAIN, 30));
					 p2.add(折扣);
					  zk=new JTextField(10);
					  zk.setFont(new Font("宋体",Font.BOLD,20));
					  zk.setOpaque(false);
					  p3.add(zk);	  
		  
			     注册时间=new JLabel("注册时间",JLabel.CENTER);
				 注册时间.setFont(new Font("华文行楷", Font.PLAIN, 30));
				 p2.add(注册时间);
				  sj=new JTextField(10);
				sj.setFont(new Font("宋体",Font.BOLD,20));
				  p3.add(sj);
				  
			下一步=new JButton("下一步");   
			下一步.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
			p2.add(下一步);
			下一步.addActionListener(this);
				    
			重新填写=new JButton("重新填写");   
			重新填写.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
			p3.add(重新填写);
			重新填写.addActionListener(this);		  
			
			this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==下一步) {
			Connection con;
			Statement stmt;
		    System.out.println("已准备注册");                          //测试行
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ce) {
				System.out.println("SQLException:"+ce.getLocalizedMessage());
			}
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
				stmt=con.createStatement();
				                               System.out.println("1");
				String XB=""; 
				if (男.isSelected()) {
					XB=男.getText();	}
				if (女.isSelected()) {
					XB=女.getText();}
				
				String sqlstr="insert into vip"
						+ "(账号,姓名,性别,住址,电话,折扣,注册时间)"
						+ "values("
						+ "'"+zh.getText()+"'"
						+ ","+"'"+xm.getText()+"'"
						+ ","+"'"+XB+"'"
						+ ","+"'"+zz.getText()+"'"
						+ ","+"'"+dh.getText()+"'"
						+ ","+"'"+zk.getText()+"'"
						+ ","+"'"+sj.getText()+"'"
						+ ")";
				                             System.out.println("2");
				stmt.executeUpdate(sqlstr);				
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "注册成功");
				this.setVisible(false);
				System.out.println("注册成功");
			} catch (SQLException f) {
				System.out.println("SQLException:"+f.getLocalizedMessage());
			}
		}
		if (e.getSource()==重新填写) {
			zh.setText("");
			xm.setText("");
			zz.setText("");
			dh.setText("");
			zk.setText("");
			sj.setText("");
		}
	}

}
