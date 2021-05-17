package 商场管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class VIP信息管理模块 extends JPanel implements ActionListener{
	
	private JButton 浏览VIP,购物记录,注册VIP,修改VIP,注销VIP;
	private JPanel p1,p2,p3;

public VIP信息管理模块() {
	this.setLayout(new BorderLayout());
	                       this.setOpaque(false);////////
	 p3=new JPanel();
	                     p3.setOpaque(false);////////                  
	                                            
	p1=new JPanel();
	                p1.setOpaque(false);////////
	 p2=new JPanel();
                    p2.setOpaque(false);////////
	                
	p3.setLayout(new GridLayout(5,1,0,55));
	
	浏览VIP=new JButton("浏览VIP");
	浏览VIP.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
    p3.add(浏览VIP);
    浏览VIP.addActionListener(this);
    
    购物记录=new JButton("购物记录");
    购物记录.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
    p3.add(购物记录);
    购物记录.addActionListener(this);
    
    注册VIP=new JButton("注册VIP");
    注册VIP.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
    p3.add(注册VIP);
    注册VIP.addActionListener(this);
    
    修改VIP=new JButton("修改VIP");
    修改VIP.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
    p3.add(修改VIP);
    修改VIP.addActionListener(this);
    
    注销VIP=new JButton("注销VIP");                             //所有按钮都设置突出会导致按钮变小  
    p3.add(注销VIP);
    注销VIP.addActionListener(this);
    
     p1.add(p3);
    this.add(p1,"West");
    this.add(p2,"Center");
    this.setVisible(true);                                       
}

public void actionPerformed(ActionEvent e) {
	if (e.getSource()==浏览VIP) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add( new 浏览VIP());	              
		p2.setVisible(true);	
}
	if (e.getSource()==购物记录) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add( new 购物记录());	              
		p2.setVisible(true);	
}
	if (e.getSource()==注册VIP) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add( new 注册VIP());	              
		p2.setVisible(true);	
}
	if (e.getSource()==修改VIP) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add(new 修改VIP());	              
		p2.setVisible(true);	
}
	if (e.getSource()==注销VIP) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add(new 注销VIP());	              
		p2.setVisible(true);	
}
}
}
