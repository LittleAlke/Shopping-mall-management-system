package �̳�����ϵͳ;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
public class ע��VIP extends JPanel implements ActionListener{
   private JButton ��һ��,������д;
   private JLabel �˺�,����,�Ա�,סַ,�绰,�ۿ�,ע��ʱ��;
   //private JComboBox bm,zw;
   private JTextField zh,xm,zz,dh,zk,sj;
   private JRadioButton ��,Ů;
   private JPanel p1,p2,p3;
public  ע��VIP() {
		this.setLayout(new GridLayout(1,3,150,0));
		                                         this.setOpaque(false);////////
		p1=new JPanel(new GridLayout(10,1));
		                                         p1.setOpaque(false);////////
		 JLabel j1=new JLabel("ע�Ჽ�裺");
		 j1.setFont(new Font("�����п�", Font.PLAIN, 30));
		 JLabel j2=new JLabel("һ����д��");
		 j2.setFont(new Font("�����п�", Font.PLAIN, 30));
		 JLabel j3=new JLabel("�������ע��");
		 j3.setFont(new Font("�����п�", Font.PLAIN, 30));
		 p1.add(j1);
		 p1.add(j2);
		 p1.add(j3);
		 this.add(p1);
		p2=new JPanel(new GridLayout(10,1,0,15));
		                                          p2.setOpaque(false);////////
		p3=new JPanel(new GridLayout(10,1,0,15));
		                                          p3.setOpaque(false);////////
		this.add(p2);
		this.add(p3);
		
		 �˺�=new JLabel("�˺�",JLabel.CENTER);
		 �˺�.setFont(new Font("�����п�", Font.PLAIN, 30));
		 p2.add(�˺�);
		  zh=new JTextField(10);
		  zh.setFont(new Font("����",Font.BOLD,20));
		  zh.setOpaque(false);
		  p3.add(zh);
		  
		  ����=new JLabel("����",JLabel.CENTER);
		  ����.setFont(new Font("�����п�", Font.PLAIN, 30));
	      p2.add(����);
		     xm=new JTextField(10);
		     xm.setFont(new Font("����",Font.BOLD,20));
			 xm.setOpaque(false);
			 p3.add(xm);
			 
		  �Ա�=new JLabel("�Ա�",JLabel.CENTER);
		 �Ա�.setFont(new Font("�����п�", Font.PLAIN, 30));
		  p2.add(�Ա�);
		  ButtonGroup xb=new ButtonGroup();
			 �� =new JRadioButton("��",false);
		     xb.add(��);
			  Ů =new JRadioButton("Ů",false);
			 xb.add(Ů);
			JPanel p31=new JPanel();
			                                    p31.setOpaque(false);////////
			p31.add(��);
			p31.add(Ů);
			p3.add(p31);
			
			סַ=new JLabel("סַ",JLabel.CENTER);
			 סַ.setFont(new Font("�����п�", Font.PLAIN, 30));
			 p2.add(סַ);
			  zz=new JTextField(10);
			  zz.setFont(new Font("����",Font.BOLD,20));
			  zz.setOpaque(false);
			  p3.add(zz);		
				 
			  �绰=new JLabel("�绰",JLabel.CENTER);
				 �绰.setFont(new Font("�����п�", Font.PLAIN, 30));
				 p2.add(�绰);
				  dh=new JTextField(10);
				  dh.setFont(new Font("����",Font.BOLD,20));
				  dh.setOpaque(false);
				  p3.add(dh);
		  
				  �ۿ�=new JLabel("�ۿ�",JLabel.CENTER);
					 �ۿ�.setFont(new Font("�����п�", Font.PLAIN, 30));
					 p2.add(�ۿ�);
					  zk=new JTextField(10);
					  zk.setFont(new Font("����",Font.BOLD,20));
					  zk.setOpaque(false);
					  p3.add(zk);	  
		  
			     ע��ʱ��=new JLabel("ע��ʱ��",JLabel.CENTER);
				 ע��ʱ��.setFont(new Font("�����п�", Font.PLAIN, 30));
				 p2.add(ע��ʱ��);
				  sj=new JTextField(10);
				sj.setFont(new Font("����",Font.BOLD,20));
				  p3.add(sj);
				  
			��һ��=new JButton("��һ��");   
			��һ��.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
			p2.add(��һ��);
			��һ��.addActionListener(this);
				    
			������д=new JButton("������д");   
			������д.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
			p3.add(������д);
			������д.addActionListener(this);		  
			
			this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==��һ��) {
			Connection con;
			Statement stmt;
		    System.out.println("��׼��ע��");                          //������
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ce) {
				System.out.println("SQLException:"+ce.getLocalizedMessage());
			}
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
				stmt=con.createStatement();
				                               System.out.println("1");
				String XB=""; 
				if (��.isSelected()) {
					XB=��.getText();	}
				if (Ů.isSelected()) {
					XB=Ů.getText();}
				
				String sqlstr="insert into vip"
						+ "(�˺�,����,�Ա�,סַ,�绰,�ۿ�,ע��ʱ��)"
						+ "values("
						+ "'"+zh.getText()+"'"
						+ ","+"'"+xm.getText()+"'"
						+ ","+"'"+XB+"'"
						+ ","+"'"+zz.getText()+"'"
						+ ","+"'"+dh.getText()+"'"
						+ ","+"'"+zk.getText()+"'"
						+ ","+"'"+sj.getText()+"'"
						+ ")";
				                             System.out.println("2");
				stmt.executeUpdate(sqlstr);				
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "ע��ɹ�");
				this.setVisible(false);
				System.out.println("ע��ɹ�");
			} catch (SQLException f) {
				System.out.println("SQLException:"+f.getLocalizedMessage());
			}
		}
		if (e.getSource()==������д) {
			zh.setText("");
			xm.setText("");
			zz.setText("");
			dh.setText("");
			zk.setText("");
			sj.setText("");
		}
	}

}
