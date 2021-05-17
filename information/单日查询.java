package 商场管理系统;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class 单日查询 extends JPanel  implements ActionListener{
	private JButton 查询;
	private JPanel p1;
	private JTextField 查询日份;
	int message=0;
public 单日查询() {
	this.setOpaque(false);////////
	 p1=new JPanel(new GridLayout(3,1,0,30));
	 p1.setOpaque(false);////////
	JLabel 查询提示=new JLabel("请输入要查询的日期");
	查询提示.setFont(new Font("华文行楷", Font.PLAIN, 30));
	p1.add(查询提示);
	
	查询日份=new JTextField();
	查询日份.setFont(new Font("宋体",Font.BOLD,20));
	查询日份.setOpaque(false);
	p1.add(查询日份);
	
	查询=new JButton("查询");
	 查询.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
	p1.add(查询);
	查询.addActionListener(this);
	p1.setBackground(Color.white);	
	this.add(p1);
	
	this.setVisible(true);	                        
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==查询) {		
		Connection con;  
		Statement stmt;   
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException f) {
			System.out.println("SQLException:"+f.getLocalizedMessage());
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
			stmt=con.createStatement();                                          
			rs=stmt.executeQuery("select * from 日财务 ");         //查询有问题
			
			while(rs.next()) {
					String st1=查询日份.getText();
				if(st1.equals(rs.getString("日期"))) {
					message=1;
			    Object ob[][]=new Object[1][4];		
			       ob[0][0]=rs.getString("日期");
			       ob[0][1]=rs.getString("进货总额");
			       ob[0][2]=rs.getString("销售总额");
			       ob[0][3]=rs.getString("利润");
			String s1[]= {"日期","进货总额","销售总额","利润"};
			JTable table1=new JTable(ob,s1);
			this.setVisible(false);
			table1.setSize(500, 500);
			     System.out.println("已创建表");
			  JScrollPane jsp1=new JScrollPane(table1);
			   jsp1.setPreferredSize(new Dimension(500,100)); 
			   p1.setVisible(false);
				this.add(jsp1);
				this.setVisible(true);
				stmt.close();
				con.close();
				break;
				}
				else {
			     continue;
				}
			}
			if(message==0) {
				JOptionPane.showMessageDialog(this, "您输入的月份不存在，请重新输入！","系统提示",
						JOptionPane.ERROR_MESSAGE);			
			}				
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
	}
	
}
}