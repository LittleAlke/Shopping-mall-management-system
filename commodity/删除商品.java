package �̳�����ϵͳ;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

public class ɾ����Ʒ  extends JPanel implements ActionListener{
	private JTextField ���;
	public ɾ����Ʒ() {
		                                                   this.setOpaque(false);////////
		   	JPanel p0=new JPanel(new GridLayout(3,1,0,20));
		                                                    	p0.setOpaque(false);////////
			JLabel ��������Ʒ���=new JLabel("��������Ʒ���");
			��������Ʒ���.setFont(new Font("�����п�", Font.PLAIN, 30));
			p0.add(��������Ʒ���);                                
			
			���=new JTextField(10);
			���.setFont(new Font("����",Font.BOLD,20));
			���.setOpaque(false);
			p0.add(���);
			
			JButton ȷ��=new JButton("ɾ��");
			ȷ��.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
			p0.add(ȷ��);
			ȷ��.addActionListener(this);
			
			p0.setBackground(Color.white);
			this.add(p0);
			this.setVisible(true);
			
	}

	@Override
	public  void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="ȷ��") {
			System.out.print("ssssssssss");
			Connection con;          
			PreparedStatement stmt;        //����һ�� PreparedStatement ���������������� SQL ��䷢�͵����ݿ�
		    ResultSet rs;                  //���λ���ƶ�
		    String str=���.getText();
		    System.out.print("str");
		    String sql = "delete from shangpin where ���='"+str+"'";
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");
		    }
		    catch(ClassNotFoundException f){
		    	System.out.println("SQLException:"+f.getLocalizedMessage());

		    }
		    try {
		    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
		    //�������ӣ���һ��rootΪMYSQL�û������ڶ���adminΪ���롣
		    	stmt = (PreparedStatement) con.prepareStatement(sql);  //����һ�� PreparedStatement ���������������� SQL ��䷢�͵����ݿ�
		    	    stmt.executeUpdate(sql);          //ɾ����������
		    	    JOptionPane.showMessageDialog(this, "ɾ���ɹ���","ϵͳ��ʾ",JOptionPane.WARNING_MESSAGE);
	}
		    
		    catch (SQLException ex) {
				ex.printStackTrace();
		    	// TODO: handle exception
			}
             
		}
	}
}
