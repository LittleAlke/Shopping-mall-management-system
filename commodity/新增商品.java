package  �̳�����ϵͳ;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ������Ʒ extends JPanel implements ActionListener {
	private JTextField ���,����,����,����,�ۼ�;
	public ������Ʒ() {
		                                                          this.setOpaque(false);////////
	   	        JPanel p0=new JPanel(new GridLayout(10,1,20,20));
	   	                                                          p0.setOpaque(false);////////
				JLabel ��������Ʒ���=new JLabel("��������Ʒ���");     
				��������Ʒ���.setFont(new Font("�����п�", Font.PLAIN, 30));
				p0.add(��������Ʒ���);  
				
				 ���=new JTextField(10);
				 ���.setFont(new Font("����",Font.BOLD,20));
				���.setOpaque(false);
				p0.add(���);
				
				JLabel ��������Ʒ���� =new JLabel("��������Ʒ����"); 
				��������Ʒ����.setFont(new Font("�����п�", Font.PLAIN, 30));
				p0.add(��������Ʒ����);                                
				
				 ����=new JTextField(10);
				 ����.setFont(new Font("����",Font.BOLD,20));
					����.setOpaque(false);
				p0.add(����);
				
				JLabel ��������Ʒ����=new JLabel("��������Ʒ����");  
				��������Ʒ����.setFont(new Font("�����п�", Font.PLAIN, 30));
				p0.add(��������Ʒ����);                                
				
				 ����=new JTextField(10);
				 ����.setFont(new Font("����",Font.BOLD,20));
					����.setOpaque(false);
				p0.add(����);
				
				JLabel ��������Ʒ����=new JLabel("��������Ʒ����");      
				��������Ʒ����.setFont(new Font("�����п�", Font.PLAIN, 30));
				p0.add(��������Ʒ����);                                
				
				 ����=new JTextField(10);
				 ����.setFont(new Font("����",Font.BOLD,20));
					����.setOpaque(false);
				p0.add(����);
				
				JLabel ��������Ʒ�ۼ�=new JLabel("��������Ʒ�ۼ�");     
				��������Ʒ�ۼ�.setFont(new Font("�����п�", Font.PLAIN, 30));
				p0.add(��������Ʒ�ۼ�);                                
				
				 �ۼ�=new JTextField(10);
				 �ۼ�.setFont(new Font("����",Font.BOLD,20));
					�ۼ�.setOpaque(false);
				p0.add(�ۼ�);
				
				
				JButton ����=new JButton("����");
				����.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
				p0.add(����);
				����.addActionListener(this);
				
				p0.setBackground(Color.white);
				this.add(p0);
				this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="����") {
			Connection con;          
			PreparedStatement stmt;        //����һ�� PreparedStatement ���������������� SQL ��䷢�͵����ݿ⡣
		    ResultSet rs;                  //���λ���ƶ�
		    String str1=���.getText();     
		    String str2=����.getText();
		    String str3=����.getText();
		    String str4=����.getText();
		    String str5=�ۼ�.getText();
		    String sql = "insert into shangpin(���,����,����,����,�ۼ�)values(?,?,?,?,?)"; 
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");
		    }
		    catch(ClassNotFoundException f){
		    	System.out.println("SQLException:"+f.getLocalizedMessage());

		    }
		    try {
		    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
		    //�������ӣ���һ��rootΪMYSQL�û������ڶ���adminΪ���롣
		    	 // ����һ�� PreparedStatement ���������������� SQL ��䷢�͵����ݿ⡣
		    	stmt = (PreparedStatement) con.prepareStatement(sql);    
		    	// �ڴ� PreparedStatement ������ִ�� SQL ���
		    	stmt.setString(1, str1);
		    	
		    	stmt.setString(2, str2);	
		    	
		    	stmt.setString(3, str3);
		    	
		    	stmt.setString(4, str4);
		    	
		    	stmt.setString(5, str5);	
		    	JOptionPane.showMessageDialog(this, "���³ɹ���","ϵͳ��ʾ",JOptionPane.WARNING_MESSAGE);
		    	stmt.execute();} //�ڴ� PreparedStatement ������ִ�� SQL ��䣬�����������κ������ SQL ���
		    
		    
		    catch (SQLException ex) {
				ex.printStackTrace();
		    	// TODO: handle exception
			}
}
	}
	}


