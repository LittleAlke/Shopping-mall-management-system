package �̳�����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class ע��VIP extends JPanel implements ActionListener {
	 private JDialog ��ʾ;
	 private JButton ȷ��,ȡ��,ɾ��;
	 private JLabel ��ʾ��Ϣ;
	 private JTextField �˺�;
 public ע��VIP() {
	                                              this.setOpaque(false);////////
	 this.setLayout(new FlowLayout());
	 ��ʾ��Ϣ=new JLabel("������Ҫɾ����VIP���˺�");
	 ��ʾ��Ϣ.setFont(new Font("�����п�", Font.PLAIN, 30));
	 this.add(��ʾ��Ϣ);
	 
	 �˺�=new JTextField(10);
	 �˺�.setFont(new Font("����",Font.BOLD,20));
	 �˺�.setOpaque(false);
	 this.add(�˺�);
	 
	 ɾ��=new JButton("ɾ��");
	 this.add(ɾ��);
	 ɾ��.addActionListener(this);
	 
	 ��ʾ=new JDialog(); //�Ի���
     ��ʾ.setTitle("ȷ��ɾ����");
     ��ʾ.setSize(340,80);
     ��ʾ.setLocation(this.getX()+200, this.getY()+200);
     ��ʾ.setLayout(new FlowLayout());
	
	 ȷ��=new JButton("ȷ��");
     ��ʾ.add(ȷ��);
     ȷ��.addActionListener(this);
     
     ȡ��=new JButton("ȡ��");
     ��ʾ.add(ȡ��);
     ȡ��.addActionListener(this);
	 
	 this.setVisible(true);	 
}


public void actionPerformed(ActionEvent e) {
	if (e.getSource()==ɾ��) {
		��ʾ.setVisible(true);
		��ʾ.setLocationRelativeTo(null);
	}
	if(e.getSource()==ȡ��)
		{
		��ʾ.setVisible(false);
		}
	if (e.getSource()==ȷ��) {
		��ʾ.setVisible(false);
		
        System.out.println("׼����ʼ");
     Connection con;  
     Statement stmt;   
     ResultSet rs;
    try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException f) {
            System.out.println("SQLException:"+f.getLocalizedMessage());
         }try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin"); 		
                     System.out.println("���ݿ����ӳɹ�"); 		
            stmt=con.createStatement();
            String st1=�˺�.getText();
            String sqlstr=" delete from vip where �˺�='"+st1+"'";			
            stmt.executeUpdate(sqlstr);	
            System.out.println("ɾ���ɹ�");
             stmt.close();
             con.close(); 
           System.out.println("ע�����");
 } catch (Exception e1) {

}			
		��ʾ.setVisible(false);
}
}
}
