package 商场管理系统;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.accessibility.AccessibleAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class 浏览全部 extends JPanel implements ActionListener {

	public 浏览全部 (){
		this.setOpaque(false);////////
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
	    rs=stmt.executeQuery("select * from 总额");
	    rs.last();                   //*将光标移动到最后一行
	    int k=rs.getRow();           //获得行数
	    if (k==0) {
			JOptionPane.showMessageDialog(this, "你查询的表不存在！","系统提示",JOptionPane.WARNING_MESSAGE);
		}
	    rs.beforeFirst();        //光标回到第一行
	    String ob[][]=new String[k][7];
	    for(int i=0;i<k&&rs.next();i++) {
	    	ob[i][0]=rs.getString("日期");
	    	ob[i][1]=rs.getString("进价总额");
	    	ob[i][2]=rs.getString("销售总额");
	    	ob[i][3]=rs.getString("利润");
	    }
	    String s[]= {"日期","进价总额","销售总额","利润"};
	    JTable view=new JTable(ob,s);
	    view.setBackground(Color.orange);
	    view.setSize(500,400);
	    JScrollPane sPane=new JScrollPane(view);          //管理视口，可选滚动条和标题的专用容器
	    sPane.setPreferredSize(new Dimension(500, 400));
	     this.add(sPane);
	     this.setBackground(Color.pink);
	     this.setVisible(true);
	     con.close();
	    }
	    catch (SQLException ex) {
			ex.printStackTrace();
	    	// TODO: handle exception
		}
	    
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}