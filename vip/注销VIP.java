package 商场管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class 注销VIP extends JPanel implements ActionListener {
	 private JDialog 提示;
	 private JButton 确认,取消,删除;
	 private JLabel 提示信息;
	 private JTextField 账号;
 public 注销VIP() {
	                                              this.setOpaque(false);////////
	 this.setLayout(new FlowLayout());
	 提示信息=new JLabel("请输入要删除的VIP的账号");
	 提示信息.setFont(new Font("华文行楷", Font.PLAIN, 30));
	 this.add(提示信息);
	 
	 账号=new JTextField(10);
	 账号.setFont(new Font("宋体",Font.BOLD,20));
	 账号.setOpaque(false);
	 this.add(账号);
	 
	 删除=new JButton("删除");
	 this.add(删除);
	 删除.addActionListener(this);
	 
	 提示=new JDialog(); //对话框
     提示.setTitle("确认删除？");
     提示.setSize(340,80);
     提示.setLocation(this.getX()+200, this.getY()+200);
     提示.setLayout(new FlowLayout());
	
	 确认=new JButton("确认");
     提示.add(确认);
     确认.addActionListener(this);
     
     取消=new JButton("取消");
     提示.add(取消);
     取消.addActionListener(this);
	 
	 this.setVisible(true);	 
}


public void actionPerformed(ActionEvent e) {
	if (e.getSource()==删除) {
		提示.setVisible(true);
		提示.setLocationRelativeTo(null);
	}
	if(e.getSource()==取消)
		{
		提示.setVisible(false);
		}
	if (e.getSource()==确认) {
		提示.setVisible(false);
		
        System.out.println("准备开始");
     Connection con;  
     Statement stmt;   
     ResultSet rs;
    try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException f) {
            System.out.println("SQLException:"+f.getLocalizedMessage());
         }try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin"); 		
                     System.out.println("数据库连接成功"); 		
            stmt=con.createStatement();
            String st1=账号.getText();
            String sqlstr=" delete from vip where 账号='"+st1+"'";			
            stmt.executeUpdate(sqlstr);	
            System.out.println("删除成功");
             stmt.close();
             con.close(); 
           System.out.println("注销完成");
 } catch (Exception e1) {

}			
		提示.setVisible(false);
}
}
}
