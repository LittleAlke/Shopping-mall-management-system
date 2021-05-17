package 商场管理系统;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
 public class 注册 extends JFrame implements ActionListener,ItemListener{
private JFrame app;
 private JTextField 用户名,密码,姓名,电话;                                              
 private JButton 下一步,重新填写;
 private Dialog dialog;   
public  注册() {
	this.setTitle("现在注册");
    this.setSize(700,750);
    this.setLocation(200,140);
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    Container c=getContentPane();
    ImageIcon img=new ImageIcon("E:\\商场管理系统\\src\\商场管理系统\\注册2.jpg");
    JLabel jll=new JLabel(img);
    jll.setBounds(0, 0, img.getIconWidth(),img.getIconWidth());
    this.getLayeredPane().add(jll,new Integer(Integer.MIN_VALUE));
    ((JPanel)c).setOpaque(false);
    
    c.setLayout(new GridLayout(1,3));                    //网格布局（行，列）
    JPanel p1=new JPanel();
    p1.setOpaque(false);////////
    p1.setLayout(new GridLayout(12,1,0,10));               //存疑
    p1.add(new JLabel("注册步骤"));
    p1.add(new JLabel("一、阅读并同意协议"));
    p1.add(new JLabel("二、填写表单"));
    p1.add(new JLabel("三、完成注册"));
    c.add(p1);
    JPanel p2=new JPanel();
                                  p2.setOpaque(false);/////////
    JPanel p3=new JPanel();
                                  p3.setOpaque(false);//////////
    c.add(p2);
    c.add(p3);
    p2.setLayout(new GridLayout(12,1,0,10));
    p3.setLayout(new GridLayout(12,1,0,10));
    
    JLabel yhm=new JLabel("用户名",JLabel.CENTER);
    yhm.setFont(new Font("华文行楷", Font.PLAIN, 30));
    p2.add(yhm);
    用户名=new JTextField(10);
    用户名.setFont(new Font("宋体",Font.BOLD,30));
    用户名.setOpaque(false);
    p3.add(用户名);
    
    JLabel mm=new JLabel("密码",JLabel.CENTER);
    mm.setFont(new Font("华文行楷", Font.PLAIN, 30));
    p2.add(mm);
    密码=new JPasswordField(10);
    密码.setFont(new Font("宋体",Font.BOLD,30));
    密码.setOpaque(false);
    p3.add(密码);
    
    JLabel xm=new JLabel("姓名",JLabel.CENTER);
    xm.setFont(new Font("华文行楷", Font.PLAIN, 30));
    p2.add(xm);
    姓名=new JTextField(10);
    姓名.setFont(new Font("宋体",Font.BOLD,30));
    姓名.setOpaque(false);                                              //文本域透明
    p3.add(姓名);
    
    JLabel dh=new JLabel("电话",JLabel.CENTER);
    dh.setFont(new Font("华文行楷", Font.PLAIN, 30));
    p2.add(dh);
    电话=new JTextField(10);
    电话.setFont(new Font("宋体",Font.BOLD,30));
    电话.setOpaque(false);                                              //文本域透明
    p3.add(电话);
    
    Icon i=new ImageIcon("E:\\商场管理系统\\src\\商场管理系统\\下一步按钮.png");
    下一步=new JButton(i);
    
    下一步.setContentAreaFilled(false);                               //按钮透明
    p2.add(下一步);
    下一步.addActionListener(this);
    
    
    Icon i2=new ImageIcon("E:\\商场管理系统\\src\\商场管理系统\\重新输入按钮.png");
    重新填写=new JButton(i2);
    重新填写.setContentAreaFilled(false);                                //按钮透明
    p2.add(重新填写);
    重新填写.addActionListener(this);
    
    this.setVisible(true);
    }

public void itemStateChanged(ItemEvent e) {
}
public void actionPerformed(ActionEvent e) {
	
		if (e.getSource()==下一步) {
			Connection con;
			Statement stmt;
		    System.out.println("已准备注册");                          //测试行
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ce) {
				System.out.println("SQLException:"+ce.getLocalizedMessage());
			}
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
				stmt=con.createStatement();				                             
				String sqlstr="insert into consumer"
						+ "(账号,密码,姓名,电话)"
						+ "values("
						+ "'"+用户名.getText()+"'"
								+ ","+"'"+密码.getText()+"'"
								+ ","+"'"+姓名.getText()+"'"
								+ ","+"'"+电话.getText()+"'"
								+ ")";			                             
				stmt.executeUpdate(sqlstr);
				System.out.println("注册成功");
				stmt.close();
				con.close();
				this.setVisible(false);
				new 登录();
			} catch (SQLException f) {
				System.out.println("SQLException:"+f.getLocalizedMessage());
			}
		}

	if (e.getSource()==重新填写) {
		用户名.setText("");
		密码.setText("");
		姓名.setText("");
		电话.setText("");

	}
}
}
