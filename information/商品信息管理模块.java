package �̳�����ϵͳ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class ��Ʒ��Ϣ����ģ�� extends JPanel implements ActionListener,ItemListener{	
	JPanel p1,p2,k0;
	
      public ��Ʒ��Ϣ����ģ��() {
    	  this.setLayout(new BorderLayout());
    	                                           this.setOpaque(false);////////
           k0=new JPanel();
                                                   k0.setOpaque(false);////////
           p1=new JPanel();
                                                     p1.setOpaque(false);////////
           p2=new JPanel();
                                                     p2.setOpaque(false);////////
           k0.setLayout(new GridLayout(5, 1,0,55));
           JButton �����Ʒ = new JButton("�����Ʒ");
           �����Ʒ.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
           k0.add(�����Ʒ);
           �����Ʒ.addActionListener(this);
           
           JButton ��ѯ��Ʒ = new JButton("��ѯ��Ʒ");
           ��ѯ��Ʒ.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
           k0.add(��ѯ��Ʒ);
           ��ѯ��Ʒ.addActionListener(this);
         
           JButton ɾ����Ʒ = new JButton("ɾ����Ʒ");
           ɾ����Ʒ.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
           k0.add(ɾ����Ʒ);
           ɾ����Ʒ.addActionListener(this);
           
           JButton ������Ʒ = new JButton("������Ʒ");
           ������Ʒ.setBorder(BorderFactory.createRaisedBevelBorder());   //��ť͹����
           k0.add(������Ʒ);
           ������Ʒ.addActionListener(this);
           
           JButton ������Ʒ = new JButton("������Ʒ");          
           k0.add(������Ʒ);
           k0.setBackground(Color.pink);
           ������Ʒ.addActionListener(this);
           
           p1.add(k0);
           this.add(p1,"West");
           this.add(p2,"Center");
           p1.setBackground(Color.pink);
           p2.setBackground(Color.pink);
           this.setVisible(true);
      }

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="�����Ʒ") {
			p2.setVisible(false);
			p2.removeAll();
			p2.add(new �����Ʒ());
			p2.setVisible(true);
		}
		
		if(e.getActionCommand()=="��ѯ��Ʒ") {
			p2.setVisible(false);
			p2.removeAll();
			p2.add(new ��ѯ��Ʒ());
			p2.setVisible(true);
		}
		
		if(e.getActionCommand()=="ɾ����Ʒ") {
			p2.setVisible(false);
			p2.removeAll();
			p2.add(new ɾ����Ʒ());
			p2.setVisible(true);
		}
		
		if(e.getActionCommand()=="������Ʒ") {
			p2.setVisible(false);
			p2.removeAll();
			p2.add(new ������Ʒ());
			p2.setVisible(true);
		}
		
		if(e.getActionCommand()=="������Ʒ") {
			p2.setVisible(false);
			p2.removeAll();
			p2.add(new ������Ʒ());
			p2.setVisible(true);
		}
	}
}

