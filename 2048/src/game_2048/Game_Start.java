package game_2048;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JLabel;

public class Game_Start {

	public static void main(String[] args) {
		MyFrame test = new MyFrame();
		//初始化面板
		test.loadFrame();
		test.addKeyListener(new KeyListener() {
			//按下方向键
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
					
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e.getKeyCode());
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					for(int y = 0;y<4;++y) {
						//System.out.println(y);
						int prev = 0;
						if(test.fz.nums[0][y]!=0) {
							temp.add((Integer)test.fz.nums[0][y]);
							prev = test.fz.nums[0][y];
							//test.fz.nums[0][y] = 0;
						}
						for(int x = 1;x<4;++x) {
							if(test.fz.nums[x][y] == prev
							   &&test.fz.nums[x][y]!=0) {
								if(temp.size()!=0) {
									temp.set(temp.size()-1,(Integer)test.fz.nums[x][y] * 2);
									test.score.now += (int)temp.get(temp.size()-1);
									test.Jright2.setText(String.valueOf(test.score.now));
									prev = 0;
								}
								else {
									temp.add((Integer)test.fz.nums[x][y]);
									//test.fz.nums[x][y] = 0;
								}
							}
							else if(test.fz.nums[x][y]!=0){
								temp.add((Integer)test.fz.nums[x][y]);
								prev = test.fz.nums[x][y];
							}
						}
						for(int aa = 0;aa<4;++aa) {
							test.fz.nums[aa][y] = 0;
						}
						for(int aa = 0;aa<temp.size();++aa) {
							test.fz.nums[aa][y] = (int)temp.get(aa);
						}
						temp.clear();
					}
					for(int i = 0;i<4;++i) {
						for(int j = 0;j<4;++j) {
							System.out.print(test.fz.nums[i][j]);
						}
						System.out.println();
					}
					test.fz.kb();
					test.fz.fuzhi();
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					for(int y = 0;y<4;++y) {
						//System.out.println(y);
						int prev = 0;
						if(test.fz.nums[3][y]!=0) {
							temp.add((Integer)test.fz.nums[3][y]);
							prev = test.fz.nums[3][y];
							//test.fz.nums[0][y] = 0;
						}
						for(int x = 2;x>=0;--x) {
							if(test.fz.nums[x][y] == prev
							   &&test.fz.nums[x][y]!=0) {
								if(temp.size()!=0) {
									temp.set(temp.size()-1,(Integer)test.fz.nums[x][y] * 2);
									test.score.now += (int)temp.get(temp.size()-1);
									test.Jright2.setText(String.valueOf(test.score.now));
									prev = 0;
								}
								else {
									temp.add((Integer)test.fz.nums[x][y]);
									//test.fz.nums[x][y] = 0;
								}
							}
							else if(test.fz.nums[x][y]!=0){
								temp.add((Integer)test.fz.nums[x][y]);
								prev = test.fz.nums[x][y];
							}
						}
						for(int aa = 0;aa<4;++aa) {
							test.fz.nums[aa][y] = 0;
						}
						int tempa = 0;
						for(int aa = 3;tempa<temp.size();++tempa) {
							test.fz.nums[aa][y] = (int)temp.get(tempa);
							aa--;
						}
						temp.clear();
					}
					for(int i = 0;i<4;++i) {
						for(int j = 0;j<4;++j) {
							System.out.print(test.fz.nums[i][j]);
						}
						System.out.println();
					}
					test.fz.kb();
					test.fz.fuzhi();
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					for(int x = 0;x<4;++x) {
						//System.out.println(y);
						int prev = 0;
						if(test.fz.nums[x][0]!=0) {
							temp.add((Integer)test.fz.nums[x][0]);
							prev = test.fz.nums[x][0];
							//test.fz.nums[0][y] = 0;
						}
						for(int y = 1;y<4;++y) {
							if(test.fz.nums[x][y] == prev
							   &&test.fz.nums[x][y]!=0) {
								if(temp.size()!=0) {
									temp.set(temp.size()-1,(Integer)test.fz.nums[x][y] * 2);
									prev = 0;
									test.score.now += (int)temp.get(temp.size()-1);
									test.Jright2.setText(String.valueOf(test.score.now));
								}
								else {
									temp.add((Integer)test.fz.nums[x][y]);
									//test.fz.nums[x][y] = 0;
								}
							}
							else if(test.fz.nums[x][y]!=0){
								temp.add((Integer)test.fz.nums[x][y]);
								prev = test.fz.nums[x][y];
							}
						}
						for(int aa = 0;aa<4;++aa) {
							test.fz.nums[x][aa] = 0;
						}
						for(int aa = 0;aa<temp.size();++aa) {
							test.fz.nums[x][aa] = (int)temp.get(aa);
						}
						temp.clear();
					}
					for(int i = 0;i<4;++i) {
						for(int j = 0;j<4;++j) {
							System.out.print(test.fz.nums[i][j]);
						}
						System.out.println();
					}
					test.fz.kb();
					test.fz.fuzhi();
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					for(int x = 0;x<4;++x) {
						//System.out.println(y);
						int prev = 0;
						if(test.fz.nums[x][3]!=0) {
							temp.add((Integer)test.fz.nums[x][3]);
							prev = test.fz.nums[x][3];
							//test.fz.nums[0][y] = 0;
						}
						for(int y = 2;y>=0;--y) {
							if(test.fz.nums[x][y] == prev
							   &&test.fz.nums[x][y]!=0) {
								if(temp.size()!=0) {
									temp.set(temp.size()-1,(Integer)test.fz.nums[x][y] * 2);
									test.score.now += (int)temp.get(temp.size()-1);
									test.Jright2.setText(String.valueOf(test.score.now));
									prev = 0;
								}
								else {
									temp.add((Integer)test.fz.nums[x][y]);
									//test.fz.nums[x][y] = 0;
								}
							}
							else if(test.fz.nums[x][y]!=0){
								temp.add((Integer)test.fz.nums[x][y]);
								prev = test.fz.nums[x][y];
							}
						}
						for(int aa = 0;aa<4;++aa) {
							test.fz.nums[x][aa] = 0;
						}
						int tempa = 0;
						for(int aa = 3;tempa<temp.size();++tempa) {
							test.fz.nums[x][aa] = (int)temp.get(tempa);
							aa--;
						}
						temp.clear();
					}
					for(int i = 0;i<4;++i) {
						for(int j = 0;j<4;++j) {
							System.out.print(test.fz.nums[i][j]);
						}
						System.out.println();
					}
					test.fz.kb();
					test.fz.fuzhi();
					
				}
			}
			
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				;
			}
		});
		
	}

}
