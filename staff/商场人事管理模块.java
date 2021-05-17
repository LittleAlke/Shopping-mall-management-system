package 商场管理系统;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class 商场人事管理模块 extends JPanel implements ActionListener{
	
	private JButton 浏览员工,查询员工,注册员工,修改员工,注销员工;
	private JPanel p1,p2,p3;

public 商场人事管理模块() {
	this.setLayout(new BorderLayout());
	                       this.setOpaque(false);////////
	 p3=new JPanel();
	                     p3.setOpaque(false);////////                  
	                                            
	p1=new JPanel();
	                p1.setOpaque(false);////////
	 p2=new JPanel();
                    p2.setOpaque(false);////////
	                
	p3.setLayout(new GridLayout(5,1,0,55));
	
	浏览员工=new JButton("浏览员工");
	浏览员工.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
    p3.add(浏览员工);
    浏览员工.addActionListener(this);
    
    查询员工=new JButton("查询员工");
    查询员工.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
    p3.add(查询员工);
    查询员工.addActionListener(this);
    
    注册员工=new JButton("注册员工");
    注册员工.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
    p3.add(注册员工);
    注册员工.addActionListener(this);
    
    修改员工=new JButton("修改员工");
    修改员工.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
    p3.add(修改员工);
    修改员工.addActionListener(this);
    
    注销员工=new JButton("注销员工");                             //所有按钮都设置突出会导致按钮变小  
    p3.add(注销员工);
    注销员工.addActionListener(this);
    
     p1.add(p3);
    this.add(p1,"West");
    this.add(p2,"Center");
    this.setVisible(true);                                       
}

public void actionPerformed(ActionEvent e) {
	if (e.getSource()==浏览员工) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add( new 浏览员工());	              
		p2.setVisible(true);	
}
	if (e.getSource()==查询员工) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add( new 查询员工());	              
		p2.setVisible(true);	
}
	if (e.getSource()==注册员工) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add( new 注册员工());	              
		p2.setVisible(true);	
}
	if (e.getSource()==注销员工) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add(new 注销员工());	              
		p2.setVisible(true);	
}
	if (e.getSource()==修改员工) {
		p2.setVisible(false);
		p2.removeAll();	              
		p2.add(new 修改员工());	              
		p2.setVisible(true);	
}
}
}
