package �̳�����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class ���Ա�� extends JPanel implements ActionListener{
	
public  ���Ա��() {
	this.setOpaque(false);////////
	JPanel p1=new JPanel();
	p1.setOpaque(false);////////
	p1.setVisible(false);                                                          
	this.setLayout(new BorderLayout());
	Connection con;  //
	Statement stmt;   //mysql���ݿ�
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
		ob[i][0]=rs.getString("����");
		ob[i][1]=rs.getString("����");
		ob[i][2]=rs.getString("�Ա�");
		ob[i][3]=rs.getString("����");
		ob[i][4]=rs.getString("����");
		ob[i][5]=rs.getString("ְ��");
		ob[i][6]=rs.getString("��н");
		}
		String s1[]= {"����","����","�Ա�","����","����","ְ��","��н"};
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
