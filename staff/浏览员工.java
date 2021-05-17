package 商场管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class 浏览员工 extends JPanel implements ActionListener{
	
public  浏览员工() {
	this.setOpaque(false);////////
	JPanel p1=new JPanel();
	p1.setOpaque(false);////////
	p1.setVisible(false);                                                          
	this.setLayout(new BorderLayout());
	Connection con;  //
	Statement stmt;   //mysql数据库
	ResultSet rs;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException f) {
		System.out.println("SQLException:"+f.getLocalizedMessage());
	}
	try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
		stmt=con.createStatement();                                          
		rs=stmt.executeQuery("select * from staff");
		rs.last();
		int k= rs.getRow();
	    rs.beforeFirst();
			Object ob[][]=new Object[k][7];
		
		for (int i = 0; i < k&&rs.next(); i++) {
		ob[i][0]=rs.getString("工号");
		ob[i][1]=rs.getString("姓名");
		ob[i][2]=rs.getString("性别");
		ob[i][3]=rs.getString("年龄");
		ob[i][4]=rs.getString("部门");
		ob[i][5]=rs.getString("职务");
		ob[i][6]=rs.getString("月薪");
		}
		String s1[]= {"工号","姓名","性别","年龄","部门","职务","月薪"};
		JTable table1=new JTable(ob,s1);
	                                                              	table1.setOpaque(false);////////
		table1.setSize(300, 200);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	                                                   
		   JScrollPane jsp1=new JScrollPane(table1);
		                                                                jsp1.setOpaque(false);////////
		   jsp1.setPreferredSize(new Dimension(540,200));                  
		p1.add(jsp1);
		p1.setVisible(true);
	                                                     	p1.setOpaque(false);////////
		this.add(p1);
		this.setVisible(true);
		
		stmt.close();
		con.close();
		
	}catch (SQLException ex) {
		ex.printStackTrace();
	}
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}
