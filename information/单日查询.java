package �̳�����ϵͳ;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class ���ղ�ѯ extends JPanel  implements ActionListener{
	private JButton ��ѯ;
	private JPanel p1;
	private JTextField ��ѯ�շ�;
	int message=0;
public ���ղ�ѯ() {
	this.setOpaque(false);////////
	 p1=new JPanel(new GridLayout(3,1,0,30));
	 p1.setOpaque(false);////////
	JLabel ��ѯ��ʾ=new JLabel("������Ҫ��ѯ������");
	��ѯ��ʾ.setFont(new Font("�����п�", Font.PLAIN, 30));
	p1.add(��ѯ��ʾ);
	
	��ѯ�շ�=new JTextField();
	��ѯ�շ�.setFont(new Font("����",Font.BOLD,20));
	��ѯ�շ�.setOpaque(false);
	p1.add(��ѯ�շ�);
	
	��ѯ=new JButton("��ѯ");
	 ��ѯ.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
	p1.add(��ѯ);
	��ѯ.addActionListener(this);
	p1.setBackground(Color.white);	
	this.add(p1);
	
	this.setVisible(true);	                        
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==��ѯ) {		
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
			rs=stmt.executeQuery("select * from �ղ��� ");         //��ѯ������
			
			while(rs.next()) {
					String st1=��ѯ�շ�.getText();
				if(st1.equals(rs.getString("����"))) {
					message=1;
			    Object ob[][]=new Object[1][4];		
			       ob[0][0]=rs.getString("����");
			       ob[0][1]=rs.getString("�����ܶ�");
			       ob[0][2]=rs.getString("�����ܶ�");
			       ob[0][3]=rs.getString("����");
			String s1[]= {"����","�����ܶ�","�����ܶ�","����"};
			JTable table1=new JTable(ob,s1);
			this.setVisible(false);
			table1.setSize(500, 500);
			     System.out.println("�Ѵ�����");
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
				JOptionPane.showMessageDialog(this, "��������·ݲ����ڣ����������룡","ϵͳ��ʾ",
						JOptionPane.ERROR_MESSAGE);			
			}				
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
	}
	
}
}