package �̳�����ϵͳ;

import java.awt.Color;
import java.awt.Dialog;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ������Ʒ extends JPanel implements ActionListener {
	private JComboBox ��Ʒ����;   //��Ͽ�
	private JTextField ���,����,����,����,�ۼ�;
	private JLabel ��������Ʒ���,ѡ����µ�����,������µ�����;
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
			
			JLabel ������������� =new JLabel("�������������"); 
			�������������.setFont(new Font("�����п�", Font.PLAIN, 30));
			p0.add(�������������);                                
			
			����=new JTextField(10);
			����.setFont(new Font("����",Font.BOLD,20));
			����.setOpaque(false);
			p0.add(����);
			
			JLabel �������������=new JLabel("�������������");  
			�������������.setFont(new Font("�����п�", Font.PLAIN, 30));
			p0.add(�������������);                                
			
			 ����=new JTextField(10);
			 ����.setFont(new Font("����",Font.BOLD,20));
				����.setOpaque(false);
			p0.add(����);
			
			JLabel ��������½���=new JLabel("��������½���"); 
			��������½���.setFont(new Font("�����п�", Font.PLAIN, 30));
			p0.add(��������½���);                                
			
			 ����=new JTextField(10);
			 ����.setFont(new Font("����",Font.BOLD,20));
				����.setOpaque(false);
			p0.add(����);
			
			JLabel ����������ۼ�=new JLabel("����������ۼ�");   
			����������ۼ�.setFont(new Font("�����п�", Font.PLAIN, 30));
			p0.add(����������ۼ�);                                
			
			�ۼ�=new JTextField(10);
			 �ۼ�.setFont(new Font("����",Font.BOLD,20));
				�ۼ�.setOpaque(false);
			p0.add(�ۼ�);
		 
		   JButton ȷ��=new JButton("ȷ��");
		   ȷ��.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
			p0.add(ȷ��);
			ȷ��.addActionListener(this);
			
			p0.setBackground(Color.white);
			this.add(p0);
			this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="ȷ��") {
			Connection con;          
			PreparedStatement stmt;        //����һ�� PreparedStatement ���������������� SQL ��䷢�͵����ݿ⡣
		    ResultSet rs;                  //���λ���ƶ�
		    String str1=���.getText();     
		    String str2=����.getText();
		    String str3=����.getText();
		    String str4=����.getText();
		    String str5=�ۼ�.getText();
		    String sql = "update shangpin set ����=? ,����=?,����=?,�ۼ�=?where ���='"+str1+"'"; //strΪ�ַ��ӵ����ţ�˫������ȫΪ�����ַ���
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
		    	stmt.setString(1, str2);	//���ִ���ڼ��� update (����) set  (����1)=?,����2=? where (����)=��
		    	
		    	stmt.setString(2, str3);
		    	
		    	stmt.setString(3, str4);
		    	
		    	stmt.setString(4, str5);	
		    	JOptionPane.showMessageDialog(this, "���³ɹ���","ϵͳ��ʾ",JOptionPane.WARNING_MESSAGE);
		    	stmt.execute();} //�ڴ� PreparedStatement ������ִ�� SQL ��䣬�����������κ������ SQL ���
		    
		    
		    catch (SQLException ex) {
				ex.printStackTrace();
		    	// TODO: handle exception
			}
}
	}
}
