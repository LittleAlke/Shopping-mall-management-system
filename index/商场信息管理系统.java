package 商场管理系统;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.crypto.NullCipher;
import javax.swing.*;
public class 商场信息管理系统 implements ActionListener{
  private JButton 注销用户,退出系统,系统备份,帮助,个人详情,商品信息管理模块,VIP信息管理模块,商场人事管理模块,商场销售管理模块,确认,取消;
  private JLabel 账号,姓名;
  private JTextField 账号内容,姓名内容;
  private JDialog 提示;
	private JPanel p4,p5;
	public 商场信息管理系统() {
	  JFrame app=new JFrame("系统主界面");	  
	  Container c=app.getContentPane(); 
	    ImageIcon img=new ImageIcon("E:\\商场管理系统\\src\\商场管理系统\\云3.jpg");
	    JLabel jll=new JLabel(img);
	    jll.setBounds(0, 0, img.getIconWidth(),img.getIconWidth()-1100);
	    app.getLayeredPane().add(jll,new Integer(Integer.MIN_VALUE));
	    ((JPanel)c).setOpaque(false);
	    
	  c.setLayout(new BorderLayout());
	  JPanel psz=new JPanel(new GridLayout(3,1,0,10));//0,10
	  psz.setOpaque(false);////////
	  c.add(psz,BorderLayout.NORTH);
	  
	  JPanel p1=new JPanel(new GridLayout(1,2));            //第一行开始
	  p1.setOpaque(false);////////
	  JPanel p1_1=new JPanel(new GridLayout(1,4));//10,0
	  p1_1.setOpaque(false);/////////
	  注销用户=new JButton("注销用户");
	  注销用户.setContentAreaFilled(false);//+++++
	  注销用户.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来	  
	  注销用户.setBorderPainted(false);
	  p1_1.add(注销用户);
	  注销用户.addActionListener(this);
	  
	  退出系统=new JButton("退出系统");
	  退出系统.setContentAreaFilled(false);//++++++
	  退出系统.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来	  
	  退出系统.setBorderPainted(false);
	  p1_1.add(退出系统);
	  退出系统.addActionListener(this);
	  
	  系统备份=new JButton("系统备份");
	  系统备份.setContentAreaFilled(false);//+++++
	  系统备份.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来	  
	  系统备份.setBorderPainted(false);
	  p1_1.add(系统备份);
	  系统备份.addActionListener(this);
	  
	  帮助=new JButton("帮助");
	  帮助.setContentAreaFilled(false);//++++++
	  帮助.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来  
	  帮助.setBorderPainted(false);
	  p1_1.add(帮助);
	  帮助.addActionListener(this);
	  
	  p1.add(p1_1);
	  JPanel p1_2=new JPanel();
	  p1_2.setOpaque(false);////////
	  p1.add(p1_2);
	  psz.add(p1);
	  
	  JPanel p2=new JPanel(new GridLayout(1,2));          //第二行开始150,0
	  p2.setOpaque(false);////////
	  JPanel p2_1=new JPanel(new GridLayout(1,4));
	  p2_1.setOpaque(false);////////
	  JPanel p2_2=new JPanel(new GridLayout(1,3));
	  p2_2.setOpaque(false);////////
	  账号=new JLabel("账号:",JLabel.CENTER);
	  p2_1.add(账号);
	  
	  账号内容=new JTextField(登录.ID,JTextField.CENTER); 
	   账号内容.setFont(new Font("宋体",Font.BOLD,20));
	                                                     账号内容.setOpaque(false);//-------
	  p2_1.add(账号内容);
	 
	  姓名=new JLabel("姓名:",JLabel.CENTER);
	  p2_1.add(姓名);
	  
	  姓名内容=new JTextField(登录.name,JTextField.CENTER);              
	  姓名内容.setFont(new Font("宋体",Font.BOLD,20));
	                                                    姓名内容.setOpaque(false);//-----
	  p2_1.add(姓名内容);
	  p2.add(p2_1);
	  
	  JLabel j1 = new JLabel("  ");
	  p2_2.add(j1);
	  
	  个人详情=new JButton("个人详情");
	  个人详情.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
	  个人详情.setContentAreaFilled(false);                  //按钮透明
	  //个人详情.setBorder(BorderFactory.createRaisedBevelBorder());
	  个人详情 .setFont(new java.awt.Font("黑体", 1, 18));
	  个人详情.setBackground(Color.white);
	  p2_2.add(个人详情);
	  个人详情.addActionListener(this);
	  JLabel j2 = new JLabel("  ");
	  p2_2.add(j2);
	  
	  p2.add(p2_2);
	  psz.add(p2);
	  
	  JPanel p3=new JPanel(new GridLayout(1,4,10,0));    //第三行开始
	  p3.setOpaque(false);////////
	  商品信息管理模块=new JButton("商品信息管理模块");
	  商品信息管理模块 .setContentAreaFilled(false);
	  商品信息管理模块.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
	  //商品信息管理模块.setBorderPainted(false);                 //按钮去掉边框
	  p3.add(商品信息管理模块);
	  商品信息管理模块.addActionListener(this);
	  
	  VIP信息管理模块=new JButton("VIP信息管理模块");
	  VIP信息管理模块 .setContentAreaFilled(false);
	  VIP信息管理模块.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
	  //VIP信息管理模块.setBorder(BorderFactory.createLoweredBevelBorder());
	  p3.add(VIP信息管理模块);
	  VIP信息管理模块.addActionListener(this);                          
	  
	  商场人事管理模块=new JButton("商场人事管理模块");
	  商场人事管理模块 .setContentAreaFilled(false);
	  商场人事管理模块.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
	  p3.add(商场人事管理模块);
	  商场人事管理模块.addActionListener(this);
	  
	  商场销售管理模块=new JButton("商场销售管理模块");
	  商场销售管理模块.setBorder(BorderFactory.createRaisedBevelBorder());   //按钮凸出来
	  商场销售管理模块 .setContentAreaFilled(false);                  //按钮透明
	  p3.add(商场销售管理模块);
	  商场销售管理模块.addActionListener(this);
	  psz.add(p3);

	  p4=new JPanel(new BorderLayout());
	  p4.setOpaque(false);////////
	  p4.setBackground(Color.GRAY);
	  c.add(p4,BorderLayout.CENTER);
	  
	 // p5=new JPanel();
	 // p5.setBackground(Color.GREEN);
	 // c.add(p5,BorderLayout.WEST);
	  提示=new JDialog(); //对话框
	     提示.setTitle("系统提示");
	     提示.setSize(340,80);
	     提示.setLocation(app.getX()+200, app.getY()+200);
	     提示.setLayout(new FlowLayout());
		
		 确认=new JButton("确认");
	     提示.add(确认);
	     确认.addActionListener(this);
	     
	     取消=new JButton("取消");
	     提示.add(取消);
	     取消.addActionListener(this);	  	  
	  
	  JPanel pxz=new JPanel(new GridLayout(1,1));
	  pxz.setOpaque(false);////////
	  pxz.setBackground(Color.LIGHT_GRAY);
	  c.add(pxz,BorderLayout.SOUTH);
	  pxz.add(new Label("                 郑州轻工业大学",JLabel.CENTER));
	  pxz.add(new Label("              软件学院",JLabel.CENTER));
	  pxz.add(new Label("              卡拉肖可潘",JLabel.CENTER));
	  
	  app.setSize(1200, 800);
	  app.setLocationRelativeTo(null);
	  app.setVisible(true);
	
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==注销用户) {
			提示.setVisible(true);
		}
		if(e.getSource()==取消)
			{
			System.exit(0);
			}
		if (e.getSource()==确认) {
			new 注销用户();
			提示.setVisible(false);
			System.out.println("已调用注销用户功能");			
			System.exit(0);							
		}
		if (e.getSource()==商品信息管理模块) {
			p4.setVisible(false);
			p4.removeAll();			              
		    p4.add(new 商品信息管理模块());		           
			p4.setVisible(true);
		}
		if (e.getSource()==个人详情) {
			p4.setVisible(false);
			p4.removeAll();			             
			p4.add(new 个人详情());			         
			p4.setVisible(true);
		}
		if (e.getSource()==退出系统) {			
			JOptionPane.showConfirmDialog(new JFrame().getContentPane(), 
					"是否保存已操作内容？", "系统信息",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
		   System.exit(0);
		}
		if (e.getSource()==商场人事管理模块) {
			p4.setVisible(false);
			p4.removeAll();			            
			p4.add(new 商场人事管理模块(),"Center");			            
			p4.setVisible(true);
		}
		if (e.getSource()==VIP信息管理模块) {
			p4.setVisible(false);
			p4.removeAll();			              
			p4.add(new VIP信息管理模块(),"Center");			             
			p4.setVisible(true);
		}
		if (e.getSource()==商场销售管理模块) {
			p4.setVisible(false);
			p4.removeAll();			              
			p4.add(new 商场销售管理模块(),"Center");			             
			p4.setVisible(true);
		}
		if (e.getSource()==帮助) {
	    try {
        
        //Runtime.getRuntime().exec("C:/Program Files/Internet Explorer/IEXPLORE.exe　http://www.baidu.com"); 　//绝对路径
        Runtime.getRuntime().exec("cmd   /c   start   https://zhidao.baidu.com/question/43498188.html");
                     
                } catch (Exception ex) {
                 System.out.println("error");
                 ex.printStackTrace();
                }		
		}
		if (e.getSource()==系统备份) {
		    try {
	        
	        //Runtime.getRuntime().exec("C:/Program Files/Internet Explorer/IEXPLORE.exe　http://www.baidu.com"); 　//绝对路径
	        Runtime.getRuntime().exec("cmd   /c   start   E:\\数据库");
	                     
	                } catch (Exception ex) {
	                 System.out.println("error");
	                 ex.printStackTrace();
	               }				
		}
 }

	private static void setVisible(boolean b) {
		// TODO Auto-generated method stub	
	}
  
	

	
	
}
