package �̳�����ϵͳ;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
 public class ע�� extends JFrame implements ActionListener,ItemListener{
private JFrame app;
 private JTextField �û���,����,����,�绰;                                              
 private JButton ��һ��,������д;
 private Dialog dialog;   
public  ע��() {
	this.setTitle("����ע��");
    this.setSize(700,750);
    this.setLocation(200,140);
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    Container c=getContentPane();
    ImageIcon img=new ImageIcon("E:\\�̳�����ϵͳ\\src\\�̳�����ϵͳ\\ע��2.jpg");
    JLabel jll=new JLabel(img);
    jll.setBounds(0, 0, img.getIconWidth(),img.getIconWidth());
    this.getLayeredPane().add(jll,new Integer(Integer.MIN_VALUE));
    ((JPanel)c).setOpaque(false);
    
    c.setLayout(new GridLayout(1,3));                    //���񲼾֣��У��У�
    JPanel p1=new JPanel();
    p1.setOpaque(false);////////
    p1.setLayout(new GridLayout(12,1,0,10));               //����
    p1.add(new JLabel("ע�Ჽ��"));
    p1.add(new JLabel("һ���Ķ���ͬ��Э��"));
    p1.add(new JLabel("������д��"));
    p1.add(new JLabel("�������ע��"));
    c.add(p1);
    JPanel p2=new JPanel();
                                  p2.setOpaque(false);/////////
    JPanel p3=new JPanel();
                                  p3.setOpaque(false);//////////
    c.add(p2);
    c.add(p3);
    p2.setLayout(new GridLayout(12,1,0,10));
    p3.setLayout(new GridLayout(12,1,0,10));
    
    JLabel yhm=new JLabel("�û���",JLabel.CENTER);
    yhm.setFont(new Font("�����п�", Font.PLAIN, 30));
    p2.add(yhm);
    �û���=new JTextField(10);
    �û���.setFont(new Font("����",Font.BOLD,30));
    �û���.setOpaque(false);
    p3.add(�û���);
    
    JLabel mm=new JLabel("����",JLabel.CENTER);
    mm.setFont(new Font("�����п�", Font.PLAIN, 30));
    p2.add(mm);
    ����=new JPasswordField(10);
    ����.setFont(new Font("����",Font.BOLD,30));
    ����.setOpaque(false);
    p3.add(����);
    
    JLabel xm=new JLabel("����",JLabel.CENTER);
    xm.setFont(new Font("�����п�", Font.PLAIN, 30));
    p2.add(xm);
    ����=new JTextField(10);
    ����.setFont(new Font("����",Font.BOLD,30));
    ����.setOpaque(false);                                              //�ı���͸��
    p3.add(����);
    
    JLabel dh=new JLabel("�绰",JLabel.CENTER);
    dh.setFont(new Font("�����п�", Font.PLAIN, 30));
    p2.add(dh);
    �绰=new JTextField(10);
    �绰.setFont(new Font("����",Font.BOLD,30));
    �绰.setOpaque(false);                                              //�ı���͸��
    p3.add(�绰);
    
    Icon i=new ImageIcon("E:\\�̳�����ϵͳ\\src\\�̳�����ϵͳ\\��һ����ť.png");
    ��һ��=new JButton(i);
    
    ��һ��.setContentAreaFilled(false);                               //��ť͸��
    p2.add(��һ��);
    ��һ��.addActionListener(this);
    
    
    Icon i2=new ImageIcon("E:\\�̳�����ϵͳ\\src\\�̳�����ϵͳ\\�������밴ť.png");
    ������д=new JButton(i2);
    ������д.setContentAreaFilled(false);                                //��ť͸��
    p2.add(������д);
    ������д.addActionListener(this);
    
    this.setVisible(true);
    }

public void itemStateChanged(ItemEvent e) {
}
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
				String sqlstr="insert into consumer"
						+ "(�˺�,����,����,�绰)"
						+ "values("
						+ "'"+�û���.getText()+"'"
								+ ","+"'"+����.getText()+"'"
								+ ","+"'"+����.getText()+"'"
								+ ","+"'"+�绰.getText()+"'"
								+ ")";			                             
				stmt.executeUpdate(sqlstr);
				System.out.println("ע��ɹ�");
				stmt.close();
				con.close();
				this.setVisible(false);
				new ��¼();
			} catch (SQLException f) {
				System.out.println("SQLException:"+f.getLocalizedMessage());
			}
		}

	if (e.getSource()==������д) {
		�û���.setText("");
		����.setText("");
		����.setText("");
		�绰.setText("");

	}
}
}
