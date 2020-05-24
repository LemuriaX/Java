package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Test {
	static Mysql sql = new Mysql();
	public static String getRandomString(){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer ret=new StringBuffer();
	     for(int i=0;i<6;i++){
	       int number=random.nextInt(62);
	       ret.append(str.charAt(number));
	     }
	     return ret.toString();
	}
	public static void exit1(String a,String b) {
		/*
		 * 输入错误提示框
		 */
		JFrame frame2 = new JFrame(a);
		frame2.setSize(250,200);
		frame2.setLocationRelativeTo(null);
		frame2.setLayout(new FlowLayout());
		JLabel frame2_jlabel = new JLabel(b);
		JButton frame2_exit = new JButton("确定");
		frame2.add(frame2_jlabel);
		frame2.add(frame2_exit);
		frame2.setVisible(true);
		frame2_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//frame2.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
				frame2.dispose();
			}
		});
	}
	public static void zc() {
		JFrame frame2 = new JFrame("注册");
		frame2.setSize(210,340);
		frame2.setLocationRelativeTo(null);
		frame2.setLayout(new FlowLayout());
		JLabel frame2_jlabel1 = new JLabel("用户名");
		JLabel frame2_jlabel2 = new JLabel("密码");
		JLabel frame2_jlabel3 = new JLabel("重复密码");
		JButton b1 = new JButton("验证码");
		JButton b2 = new JButton("确定");
		JTextField jtf1 = new JTextField(15);
		JPasswordField jtf2 = new JPasswordField(15);
		JPasswordField jtf3 = new JPasswordField(15);
		JTextField jtf4 = new JTextField(15);
		frame2.add(frame2_jlabel1); frame2.add(jtf1);
		frame2.add(frame2_jlabel2); frame2.add(jtf2);
		frame2.add(frame2_jlabel3); frame2.add(jtf3);
		frame2.add(b1); frame2.add(jtf4);
		frame2.add(b2);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				b1.setText(getRandomString());
			}
		});
		b2.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String temp = new String(jtf2.getPassword());
				String temp2 = new String(jtf3.getPassword());
				if(jtf1.getText().equals("")||temp.equals("")||temp2.equals("")) {
					exit1("error","用户名或密码为空");
					jtf1.setText("");jtf2.setText("");jtf3.setText("");jtf4.setText("");
				}
				else if(jtf4.getText().equals("")) {
					exit1("error", "验证码为空");
					jtf1.setText("");jtf2.setText("");jtf3.setText("");jtf4.setText("");
				}
				else if(temp.equals(temp2) == false) {
					exit1("error","两次输入的密码不相等");
					jtf1.setText("");jtf2.setText("");jtf3.setText("");jtf4.setText("");
				}
				else if(xx(jtf4.getText()).equals(xx(b1.getText())) == false) {
					exit1("error","验证码错误");
					jtf1.setText("");jtf2.setText("");jtf3.setText("");jtf4.setText("");
				} else
					try {
						String tempqq = sql.cx(jtf1.getText());
						//System.out.println("12123123");
						if(tempqq!=null) {
							exit1("error", "该用户已存在！");
							jtf1.setText("");jtf2.setText("");jtf3.setText("");jtf4.setText("");
						}
						else {
							sql.sql_insert(jtf1.getText(),temp);
							exit1("success", "注册完成");
							frame2.dispose();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		
		
		frame2.setVisible(true);
		
	}
	public static String xx(String s) {
		StringBuffer ret = new StringBuffer();
		for(int i = 0;i<s.length();i++) {
			if(s.charAt(i) >= 'A'&& s.charAt(i)<='Z') {
				ret.append((char)(s.charAt(i)+32));
			}
			else {
				ret.append(s.charAt(i));
			}
		}
		return ret.toString();
	}
	public static void main(String[] args) {
		

		/*
		 * 框架和按钮
		 */
		JFrame frame = new JFrame("hello");			//主界面
		/*
		 * 两个文本
		 */
		JLabel label = new JLabel("用户名：");			
		JLabel label2 = new JLabel("密码：");
		
		/*
		 * 用户名输入框
		 */
		JTextField jtf1 = new JTextField(15);
		JTextField yzm = new JTextField(6);
		//四个按钮
		JButton b1 = new JButton("登录");JButton b2 = new JButton("取消");JButton b3 = new JButton("验证码");
		JButton b4 = new JButton("注册");
		
		//密码输入框
		JPasswordField jpw = new JPasswordField(15);

		/*
		 * 显示
		 */
		frame.add(label);frame.add(jtf1);
		frame.add(label2);frame.add(jpw);
		frame.add(b3);frame.add(yzm);
		frame.add(b1);frame.add(b2);
		frame.add(b4);
		frame.setLayout(new FlowLayout());
		frame.setSize(230,340);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user_temp = new String();
				try {
					user_temp = sql.cx(jtf1.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String temp = new String(jpw.getPassword());
				if(jtf1.getText().equals("")||temp.equals("")) {
					exit1("error","用户名或密码为空");
					jtf1.setText("");jpw.setText("");yzm.setText("");
				}
				else if(xx(yzm.getText()).equals(xx(b3.getText())) == false) {
					exit1("error","验证码错误");
					b3.setText(getRandomString());
					yzm.setText("");
				}
				else if(user_temp==null) {
					exit1("error","该用户不存在");
					jtf1.setText("");jpw.setText("");yzm.setText("");
				}
				else if(user_temp.equals(jtf1.getText())&&sql.password.equals(temp)&&xx(yzm.getText()).equals(xx(b3.getText()))) {
					exit1("success","登录成功");
				}
				else {
					exit1("error","用户名或密码错误");
					jtf1.setText("");jpw.setText("");yzm.setText("");
				}
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtf1.setText("");jpw.setText("");yzm.setText("");
			}
		});
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				b3.setText(getRandomString());
			}
		});
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				zc();
			}
		});
		frame.setVisible(true);
	}

}
