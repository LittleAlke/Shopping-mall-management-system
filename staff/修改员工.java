package �̳�����ϵͳ;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
public class �޸�Ա�� extends JPanel implements ActionListener{
	private JButton ��һ��,������д;
	private JLabel ����,����,�Ա�,����,����,ְ��,��н;
	private JComboBox bm,zw;
	private JTextField gh,xm,nl,yx;
	private JRadioButton ��,Ů;
	private JPanel p1,p2,p3;
public �޸�Ա��() {
	this.setLayout(new GridLayout(1,2,150,0));
	                                                         this.setOpaque(false);////////
	p1=new JPanel(new GridLayout(10,1,0,15));
                                                            	p1.setOpaque(false);////////
	p2=new JPanel(new GridLayout(10,1,0,15));
                                                          	p2.setOpaque(false);////////
	this.add(p1);
	this.add(p2);
	
	����=new JLabel("����",JLabel.CENTER);
	 ����.setFont(new Font("�����п�", Font.PLAIN, 30));
	 p1.add(����);
	  gh=new JTextField(10);
	  gh.setFont(new Font("����",Font.BOLD,20));
	  gh.setOpaque(false);
	  p2.add(gh);
	  
	  ����=new JLabel("����",JLabel.CENTER);
	  ����.setFont(new Font("�����п�", Font.PLAIN, 30));
     p1.add(����);
	     xm=new JTextField(10);
	     xm.setFont(new Font("����",Font.BOLD,20));
		 xm.setOpaque(false);
		 p2.add(xm);
		 
	  �Ա�=new JLabel("�Ա�",JLabel.CENTER);
	 �Ա�.setFont(new Font("�����п�", Font.PLAIN, 30));
	  p1.add(�Ա�);
	  ButtonGroup xb=new ButtonGroup();
		 �� =new JRadioButton("��",false);
	     xb.add(��);
		  Ů =new JRadioButton("Ů",false);
		 xb.add(Ů);
		JPanel p21=new JPanel();
	                                            	p21.setOpaque(false);////////
		p21.add(��);
		p21.add(Ů);
		p2.add(p21);
		
		����=new JLabel("����",JLabel.CENTER);
		 ����.setFont(new Font("�����п�", Font.PLAIN, 30));
		 p1.add(����);
		  nl=new JTextField(10);
		  nl.setFont(new Font("����",Font.BOLD,20));
		  nl.setOpaque(false);
		  p2.add(nl);		
			 
       ����=new JLabel("����",JLabel.CENTER);
	    ����.setFont(new Font("�����п�", Font.PLAIN, 30));
	    p1.add(����);
		 //bm.setFont(new Font("����",Font.BOLD,30));
		 Object bumen[]= {"���۲�","����","���ﲿ"};
		 bm=new JComboBox(bumen);
		  p2.add(bm);
	  
	       ְ��=new JLabel("ְ��",JLabel.CENTER);
		   ְ��.setFont(new Font("�����п�", Font.PLAIN, 30));
		   p1.add(ְ��);
			 //zw.setFont(new Font("����",Font.BOLD,30));
		     Object zhiwu[]= {"����","����","�ܼ�"};
			 zw=new JComboBox(zhiwu);
			  p2.add(zw);	  
	  
		     ��н=new JLabel("��н",JLabel.CENTER);
			 ��н.setFont(new Font("�����п�", Font.PLAIN, 30));
			 p1.add(��н);
			  yx=new JTextField(10);
			yx.setFont(new Font("����",Font.BOLD,20));
			  p2.add(yx);
	
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
				String s2=xm.getText();
				String s3=nl.getText();
				String s4=yx.getText();
				String XB=""; 
				if (��.isSelected()) {
					XB=��.getText();	}
				if (Ů.isSelected()) {
					XB=Ů.getText();}
				
				String BM="";
				if (bm.getSelectedIndex()==0) {
					BM="���۲�";}
				if (bm.getSelectedIndex()==1) {
					BM="����";}
				if (bm.getSelectedIndex()==2) {
					BM="���ﲿ";}
				
				String ZW="";
				if (zw.getSelectedIndex()==0) {
					ZW="����";}
				if (zw.getSelectedIndex()==1) {
					ZW="����";}
				if (zw.getSelectedIndex()==2) {
					ZW="�ܼ�";}
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
				String s=gh.getText();			
				String sql ="update staff set ����=?,�Ա�=?,����=?,����=?,ְ��=?,��н=? where ����='"+s+"'" ;								
				stmt=(PreparedStatement) con.prepareStatement(sql);				
				stmt.setString(1,s2);
				stmt.setString(2,XB);
				stmt.setString(3,s3);
				stmt.setString(4,BM);
				stmt.setString(5,ZW);
				stmt.setString(6,s4);					
				stmt.execute();				
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				this.setVisible(false);
				System.out.println("�޸ĳɹ�");
			} catch (SQLException f) {
				System.out.println("SQLException:"+f.getLocalizedMessage());
			}
		}
		if (e.getSource()==������д) {
			gh.setText("");
			xm.setText("");
			nl.setText("");
			yx.setText("");
		}
		
	}

}
