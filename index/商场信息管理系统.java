package �̳�����ϵͳ;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.crypto.NullCipher;
import javax.swing.*;
public class �̳���Ϣ����ϵͳ implements ActionListener{
  private JButton ע���û�,�˳�ϵͳ,ϵͳ����,����,��������,��Ʒ��Ϣ����ģ��,VIP��Ϣ����ģ��,�̳����¹���ģ��,�̳����۹���ģ��,ȷ��,ȡ��;
  private JLabel �˺�,����;
  private JTextField �˺�����,��������;
  private JDialog ��ʾ;
	private JPanel p4,p5;
	public �̳���Ϣ����ϵͳ() {
	  JFrame app=new JFrame("ϵͳ������");	  
	  Container c=app.getContentPane(); 
	    ImageIcon img=new ImageIcon("E:\\�̳�����ϵͳ\\src\\�̳�����ϵͳ\\��3.jpg");
	    JLabel jll=new JLabel(img);
	    jll.setBounds(0, 0, img.getIconWidth(),img.getIconWidth()-1100);
	    app.getLayeredPane().add(jll,new Integer(Integer.MIN_VALUE));
	    ((JPanel)c).setOpaque(false);
	    
	  c.setLayout(new BorderLayout());
	  JPanel psz=new JPanel(new GridLayout(3,1,0,10));//0,10
	  psz.setOpaque(false);////////
	  c.add(psz,BorderLayout.NORTH);
	  
	  JPanel p1=new JPanel(new GridLayout(1,2));            //��һ�п�ʼ
	  p1.setOpaque(false);////////
	  JPanel p1_1=new JPanel(new GridLayout(1,4));//10,0
	  p1_1.setOpaque(false);/////////
	  ע���û�=new JButton("ע���û�");
	  ע���û�.setContentAreaFilled(false);//+++++
	  ע���û�.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����	  
	  ע���û�.setBorderPainted(false);
	  p1_1.add(ע���û�);
	  ע���û�.addActionListener(this);
	  
	  �˳�ϵͳ=new JButton("�˳�ϵͳ");
	  �˳�ϵͳ.setContentAreaFilled(false);//++++++
	  �˳�ϵͳ.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����	  
	  �˳�ϵͳ.setBorderPainted(false);
	  p1_1.add(�˳�ϵͳ);
	  �˳�ϵͳ.addActionListener(this);
	  
	  ϵͳ����=new JButton("ϵͳ����");
	  ϵͳ����.setContentAreaFilled(false);//+++++
	  ϵͳ����.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����	  
	  ϵͳ����.setBorderPainted(false);
	  p1_1.add(ϵͳ����);
	  ϵͳ����.addActionListener(this);
	  
	  ����=new JButton("����");
	  ����.setContentAreaFilled(false);//++++++
	  ����.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����  
	  ����.setBorderPainted(false);
	  p1_1.add(����);
	  ����.addActionListener(this);
	  
	  p1.add(p1_1);
	  JPanel p1_2=new JPanel();
	  p1_2.setOpaque(false);////////
	  p1.add(p1_2);
	  psz.add(p1);
	  
	  JPanel p2=new JPanel(new GridLayout(1,2));          //�ڶ��п�ʼ150,0
	  p2.setOpaque(false);////////
	  JPanel p2_1=new JPanel(new GridLayout(1,4));
	  p2_1.setOpaque(false);////////
	  JPanel p2_2=new JPanel(new GridLayout(1,3));
	  p2_2.setOpaque(false);////////
	  �˺�=new JLabel("�˺�:",JLabel.CENTER);
	  p2_1.add(�˺�);
	  
	  �˺�����=new JTextField(��¼.ID,JTextField.CENTER); 
	   �˺�����.setFont(new Font("����",Font.BOLD,20));
	                                                     �˺�����.setOpaque(false);//-------
	  p2_1.add(�˺�����);
	 
	  ����=new JLabel("����:",JLabel.CENTER);
	  p2_1.add(����);
	  
	  ��������=new JTextField(��¼.name,JTextField.CENTER);              
	  ��������.setFont(new Font("����",Font.BOLD,20));
	                                                    ��������.setOpaque(false);//-----
	  p2_1.add(��������);
	  p2.add(p2_1);
	  
	  JLabel j1 = new JLabel("  ");
	  p2_2.add(j1);
	  
	  ��������=new JButton("��������");
	  ��������.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
	  ��������.setContentAreaFilled(false);                  //��ť͸��
	  //��������.setBorder(BorderFactory.createRaisedBevelBorder());
	  �������� .setFont(new java.awt.Font("����", 1, 18));
	  ��������.setBackground(Color.white);
	  p2_2.add(��������);
	  ��������.addActionListener(this);
	  JLabel j2 = new JLabel("  ");
	  p2_2.add(j2);
	  
	  p2.add(p2_2);
	  psz.add(p2);
	  
	  JPanel p3=new JPanel(new GridLayout(1,4,10,0));    //�����п�ʼ
	  p3.setOpaque(false);////////
	  ��Ʒ��Ϣ����ģ��=new JButton("��Ʒ��Ϣ����ģ��");
	  ��Ʒ��Ϣ����ģ�� .setContentAreaFilled(false);
	  ��Ʒ��Ϣ����ģ��.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
	  //��Ʒ��Ϣ����ģ��.setBorderPainted(false);                 //��ťȥ���߿�
	  p3.add(��Ʒ��Ϣ����ģ��);
	  ��Ʒ��Ϣ����ģ��.addActionListener(this);
	  
	  VIP��Ϣ����ģ��=new JButton("VIP��Ϣ����ģ��");
	  VIP��Ϣ����ģ�� .setContentAreaFilled(false);
	  VIP��Ϣ����ģ��.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
	  //VIP��Ϣ����ģ��.setBorder(BorderFactory.createLoweredBevelBorder());
	  p3.add(VIP��Ϣ����ģ��);
	  VIP��Ϣ����ģ��.addActionListener(this);                          
	  
	  �̳����¹���ģ��=new JButton("�̳����¹���ģ��");
	  �̳����¹���ģ�� .setContentAreaFilled(false);
	  �̳����¹���ģ��.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
	  p3.add(�̳����¹���ģ��);
	  �̳����¹���ģ��.addActionListener(this);
	  
	  �̳����۹���ģ��=new JButton("�̳����۹���ģ��");
	  �̳����۹���ģ��.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
	  �̳����۹���ģ�� .setContentAreaFilled(false);                  //��ť͸��
	  p3.add(�̳����۹���ģ��);
	  �̳����۹���ģ��.addActionListener(this);
	  psz.add(p3);

	  p4=new JPanel(new BorderLayout());
	  p4.setOpaque(false);////////
	  p4.setBackground(Color.GRAY);
	  c.add(p4,BorderLayout.CENTER);
	  
	 // p5=new JPanel();
	 // p5.setBackground(Color.GREEN);
	 // c.add(p5,BorderLayout.WEST);
	  ��ʾ=new JDialog(); //�Ի���
	     ��ʾ.setTitle("ϵͳ��ʾ");
	     ��ʾ.setSize(340,80);
	     ��ʾ.setLocation(app.getX()+200, app.getY()+200);
	     ��ʾ.setLayout(new FlowLayout());
		
		 ȷ��=new JButton("ȷ��");
	     ��ʾ.add(ȷ��);
	     ȷ��.addActionListener(this);
	     
	     ȡ��=new JButton("ȡ��");
	     ��ʾ.add(ȡ��);
	     ȡ��.addActionListener(this);	  	  
	  
	  JPanel pxz=new JPanel(new GridLayout(1,1));
	  pxz.setOpaque(false);////////
	  pxz.setBackground(Color.LIGHT_GRAY);
	  c.add(pxz,BorderLayout.SOUTH);
	  pxz.add(new Label("                 ֣���Ṥҵ��ѧ",JLabel.CENTER));
	  pxz.add(new Label("              ���ѧԺ",JLabel.CENTER));
	  pxz.add(new Label("              ����Ф����",JLabel.CENTER));
	  
	  app.setSize(1200, 800);
	  app.setLocationRelativeTo(null);
	  app.setVisible(true);
	
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==ע���û�) {
			��ʾ.setVisible(true);
		}
		if(e.getSource()==ȡ��)
			{
			System.exit(0);
			}
		if (e.getSource()==ȷ��) {
			new ע���û�();
			��ʾ.setVisible(false);
			System.out.println("�ѵ���ע���û�����");			
			System.exit(0);							
		}
		if (e.getSource()==��Ʒ��Ϣ����ģ��) {
			p4.setVisible(false);
			p4.removeAll();			              
		    p4.add(new ��Ʒ��Ϣ����ģ��());		           
			p4.setVisible(true);
		}
		if (e.getSource()==��������) {
			p4.setVisible(false);
			p4.removeAll();			             
			p4.add(new ��������());			         
			p4.setVisible(true);
		}
		if (e.getSource()==�˳�ϵͳ) {			
			JOptionPane.showConfirmDialog(new JFrame().getContentPane(), 
					"�Ƿ񱣴��Ѳ������ݣ�", "ϵͳ��Ϣ",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
		   System.exit(0);
		}
		if (e.getSource()==�̳����¹���ģ��) {
			p4.setVisible(false);
			p4.removeAll();			            
			p4.add(new �̳����¹���ģ��(),"Center");			            
			p4.setVisible(true);
		}
		if (e.getSource()==VIP��Ϣ����ģ��) {
			p4.setVisible(false);
			p4.removeAll();			              
			p4.add(new VIP��Ϣ����ģ��(),"Center");			             
			p4.setVisible(true);
		}
		if (e.getSource()==�̳����۹���ģ��) {
			p4.setVisible(false);
			p4.removeAll();			              
			p4.add(new �̳����۹���ģ��(),"Center");			             
			p4.setVisible(true);
		}
		if (e.getSource()==����) {
	    try {
        
        //Runtime.getRuntime().exec("C:/Program Files/Internet Explorer/IEXPLORE.exe��http://www.baidu.com"); ��//����·��
        Runtime.getRuntime().exec("cmd   /c   start   https://zhidao.baidu.com/question/43498188.html");
                     
                } catch (Exception ex) {
                 System.out.println("error");
                 ex.printStackTrace();
                }		
		}
		if (e.getSource()==ϵͳ����) {
		    try {
	        
	        //Runtime.getRuntime().exec("C:/Program Files/Internet Explorer/IEXPLORE.exe��http://www.baidu.com"); ��//����·��
	        Runtime.getRuntime().exec("cmd   /c   start   E:\\���ݿ�");
	                     
	                } catch (Exception ex) {
	                 System.out.println("error");
	                 ex.printStackTrace();
	               }				
		}
 }

	private static void setVisible(boolean b) {
		// TODO Auto-generated method stub	
	}
  
	

	
	
}
