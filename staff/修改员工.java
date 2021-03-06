package 商场管理系统;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
public class 修改员工 extends JPanel implements ActionListener{
	private JButton 下一步,重新填写;
	private JLabel 工号,姓名,性别,年龄,部门,职务,月薪;
	private JComboBox bm,zw;
	private JTextField gh,xm,nl,yx;
	private JRadioButton 男,女;
	private JPanel p1,p2,p3;
public 修改员工() {
	this.setLayout(new GridLayout(1,2,150,0));
	                                                         this.setOpaque(false);////////
	p1=new JPanel(new GridLayout(10,1,0,15));
                                                            	p1.setOpaque(false);////////
	p2=new JPanel(new GridLayout(10,1,0,15));
                                                          	p2.setOpaque(false);////////
	this.add(p1);
	this.add(p2);
	
	工号=new JLabel("工号",JLabel.CENTER);
	 工号.setFont(new Font("华文行楷", Font.PLAIN, 30));
	 p1.add(工号);
	  gh=new JTextField(10);
	  gh.setFont(new Font("宋体",Font.BOLD,20));
	  gh.setOpaque(false);
	  p2.add(gh);
	  
	  姓名=new JLabel("姓名",JLabel.CENTER);
	  姓名.setFont(new Font("华文行楷", Font.PLAIN, 30));
     p1.add(姓名);
	     xm=new JTextField(10);
	     xm.setFont(new Font("宋体",Font.BOLD,20));
		 xm.setOpaque(false);
		 p2.add(xm);
		 
	  性别=new JLabel("性别",JLabel.CENTER);
	 性别.setFont(new Font("华文行楷", Font.PLAIN, 30));
	  p1.add(性别);
	  ButtonGroup xb=new ButtonGroup();
		 男 =new JRadioButton("男",false);
	     xb.add(男);
		  女 =new JRadioButton("女",false);
		 xb.add(女);
		JPanel p21=new JPanel();
	                                            	p21.setOpaque(false);////////
		p21.add(男);
		p21.add(女);
		p2.add(p21);
		
		年龄=new JLabel("年龄",JLabel.CENTER);
		 年龄.setFont(new Font("华文行楷", Font.PLAIN, 30));
		 p1.add(年龄);
		  nl=new JTextField(10);
		  nl.setFont(new Font("宋体",Font.BOLD,20));
		  nl.setOpaque(false);
		  p2.add(nl);		
			 
       部门=new JLabel("部门",JLabel.CENTER);
	    部门.setFont(new Font("华文行楷", Font.PLAIN, 30));
	    p1.add(部门);
		 //bm.setFont(new Font("宋体",Font.BOLD,30));
		 Object bumen[]= {"销售部","服务部","货物部"};
		 bm=new JComboBox(bumen);
		  p2.add(bm);
	  
	       职务=new JLabel("职务",JLabel.CENTER);
		   职务.setFont(new Font("华文行楷", Font.PLAIN, 30));
		   p1.add(职务);
			 //zw.setFont(new Font("宋体",Font.BOLD,30));
		     Object zhiwu[]= {"干事","经理","总监"};
			 zw=new JComboBox(zhiwu);
			  p2.add(zw);	  
	  
		     月薪=new JLabel("月薪",JLabel.CENTER);
			 月薪.setFont(new Font("华文行楷", Font.PLAIN, 30));
			 p1.add(月薪);
			  yx=new JTextField(10);
			yx.setFont(new Font("宋体",Font.BOLD,20));
			  p2.add(yx);
	
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
				String s2=xm.getText();
				String s3=nl.getText();
				String s4=yx.getText();
				String XB=""; 
				if (男.isSelected()) {
					XB=男.getText();	}
				if (女.isSelected()) {
					XB=女.getText();}
				
				String BM="";
				if (bm.getSelectedIndex()==0) {
					BM="销售部";}
				if (bm.getSelectedIndex()==1) {
					BM="服务部";}
				if (bm.getSelectedIndex()==2) {
					BM="货物部";}
				
				String ZW="";
				if (zw.getSelectedIndex()==0) {
					ZW="干事";}
				if (zw.getSelectedIndex()==1) {
					ZW="经理";}
				if (zw.getSelectedIndex()==2) {
					ZW="总监";}
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
				String s=gh.getText();			
				String sql ="update staff set 姓名=?,性别=?,年龄=?,部门=?,职务=?,月薪=? where 工号='"+s+"'" ;								
				stmt=(PreparedStatement) con.prepareStatement(sql);				
				stmt.setString(1,s2);
				stmt.setString(2,XB);
				stmt.setString(3,s3);
				stmt.setString(4,BM);
				stmt.setString(5,ZW);
				stmt.setString(6,s4);					
				stmt.execute();				
				JOptionPane.showMessageDialog(null, "修改成功");
				this.setVisible(false);
				System.out.println("修改成功");
			} catch (SQLException f) {
				System.out.println("SQLException:"+f.getLocalizedMessage());
			}
		}
		if (e.getSource()==重新填写) {
			gh.setText("");
			xm.setText("");
			nl.setText("");
			yx.setText("");
		}
		
	}

}
