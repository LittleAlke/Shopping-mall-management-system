package �̳�����ϵͳ;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.crypto.NullCipher;
import javax.swing.*;
public class �������� extends JPanel  implements ActionListener{
   private JLabel �˺�,����,����,�绰;
   private JTextField �˺�����, ��������,��������,�绰����;
   private JPanel p1,p2,pz;
   public ��������() {
	   this.setLayout(new GridLayout(1,2,100,0));
	                                                this.setOpaque(false);////////
	   p1=new JPanel(new GridLayout(10,1,0,20));
	                                                p1.setOpaque(false);//////// 
	   p2=new JPanel(new GridLayout(10,1,0,20));
	                                               p2.setOpaque(false);////////
	   �˺�=new JLabel("�˺�",JLabel.CENTER);
	   �˺�.setFont(new java.awt.Font("�����п�", 1, 30));
	   p1.add(�˺�);
	   
	   ����=new JLabel("����",JLabel.CENTER);
	   ���� .setFont(new java.awt.Font("�����п�", 1, 30));
	   p1.add(����);
	   
	   ����=new JLabel("����",JLabel.CENTER);
	   ���� .setFont(new java.awt.Font("�����п�", 1, 30));
	   p1.add(����);
	   
	   �绰=new JLabel("�绰",JLabel.CENTER);
	   �绰.setFont(new java.awt.Font("�����п�", 1, 30));
	   p1.add(�绰);
	   
	   
	    Connection con;  //
		Statement stmt;   //mysql���ݿ�
		ResultSet rs; 
		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				System.out.println("error"+ex);
			}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alke?userUnicode=true&characterEncoding=utf-8","root","admin");
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//String s=��¼.st1;
			rs=stmt.executeQuery("select * from consumer where consumer.�˺�="+��¼.ID);
			                                              System.out.println("��select");
	         while(rs.next()) {
			        String st1=rs.getString("�˺�");                                  //ֻ����ʾ��һ�е�����
			        String st2=rs.getString("����");
			        String st3=rs.getString("����");
			        String st4=rs.getString("�绰");
			      //  String st4=new ��¼.�û���.getText();
			                                              System.out.println("�ѻ�ȡ��Ϣ");
			                   
			       �˺����� =new JTextField(st1);
			       �˺�����.setBackground(Color.orange);
			       �˺�����.setFont(new java.awt.Font("����", 1, 20));
			       p2.add(�˺�����);
			       
			       ��������=new JTextField(st2);
			       ��������.setBackground(Color.orange);
			       ��������.setFont(new java.awt.Font("����", 1, 20));
			       p2.add(��������);
			       
			       ��������=new JTextField(st3);
			       ��������.setBackground(Color.orange);
			       ��������.setFont(new java.awt.Font("����", 1, 20));
			       p2.add(��������);
			       
			       �绰����=new JTextField(st4);
			       �绰����.setBackground(Color.orange);
			       �绰����.setFont(new java.awt.Font("����", 1, 20));
			       p2.add(�绰����);
			      
			    rs.close();
				stmt.close();
				con.close();
				p1.setBackground(Color.GRAY);
			   this.add(p1);
			   p2.setBackground(Color.GRAY);
			   this.add(p2);
			   this.setBackground(Color.GRAY);
			  this.setVisible(true);
			   break;
			                                     }
					 
   }catch (SQLException f) {
			System.out.println(f);
		}
	}

	/*public static void main(String[] args) {
		new ��������();
	}*/
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

	
}
