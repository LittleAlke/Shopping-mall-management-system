package �̳�����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class ��ѯԱ�� extends JPanel  implements ActionListener{
	private JButton ��ѯ;
	private JPanel p1;
	private JTextField ��ѯ�˺�;
	int message=0;
public ��ѯԱ��() {
	                                              this.setOpaque(false);////////
	 p1=new JPanel(new GridLayout(3,1,0,50));
	                                             p1.setOpaque(false);////////
	JLabel ��ѯ��ʾ=new JLabel("������Ҫ��ѯԱ���Ĺ���");
	��ѯ��ʾ.setFont(new Font("�����п�", Font.PLAIN, 30));
	p1.add(��ѯ��ʾ);
	
	��ѯ�˺�=new JTextField();
	��ѯ�˺�.setFont(new Font("����",Font.BOLD,20));
	��ѯ�˺�.setOpaque(false);
	p1.add(��ѯ�˺�);
	
	��ѯ=new JButton("��ѯ");
	��ѯ.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
	p1.add(��ѯ);
	��ѯ.addActionListener(this);

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
			rs=stmt.executeQuery("select * from staff ");         //��ѯ������
			
			while(rs.next()) {
					String st1=��ѯ�˺�.getText();
			        //String st2=rs.getString("����");
				if(st1.equals(rs.getString("����"))) {
					message=1;
			    Object ob[][]=new Object[1][7];		
			       ob[0][0]=rs.getString("����");
			       ob[0][1]=rs.getString("����");
			       ob[0][2]=rs.getString("�Ա�");
			       ob[0][3]=rs.getString("����");
			       ob[0][4]=rs.getString("����");
			       ob[0][5]=rs.getString("ְ��");
			       ob[0][6]=rs.getString("��н");
			String s1[]= {"����","����","�Ա�","����","����","ְ��","��н"};
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
				JOptionPane.showMessageDialog(this, "��������˺Ż��������󣬻��˺Ų����ڣ����������룡","ϵͳ��ʾ",
						JOptionPane.ERROR_MESSAGE);			
			}				
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
	}
	
}
}
