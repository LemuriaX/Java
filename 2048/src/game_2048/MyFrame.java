package game_2048;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MyFrame extends JFrame{	
	//记分板组件
	JLabel Jright2 = null;
	Score score = new Score();
	fz_nums fz = new fz_nums();
	//图片缩放
	public ImageIcon change(ImageIcon image,double i){//  i 为放缩的倍数
		int width=(int) (image.getIconWidth()*i);
		int height=(int) (image.getIconHeight()*i);
		Image img=image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);//第三个值可以去查api是图片转化的方式
		ImageIcon image2=new ImageIcon(img);
		return image2;
		 
	}
	/*
	 * 初始化界面，分为上下两个部分
	 * 上部分为记分板和图标以及重置按钮 使用绝对布局
	 * 下半部分为游戏内容	使用网格布局
	 * 整体使用绝对布局
	 */
	public void loadFrame() {
		Color Back_ground_Color = new Color(251,248,239);
		Color Font_Color = new Color(119, 110, 101);
		Color P3_back_Color = new Color(187, 173, 160);
		//应用图标
		Image img = new ImageIcon("image/2048.jpg").getImage();
		//定义一个容器
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		/*
		 * 标题相关和窗口大小
		 */
		this.setTitle("2048");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(320,430);
		this.setIconImage(img);
		//上左半部分
		Panel P1 = new Panel();
		P1.setLayout(null);
		//设置左边2048的部分
		JLabel JLeft = new JLabel("2048");
		JLeft.setFont(new Font("楷体",1,40));
		JLeft.setForeground(Font_Color);
		//JLeft.setIcon(change(new ImageIcon("image/left.png"),0.3));
		JLeft.setBounds(20, 20, 150, 50);
		P1.add(JLeft);
		//P1.setBackground(Color.BLUE);
		
		//上右半部分
		Panel P2 = new Panel();
		JLabel Jright = new JLabel("当前分数：");
		Jright.setFont(new Font("楷体",1,27));
		Jright.setForeground(Font_Color);
		Jright.setBounds(140, 0, 160, 50);
		//Jright.setBackground(Color.RED);
		//控件是否透明
		Jright.setOpaque(false);
		
		Jright2 = new JLabel(String.valueOf(score.now));
		Jright2.setFont(new Font("楷体",1,26));
		Jright2.setForeground(Font_Color);
		Jright2.setBounds(140, 50, 160, 26);
		//Jright2.setBackground(Color.BLUE);
		//控件是否透明
		Jright2.setOpaque(false);
		//P2.setBackground(Color.black);
		P2.add(Jright);
		P2.add(Jright2);
		
		
		//下半部分
		JPanel P3 = new JPanel();
		P3.setBackground(P3_back_Color);
		//P3.setBorder(BorderFactory.createLineBorder(P3_back_Color, 10, true));
		P3.setLayout(new GridLayout(4,4,6,6));
		fz.kb();
		fz.csh();
		fz.fuzhi();
		for(int i = 0;i<4;++i) {
			for(int j = 0;j<4;++j) {
				P3.add(fz.Jfz[i][j]);
			}
		}
		
		
		P1.setBounds(0, 0, 140, 100);
		P2.setBounds(140, 0, 160, 100);
		P3.setBounds(20, 120, 260, 260);
		contentPane.add(P1);
		contentPane.add(P2);
		contentPane.add(P3);
		contentPane.setBackground(Back_ground_Color);
		this.setVisible(true);
	}
	
	
	
	

}
