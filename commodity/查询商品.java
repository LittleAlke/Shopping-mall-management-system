package �̳�����ϵͳ;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.View;


public class ��ѯ��Ʒ extends JPanel implements ActionListener {
	private JTextField ��Ʒ���;
	private JPanel p0,p1;
	private int message=0;
	public   ��ѯ��Ʒ() {
		                                 this.setOpaque(false);////////
		p0=new JPanel(new GridLayout(4,1,10,30));
		                                  p0.setOpaque(false);////////
		JLabel ��ѯ��Ʒ=new JLabel("��ѯ��Ʒ"); 
		��ѯ��Ʒ.setFont(new Font("�����п�", Font.PLAIN, 30));
		p0.add(��ѯ��Ʒ);    
		JLabel ��������Ʒ���=new JLabel("��������Ʒ���"); 
		��������Ʒ���.setFont(new Font("�����п�", Font.PLAIN, 30));
		p0.add(��������Ʒ���);                                
		��Ʒ���=new JTextField(10);
		��Ʒ���.setFont(new Font("����",Font.BOLD,20));
		��Ʒ���.setOpaque(false);
		p0.add(��Ʒ���);
		JButton ��ѯ=new JButton("��ѯ");
		��ѯ.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
		p0.add(��ѯ);
		��ѯ.addActionListener(this);
		p0.setBackground(Color.white);
		this.add(p0);
		this.setVisible(true);
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="��ѯ") {
			Connection con;          
		    Statement stmt;          //MySQL��ѯ���ݿ�
		    ResultSet rs;            //���λ���ƶ�
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");
		    }
		    catch(ClassNotFoundException f){
		    	System.out.println("SQLException:"+f.getLocalizedMessage());

		    }
		    try {
		    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
		    //�������ӣ���һ��rootΪMYSQL�û������ڶ���adminΪ���롣
		    stmt=con.createStatement();         
		    rs=stmt.executeQuery("select * from shangpin ");    
		    while(rs.next()) {  
                String str1=rs.getString("���");
                String str2=��Ʒ���.getText();
                if (str1.equals(str2)) {
                	message=1;
		        String ob[][]=new String[1][5];
		    	ob[0][0]=rs.getString("���");
		    	ob[0][1]=rs.getString("����");
		    	ob[0][2]=rs.getString("����");
		    	ob[0][3]=rs.getString("����");
		    	ob[0][4]=rs.getString("�ۼ�");
		    String s[]= {"���","����","����","����","�ۼ�",};
		    JTable view=new JTable(ob,s);
		    view.setSize(500, 400);
		    view.setBackground(Color.orange);     
		    JScrollPane sPane=new JScrollPane(view);
		    sPane.setPreferredSize(new Dimension(500, 100));
		    p0.setVisible(false);
		    this.setBackground(Color.pink);
		    this.add(sPane);
		    this.setVisible(true);
		    con.close();
			break;
		    }

                else {
                	continue;
				}
                 
		    } 
		    if (message==0) {             //�㷨����Ի���
		    	JOptionPane.showMessageDialog(this, "���ѯ�ı�Ų����ڣ�","ϵͳ��ʾ",JOptionPane.WARNING_MESSAGE);
		    }
		    }
		    catch (SQLException ex) {
				ex.printStackTrace();
		    	// TODO: handle exception
			}
		    
	}
}
}



