package 商场管理系统;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.View;


public class 查询商品 extends JPanel implements ActionListener {
	private JTextField 商品编号;
	private JPanel p0,p1;
	private int message=0;
	public   查询商品() {
		                                 this.setOpaque(false);////////
		p0=new JPanel(new GridLayout(4,1,10,30));
		                                  p0.setOpaque(false);////////
		JLabel 查询商品=new JLabel("查询商品"); 
		查询商品.setFont(new Font("华文行楷", Font.PLAIN, 30));
		p0.add(查询商品);    
		JLabel 请输入商品编号=new JLabel("请输入商品编号"); 
		请输入商品编号.setFont(new Font("华文行楷", Font.PLAIN, 30));
		p0.add(请输入商品编号);                                
		商品编号=new JTextField(10);
		商品编号.setFont(new Font("宋体",Font.BOLD,20));
		商品编号.setOpaque(false);
		p0.add(商品编号);
		JButton 查询=new JButton("查询");
		查询.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
		p0.add(查询);
		查询.addActionListener(this);
		p0.setBackground(Color.white);
		this.add(p0);
		this.setVisible(true);
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="查询") {
			Connection con;          
		    Statement stmt;          //MySQL查询数据库
		    ResultSet rs;            //光标位置移动
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");
		    }
		    catch(ClassNotFoundException f){
		    	System.out.println("SQLException:"+f.getLocalizedMessage());

		    }
		    try {
		    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
		    //建立连接，第一个root为MYSQL用户名，第二个admin为密码。
		    stmt=con.createStatement();         
		    rs=stmt.executeQuery("select * from shangpin ");    
		    while(rs.next()) {  
                String str1=rs.getString("编号");
                String str2=商品编号.getText();
                if (str1.equals(str2)) {
                	message=1;
		        String ob[][]=new String[1][5];
		    	ob[0][0]=rs.getString("编号");
		    	ob[0][1]=rs.getString("名称");
		    	ob[0][2]=rs.getString("数量");
		    	ob[0][3]=rs.getString("进价");
		    	ob[0][4]=rs.getString("售价");
		    String s[]= {"编号","名称","数量","进价","售价",};
		    JTable view=new JTable(ob,s);
		    view.setSize(500, 400);
		    view.setBackground(Color.orange);     
		    JScrollPane sPane=new JScrollPane(view);
		    sPane.setPreferredSize(new Dimension(500, 100));
		    p0.setVisible(false);
		    this.setBackground(Color.pink);
		    this.add(sPane);
		    this.setVisible(true);
		    con.close();
			break;
		    }

                else {
                	continue;
				}
                 
		    } 
		    if (message==0) {             //算法解决对话框
		    	JOptionPane.showMessageDialog(this, "你查询的编号不存在！","系统提示",JOptionPane.WARNING_MESSAGE);
		    }
		    }
		    catch (SQLException ex) {
				ex.printStackTrace();
		    	// TODO: handle exception
			}
		    
	}
}
}



