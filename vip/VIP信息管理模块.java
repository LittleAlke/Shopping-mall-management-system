package �̳�����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class VIP��Ϣ����ģ�� extends JPanel implements ActionListener{
	
	private JButton ���VIP,�����¼,ע��VIP,�޸�VIP,ע��VIP;
	private JPanel p1,p2,p3;

public VIP��Ϣ����ģ��() {
	this.setLayout(new BorderLayout());
	                       this.setOpaque(false);////////
	 p3=new JPanel();
	                     p3.setOpaque(false);////////                  
	                                            
	p1=new JPanel();
	                p1.setOpaque(false);////////
	 p2=new JPanel();
                    p2.setOpaque(false);////////
	                
	p3.setLayout(new GridLayout(5,1,0,55));
	
	���VIP=new JButton("���VIP");
	���VIP.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
    p3.add(���VIP);
    ���VIP.addActionListener(this);
    
    �����¼=new JButton("�����¼");
    �����¼.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
    p3.add(�����¼);
    �����¼.addActionListener(this);
    
    ע��VIP=new JButton("ע��VIP");
    ע��VIP.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
    p3.add(ע��VIP);
    ע��VIP.addActionListener(this);
    
    �޸�VIP=new JButton("�޸�VIP");
    �޸�VIP.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
    p3.add(�޸�VIP);
    �޸�VIP.addActionListener(this);
    
    ע��VIP=new JButton("ע��VIP");                             //���а�ť������ͻ���ᵼ�°�ť��С  
    p3.add(ע��VIP);
    ע��VIP.addActionListener(this);
    
     p1.add(p3);
    this.add(p1,"West");
    this.add(p2,"Center");
    this.setVisible(true);                                       
}

public void actionPerformed(ActionEvent e) {
	if (e.getSource()==���VIP) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add( new ���VIP());	              
		p2.setVisible(true);	
}
	if (e.getSource()==�����¼) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add( new �����¼());	              
		p2.setVisible(true);	
}
	if (e.getSource()==ע��VIP) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add( new ע��VIP());	              
		p2.setVisible(true);	
}
	if (e.getSource()==�޸�VIP) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add(new �޸�VIP());	              
		p2.setVisible(true);	
}
	if (e.getSource()==ע��VIP) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add(new ע��VIP());	              
		p2.setVisible(true);	
}
}
}
