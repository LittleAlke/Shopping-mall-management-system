package �̳�����ϵͳ;

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

public class ���ȫ�� extends JPanel implements ActionListener {

	public ���ȫ�� (){
		this.setOpaque(false);////////
		Connection con;          
	    Statement stmt;          //MySQL��ѯ���ݿ�
	    ResultSet rs;            //���λ���ƶ�
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    }
	    catch(ClassNotFoundException f){
	    	System.out.println("SQLException:"+f.getLocalizedMessage());

	    }
	    try {
	    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
	    //�������ӣ���һ��rootΪMYSQL�û������ڶ���adminΪ���롣
	    stmt=con.createStatement();         
	    rs=stmt.executeQuery("select * from �ܶ�");
	    rs.last();                   //*������ƶ������һ��
	    int k=rs.getRow();           //�������
	    if (k==0) {
			JOptionPane.showMessageDialog(this, "���ѯ�ı����ڣ�","ϵͳ��ʾ",JOptionPane.WARNING_MESSAGE);
		}
	    rs.beforeFirst();        //���ص���һ��
	    String ob[][]=new String[k][7];
	    for(int i=0;i<k&&rs.next();i++) {
	    	ob[i][0]=rs.getString("����");
	    	ob[i][1]=rs.getString("�����ܶ�");
	    	ob[i][2]=rs.getString("�����ܶ�");
	    	ob[i][3]=rs.getString("����");
	    }
	    String s[]= {"����","�����ܶ�","�����ܶ�","����"};
	    JTable view=new JTable(ob,s);
	    view.setBackground(Color.orange);
	    view.setSize(500,400);
	    JScrollPane sPane=new JScrollPane(view);          //�����ӿڣ���ѡ�������ͱ����ר������
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