package 商场管理系统;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class 商场销售管理模块 extends JPanel implements ActionListener,ItemListener{	
	JPanel p1,p2,k0;
	
      public 商场销售管理模块() {
    	  this.setLayout(new BorderLayout());
    	   this.setOpaque(false);////////
           k0=new JPanel();
           k0.setOpaque(false);////////
           p1=new JPanel();
           p1.setOpaque(false);////////
           p2=new JPanel();
           p2.setOpaque(false);////////
           k0.setLayout(new GridLayout(5, 1,0,55));
           JButton 浏览商品 = new JButton("单日查询");
           浏览商品.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
           k0.add(浏览商品);
           浏览商品.addActionListener(this);
           
           JButton 查询商品 = new JButton("单月查询");
           查询商品.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
           k0.add(查询商品);
           查询商品.addActionListener(this);
         
           JButton 删除商品 = new JButton("年份查询");
           删除商品.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
           k0.add(删除商品);
           删除商品.addActionListener(this);
           
           JButton 新增商品 = new JButton("浏览全部");
           新增商品.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
           k0.add(新增商品);
           新增商品.addActionListener(this);
           
           JButton 更新商品 = new JButton("总额查询");
           k0.add(更新商品);
           k0.setBackground(Color.pink);
           更新商品.addActionListener(this);
           
           p1.add(k0);
           this.add(p1,"West");
           this.add(p2,"Center");
           this.setVisible(true);
      }

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="单日查询") {
			p2.setVisible(false);
			p2.removeAll();
			p2.add(new 单日查询());
			p2.setVisible(true);
		}
		
		if(e.getActionCommand()=="单月查询") {
			p2.setVisible(false);
			p2.removeAll();
			p2.add(new 单月查询());
			p2.setVisible(true);
		}
		
		if(e.getActionCommand()=="年份查询") {
			p2.setVisible(false);
			p2.removeAll();
			p2.add(new 年份查询());
			p2.setVisible(true);
		}
		
		if(e.getActionCommand()=="浏览全部") {
			p2.setVisible(false);
			p2.removeAll();
			p2.add(new 浏览全部());
			p2.setVisible(true);
		}
		
		if(e.getActionCommand()=="总额查询") {
			p2.setVisible(false);
			p2.removeAll();
			p2.add(new 总额查询());
			p2.setVisible(true);
		}
	}
}
