package �̳�����ϵͳ;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
public class ע��Ա�� extends JPanel implements ActionListener{
   private JButton ��һ��,������д;
   private JLabel ����,����,�Ա�,����,����,ְ��,��н;
   private JComboBox bm,zw;
   private JTextField gh,xm,nl,yx;
   private JRadioButton ��,Ů;
   private JPanel p1,p2,p3;
public  ע��Ա��() {
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
		
		 ����=new JLabel("����",JLabel.CENTER);
		 ����.setFont(new Font("�����п�", Font.PLAIN, 30));
		 p2.add(����);
		  gh=new JTextField(10);
		  gh.setFont(new Font("����",Font.BOLD,20));
		  gh.setOpaque(false);
		  p3.add(gh);
		  
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
			
			����=new JLabel("����",JLabel.CENTER);
			 ����.setFont(new Font("�����п�", Font.PLAIN, 30));
			 p2.add(����);
			  nl=new JTextField(10);
			  nl.setFont(new Font("����",Font.BOLD,20));
			  nl.setOpaque(false);
			  p3.add(nl);		
				 
	        ����=new JLabel("����",JLabel.CENTER);
		    ����.setFont(new Font("�����п�", Font.PLAIN, 30));
		    p2.add(����);
			 Object bumen[]= {"���۲�","����","���ﲿ"};
			 bm=new JComboBox(bumen);
			  p3.add(bm);
		  
		       ְ��=new JLabel("ְ��",JLabel.CENTER);
			   ְ��.setFont(new Font("�����п�", Font.PLAIN, 30));
			   p2.add(ְ��);
			     Object zhiwu[]= {"����","����","�ܼ�"};
				 zw=new JComboBox(zhiwu);
				  p3.add(zw);	  
		  
			     ��н=new JLabel("��н",JLabel.CENTER);
				 ��н.setFont(new Font("�����п�", Font.PLAIN, 30));
				 p2.add(��н);
				  yx=new JTextField(10);
				yx.setFont(new Font("����",Font.BOLD,20));
				  p3.add(yx);
				  
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
				String sqlstr="insert into staff"
						+ "(����,����,�Ա�,����,����,ְ��,��н)"
						+ "values("
						+ "'"+gh.getText()+"'"
						+ ","+"'"+xm.getText()+"'"
						+ ","+"'"+XB+"'"
						+ ","+"'"+nl.getText()+"'"
						+ ","+"'"+BM+"'"
						+ ","+"'"+ZW+"'"
						+ ","+"'"+yx.getText()+"'"
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
			gh.setText("");
			xm.setText("");
			nl.setText("");
			yx.setText("");
		}
	}

}
