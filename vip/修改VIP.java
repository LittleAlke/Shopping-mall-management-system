package �̳�����ϵͳ;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
public class �޸�VIP extends JPanel implements ActionListener{
	private JButton ��һ��,������д;
	private JLabel �˺�,סַ,�绰,�ۿ�;
	//private JComboBox bm,zw;
	private JTextField zh,zz,dh,zk;
	//private JRadioButton ��,Ů;
	private JPanel p1,p2,p3;
public �޸�VIP() {
	this.setLayout(new GridLayout(1,2,150,0));
	                                                         this.setOpaque(false);////////
	p1=new JPanel(new GridLayout(10,1,0,15));
                                                            	p1.setOpaque(false);////////
	p2=new JPanel(new GridLayout(10,1,0,15));
                                                          	p2.setOpaque(false);////////
	this.add(p1);
	this.add(p2);
	
	�˺�=new JLabel("�˺�",JLabel.CENTER);
	 �˺�.setFont(new Font("�����п�", Font.PLAIN, 30));
	 p1.add(�˺�);
	  zh=new JTextField(10);
	  zh.setFont(new Font("����",Font.BOLD,20));
	  zh.setOpaque(false);
	  p2.add(zh);
	  
	  סַ=new JLabel("סַ",JLabel.CENTER);
	  סַ.setFont(new Font("�����п�", Font.PLAIN, 30));
     p1.add(סַ);
	     zz=new JTextField(10);
	     zz.setFont(new Font("����",Font.BOLD,20));
		 zz.setOpaque(false);
		 p2.add(zz);
		 

	
		
		�绰=new JLabel("�绰",JLabel.CENTER);
		 �绰.setFont(new Font("�����п�", Font.PLAIN, 30));
		 p1.add(�绰);
		  dh=new JTextField(10);
		  dh.setFont(new Font("����",Font.BOLD,20));
		  dh.setOpaque(false);
		  p2.add(dh);		
	  
	  
		     �ۿ�=new JLabel("�ۿ�",JLabel.CENTER);
			 �ۿ�.setFont(new Font("�����п�", Font.PLAIN, 30));
			 p1.add(�ۿ�);
			  zk=new JTextField(10);
			zk.setFont(new Font("����",Font.BOLD,20));
			zk.setOpaque(false);
			  p2.add(zk);
	
			  ��һ��=new JButton("��һ��");   
			  ��һ��.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
				p1.add(��һ��);
				��һ��.addActionListener(this);
					    
				������д=new JButton("������д");   
				������д.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����				                     
				p2.add(������д);
				������д.addActionListener(this);		  
				
				this.setVisible(true);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==��һ��) {
			Connection con;
			PreparedStatement stmt;
		    System.out.println("��׼���޸�");                          //������
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ce) {
				System.out.println("SQLException:"+ce.getLocalizedMessage());
			}
			try {
				
				String s3=zz.getText();
				String s4=dh.getText();
				String s5=zk.getText();

				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
				String s=zh.getText();			
				String sql ="update vip set סַ=?,�绰=?,�ۿ�=? where �˺�='"+s+"'" ;								
				stmt=(PreparedStatement) con.prepareStatement(sql);				
				stmt.setString(1,s3);
				stmt.setString(2,s4);
				stmt.setString(3,s5);								
				stmt.execute();				
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				this.setVisible(false);
				System.out.println("�޸ĳɹ�");
			} catch (SQLException f) {
				System.out.println("SQLException:"+f.getLocalizedMessage());
			}
		}
		if (e.getSource()==������д) {
			zh.setText("");
			zz.setText("");
			dh.setText("");
			zk.setText("");
		}
		
	}

}
