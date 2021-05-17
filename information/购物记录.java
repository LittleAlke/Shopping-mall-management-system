package 商场管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class 购物记录 extends JPanel  implements ActionListener{
	private JButton 查询;
	private JPanel p1;
	private JTextField 查询账号;
	int message=0;
public 购物记录() {
	                                              this.setOpaque(false);////////
	 p1=new JPanel(new GridLayout(3,1,0,50));
	                                             p1.setOpaque(false);////////
	JLabel 查询提示=new JLabel("请输入要查询VIP的账号");
	查询提示.setFont(new Font("华文行楷", Font.PLAIN, 30));
	p1.add(查询提示);
	
	查询账号=new JTextField();
	查询账号.setFont(new Font("宋体",Font.BOLD,20));
	查询账号.setOpaque(false);
	p1.add(查询账号);
	
	查询=new JButton("查询");
	查询.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
	p1.add(查询);
	查询.addActionListener(this);

	this.add(p1);
	this.setVisible(true);
	                             System.out.println("窗口已创建");
	
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==查询) {		
		Connection con;  
		Statement stmt;   
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException f) {
			System.out.println("SQLException:"+f.getLocalizedMessage());
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
			stmt=con.createStatement();                                          
			rs=stmt.executeQuery("select * from shopping ");         //查询有问题
			
			while(rs.next()) {
					String st1=查询账号.getText();
			        //String st2=rs.getString("工号");
				if(st1.equals(rs.getString("账号"))) {
					message=1;
			    Object ob[][]=new Object[1][5];		
			       ob[0][0]=rs.getString("账号");
			       ob[0][1]=rs.getString("姓名");
			       ob[0][2]=rs.getString("消费总金额");
			       ob[0][3]=rs.getString("消费总次数");
			       ob[0][4]=rs.getString("卡内余额");		
			String s1[]= {"账号","姓名","消费总金额","消费总次数","卡内余额"};
			JTable table1=new JTable(ob,s1);
			this.setVisible(false);
			table1.setSize(500, 500);
			     System.out.println("已创建表");
			  JScrollPane jsp1=new JScrollPane(table1);
			   jsp1.setPreferredSize(new Dimension(500,100)); 
			   p1.setVisible(false);
				this.add(jsp1);
				this.setVisible(true);
				stmt.close();
				con.close();
				break;
				}
				else {
			     continue;
				}
			}
			if(message==0) {
				JOptionPane.showMessageDialog(this, "您输入的账号或密码有误，或账号不存在，请重新输入！","系统提示",
						JOptionPane.ERROR_MESSAGE);			
			}				
			}catch (SQLException ex) {
				ex.printStackTrace();
			}
	}
	
}
}
