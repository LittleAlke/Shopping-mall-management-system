package �̳�����ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class �̳����¹���ģ�� extends JPanel implements ActionListener{
	
	private JButton ���Ա��,��ѯԱ��,ע��Ա��,�޸�Ա��,ע��Ա��;
	private JPanel p1,p2,p3;

public �̳����¹���ģ��() {
	this.setLayout(new BorderLayout());
	                       this.setOpaque(false);////////
	 p3=new JPanel();
	                     p3.setOpaque(false);////////                  
	                                            
	p1=new JPanel();
	                p1.setOpaque(false);////////
	 p2=new JPanel();
                    p2.setOpaque(false);////////
	                
	p3.setLayout(new GridLayout(5,1,0,55));
	
	���Ա��=new JButton("���Ա��");
	���Ա��.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
    p3.add(���Ա��);
    ���Ա��.addActionListener(this);
    
    ��ѯԱ��=new JButton("��ѯԱ��");
    ��ѯԱ��.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
    p3.add(��ѯԱ��);
    ��ѯԱ��.addActionListener(this);
    
    ע��Ա��=new JButton("ע��Ա��");
    ע��Ա��.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
    p3.add(ע��Ա��);
    ע��Ա��.addActionListener(this);
    
    �޸�Ա��=new JButton("�޸�Ա��");
    �޸�Ա��.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
    p3.add(�޸�Ա��);
    �޸�Ա��.addActionListener(this);
    
    ע��Ա��=new JButton("ע��Ա��");                             //���а�ť������ͻ���ᵼ�°�ť��С  
    p3.add(ע��Ա��);
    ע��Ա��.addActionListener(this);
    
     p1.add(p3);
    this.add(p1,"West");
    this.add(p2,"Center");
    this.setVisible(true);                                       
}

public void actionPerformed(ActionEvent e) {
	if (e.getSource()==���Ա��) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add( new ���Ա��());	              
		p2.setVisible(true);	
}
	if (e.getSource()==��ѯԱ��) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add( new ��ѯԱ��());	              
		p2.setVisible(true);	
}
	if (e.getSource()==ע��Ա��) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add( new ע��Ա��());	              
		p2.setVisible(true);	
}
	if (e.getSource()==ע��Ա��) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add(new ע��Ա��());	              
		p2.setVisible(true);	
}
	if (e.getSource()==�޸�Ա��) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add(new �޸�Ա��());	              
		p2.setVisible(true);	
}
}
}
