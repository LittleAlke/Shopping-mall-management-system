package 商场管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class 登录  extends JFrame implements ActionListener {
	private JFrame app;
	private JButton 登录,清除,注册,重新输入,退出;
	private JLabel 用户姓名,用户口令;
	private JTextField 用户名;
	private JPasswordField 用户密码;
	private JDialog 提示;  //对话框
	private JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
	private int massage=0;
	public static String ID,name;
	
 public 登录 () {	
	 
	 Container c=getContentPane();
	    ImageIcon img=new ImageIcon("E:\\商场管理系统\\src\\商场管理系统\\注册2.jpg");
	    JLabel jll=new JLabel(img);
	    jll.setBounds(0, 0, img.getIconWidth(),img.getIconWidth()-500);
	    this.getLayeredPane().add(jll,new Integer(Integer.MIN_VALUE));
	    ((JPanel)c).setOpaque(false);
	 
	 
     用户姓名=new JLabel("用户账号");           //new一个标签      
     用户名=new JTextField(10);      //长度为10的文本域
     用户名.setOpaque(false); 
    
     用户口令=new JLabel("用户口令");   
     用户密码=new JPasswordField(10);
     用户密码.setOpaque(false);
     
     登录=new JButton("登录");  
     登录.addActionListener(this);  //监听器
     清除=new JButton("清除"); 
     清除.addActionListener(this);
     
     提示=new JDialog(); //对话框
     提示.setTitle("系统提示");
     提示.setSize(340,80);
     提示.setLocation(this.getX()+100, this.getY()+100);
     提示.setLayout(new FlowLayout());
     
     重新输入=new JButton("重新输入");
     重新输入.addActionListener(this);
     提示.add(重新输入);
     
     退出=new JButton("退出");
     提示.add(退出);
     退出.addActionListener(this);
        
     注册=new JButton("注册");  
     注册.addActionListener(this);
     
     p1=new JPanel();
     p1.setOpaque(false);
     p2=new JPanel();
     p2.setOpaque(false);
     p3=new JPanel();
     p3.setOpaque(false);
     p4=new JPanel();
     p4.setOpaque(false);
     p5=new JPanel();
     p5.setOpaque(false);
     p6=new JPanel();
     p6.setOpaque(false);
     p7=new JPanel();
     p7.setOpaque(false);
     p8=new JPanel();
     p8.setOpaque(false);
     
     this.setLayout(new GridLayout(10,1));
     
     p4.add(用户姓名);
     p4.add(用户名);
     p5.add(用户口令);
     p5.add(用户密码);
     p6.add(登录);
     p6.add(清除);
     p7.add(new JLabel("如果你还没有注册，请注册"));
     p8.add(注册);
     
     this.add(p1);
     this.add(p2);
     this.add(p3);
     this.add(p4);
     this.add(p5);
     this.add(p6);
     this.add(p7);
     this.add(p8);
     
     this.setTitle("登录");
     this.setSize(626,461);
     this.setLocation(360,240);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setVisible(true);
 }

//@Override
public void actionPerformed(ActionEvent e) {      //行动执行
	if(e.getSource()==登录) {
		Connection con;  //
		Statement stmt;   //mysql数据库
		ResultSet rs;   //结果集
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException f) {
			System.out.println("SQLException:"+f.getLocalizedMessage());
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
			stmt=con.createStatement();                                          
			rs=stmt.executeQuery("select * from consumer");
			while(rs.next()) {
				 String st1=rs.getString("账号");
				String st2=rs.getString("密码");
				ID=st1;
				name=rs.getString("姓名");
				char[] ps=用户密码.getPassword();
				String st3="";
				for (int i = 0; i < ps.length; i++) 
					st3+=ps[i];
					if ((用户名.getText().equals(st1))&&(st3.equals(st2))) {
						massage=1;
						new 商场信息管理系统();
						this.setVisible(false);
						rs.close();
						stmt.close();
						con.close();
						break;
					}
				}
				if (massage==0) {
					JOptionPane.showMessageDialog(app, "您输入的账号或密码有误，或账号不存在，请重新输入！","系统提示",
							JOptionPane.ERROR_MESSAGE);
				}
				con.close();
			}catch (SQLException f) {
		     System.out.println(f);
		 }
	}
	if (e.getSource()==清除) {
		//JOptionPane.showMessageDialog(app, "对不起！两次密码输入不同，请重新输入！","系统提示",JOptionPane.
         //       INFORMATION_MESSAGE);
		提示.setVisible(true);
	}
	if(e.getSource()==退出)
		System.exit(0);
	if (e.getSource()==重新输入) {
		用户名.setText("");
		用户密码.setText("");
		提示.setVisible(false);
	}
	if (e.getSource()==注册) {
		new 注册();
		this.setVisible(false);
	}
}
public static void main(String[] args) {
	new 登录();
}

}
