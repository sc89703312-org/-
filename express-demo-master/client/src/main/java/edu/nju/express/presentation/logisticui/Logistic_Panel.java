package edu.nju.express.presentation.logisticui;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;






















import edu.nju.express.blservice.LogisticsBLService;
import edu.nju.express.businesslogic.logisticsbl.LogisticsBL;
import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.log.ui.frame.Frame;
import edu.nju.express.log.ui.warning.PromptDialog;
import edu.nju.express.presentation.loginui.LoginUI;
import edu.nju.express.presentation.myUI.MyButton;
import edu.nju.express.presentation.myUI.MyLabel;
import edu.nju.express.presentation.myUI.MyTextFieldV2;
import edu.nju.express.vo.LogisticsVO;

public class Logistic_Panel extends JPanel{

	/** serialVersionUID */
	private static final long serialVersionUID = 8770200041944584165L;

	/** 背景图片 */
	private static final Image IMG_BACK = new ImageIcon("ui/image/logistic/back.png").getImage();


	MyTextFieldV2 dateinput ;
	MyLabel label_1,label,label2,exitLabel,backLabel;
	MyButton search,exit,back;
	
	
	MyLabel circles[]= new MyLabel [5];
	MyLabel erects[]= new MyLabel[4];
	MyLabel spots[] = new MyLabel[5];
	MyLabel goodInfo[] = new MyLabel[4];

	LogisticsBLService logistic	=new LogisticsBL(new OrderBL());
	
	LogisticsVO vo ;
	
	Frame frame;


	
	


	public  Logistic_Panel(Frame parent)
		// TODO Auto-generated constructor stub
	 {
		this.setOpaque(false);
		this.setLayout(null);
		this.frame = parent;
		
		label2 = new MyLabel(685, 252, 190, 23);
		label2.setVisible(false);
		label2.setOpaque(false);
		this.add(label2);
		
		
		
		
		
		
		
		
		goodInfo[0] = new MyLabel(410, 260, 150, 150);
		goodInfo[0].setVisible(false);
		goodInfo[0].setOpaque(false);
		goodInfo[0].setFont(new Font("微软雅黑", Font.BOLD, 65));
		goodInfo[0].setForeground(new Color(32,180,220));
		this.add(goodInfo[0]);
		
		goodInfo[1] = new MyLabel(440, 390, 110, 30);
		goodInfo[1].setVisible(false);
		goodInfo[1].setOpaque(false);
		goodInfo[1].setFont(new Font("微软雅黑", Font.PLAIN, 20));
		this.add(goodInfo[1]);
		
		goodInfo[2] = new MyLabel(440, 440, 110, 30);
		goodInfo[2].setVisible(false);
		goodInfo[2].setOpaque(false);
		goodInfo[2].setFont(new Font("微软雅黑", Font.PLAIN, 20));		
		this.add(goodInfo[2]);
		
		
		goodInfo[3] = new MyLabel(440, 490, 110, 30);
		goodInfo[3].setVisible(false);
		goodInfo[3].setOpaque(false);
		goodInfo[3].setFont(new Font("微软雅黑", Font.PLAIN, 20));		
		this.add(goodInfo[3]);
		
		
		
		
		spots[0] = new MyLabel(675, 253, 190, 23);
		spots[0].setVisible(false);
		spots[0].setOpaque(false);
		this.add(spots[0]);
		
		spots[1] = new MyLabel(675, 318, 190, 23);
		spots[1].setVisible(false);
		spots[1].setOpaque(false);
		this.add(spots[1]);
		
		spots[2] = new MyLabel(675, 383, 190, 23);
		spots[2].setVisible(false);
		spots[2].setOpaque(false);
		this.add(spots[2]);
		
		spots[3] = new MyLabel(675, 448, 190, 23);
		spots[3].setVisible(false);
		spots[3].setOpaque(false);
		this.add(spots[3]);
		
		
		
		
		

		circles[0] = new MyLabel(663, 253, 20, 20);
		circles[0].setIcon(new ImageIcon("ui/image/logistic/circle.png"));
		circles[0].setVisible(false);
		circles[0].setOpaque(false);
		this.add(circles[0]);
		
		circles[1] = new MyLabel(663, 318, 20, 20);
		circles[1].setIcon(new ImageIcon("ui/image/logistic/circle.png"));
		circles[1].setVisible(false);
		circles[1].setOpaque(false);
		this.add(circles[1]);
		
		circles[2] = new MyLabel(663, 383, 20, 20);
		circles[2].setIcon(new ImageIcon("ui/image/logistic/circle.png"));
		circles[2].setVisible(false);
		circles[2].setOpaque(false);
		this.add(circles[2]);
		
		
		circles[3] = new MyLabel(663, 448, 20, 20);
		circles[3].setIcon(new ImageIcon("ui/image/logistic/circle.png"));
		circles[3].setVisible(false);
		circles[3].setOpaque(false);
		this.add(circles[3]);
		
		
		
	
		
		erects[0] = new MyLabel(663, 275, 20, 40);
		erects[0].setIcon(new ImageIcon("ui/image/logistic/erect.png"));
		erects[0].setVisible(false);
		erects[0].setOpaque(false);
		this.add(erects[0]);
		
		
		
		erects[1] = new MyLabel(663, 340, 20, 40);
		erects[1].setIcon(new ImageIcon("ui/image/logistic/erect.png"));
		erects[1].setVisible(false);
		erects[1].setOpaque(false);
		this.add(erects[1]);
	
		
		
		erects[2] = new MyLabel(663, 405, 20, 40);
		erects[2].setIcon(new ImageIcon("ui/image/logistic/erect.png"));
		erects[2].setVisible(false);
		erects[2].setOpaque(false);
		this.add(erects[2]);
		
		
		
		
		
	
		dateinput = new MyTextFieldV2(55, 148, 180, 66);
		dateinput.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		dateinput.setForeground(new Color(130,130,130));
		dateinput.setOpaque(false);
		dateinput.setBorder(BorderFactory.createEmptyBorder());
		this.add(dateinput);
		dateinput.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				label_1.setVisible(true);
			}

			public void mouseExited(MouseEvent arg0) {
				label_1.setVisible(false);
			}
		});

		
		
		search = new MyButton(235, 147, 60, 60);
		this.add(search);
		search.addMouseListener(new btnListener());
		
		
		exit = new MyButton(880, 24, 45, 45);
		exit.addMouseListener(new btnListener());
		this.add(exit);
		
		
		back = new MyButton(424, 536, 145, 62);
		back.addMouseListener(new btnListener());
		this.add(back);
		
		
		backLabel = new MyLabel(0, 0, 960, 720);
		backLabel.setIcon(new ImageIcon("ui/image/logistic/confirm.png"));
		backLabel.setVisible(false);
		backLabel.setOpaque(false);		
		this.add(backLabel);
		
		
		
		exitLabel = new MyLabel(0, 0, 960, 720);
		exitLabel.setIcon(new ImageIcon("ui/image/logistic/exit.png"));
		exitLabel.setVisible(false);
		exitLabel.setOpaque(false);		
		this.add(exitLabel);
		
		
		
		label = new MyLabel(0, 0, 960, 720);
		label.setIcon(new ImageIcon("ui/image/logistic/back_2.png"));
		label.setVisible(false);
		label.setOpaque(false);		
		this.add(label);
		
		
		label_1 = new MyLabel(0, 0, 960, 720);
		label_1.setIcon(new ImageIcon("ui/image/logistic/back_1.png"));
		label_1.setVisible(false);
		label_1.setOpaque(false);		
		this.add(label_1);
		

		
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(IMG_BACK, 0, 0, this);
		super.paintComponent(g);
	}



	/**
	 * 添加日志信息
	 * @author cylong
	 * @version 2014年12月27日 上午4:19:53
	 */

	
	
	

		
	private class btnListener extends MouseAdapter {
		
		
		@Override
	    public void mouseEntered(MouseEvent e) {
			if(e.getSource()==search){
				label.setVisible(true);
			}else if (e.getSource()==exit) {
				exitLabel.setVisible(true);
			}
		}
		
		
		
		public void mouseExited(MouseEvent e) {
			if(e.getSource()==search){
				label.setVisible(false);
			}else if (e.getSource()==exit) {
				exitLabel.setVisible(false);
			}
		}
		
		
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource()==search){
				
				 vo = logistic.view(dateinput.getText());
				if (vo!=null) {
					showLogistic();
				}else {
					System.out.println("miss");
				}
				
			}else if (e.getSource()==exit) {
				System.exit(0);
			}else {
				exit();
			}
			
		}


		
	


		@Override
		public void mousePressed(MouseEvent e){
			if (e.getSource()==back) {
				backLabel.setVisible(true);
			}
		}
		
		@Override
		public void mouseReleased(MouseEvent e){
			if (e.getSource()==back) {
				backLabel.setVisible(false);
			}
		}
		
	}
	
	
	private void showLogistic() {
		// TODO Auto-generated method stub
		ArrayList<String> history = vo.getHistory();
		int spot = history.size();
	
		
		for(int i=0;i<4;i++){
			circles[i].setVisible(false);
			spots[i].setVisible(false);
			goodInfo[i].setVisible(false);
		}
		for(int i=0;i<3;i++){
			erects[i].setVisible(false);
		}
		
		
		
		
		for(int i=0;i<spot;i++){
			spots[i].setText(history.get(i));
			spots[i].setVisible(true);
		}
        

		
		
		for(int i=0;i<spot;i++)
			circles[i].setVisible(true);
		
		for(int i=0;i<spot-1;i++)
			erects[i].setVisible(true);

		
		goodInfo[0].setText(vo.getPrice());
		goodInfo[0].setVisible(true);
		goodInfo[1].setText(vo.getName());
		goodInfo[1].setVisible(true);
		goodInfo[2].setText(vo.getFrom());
		goodInfo[2].setVisible(true);
		goodInfo[3].setText(vo.getTo());
		goodInfo[3].setVisible(true);
		
		
		
	}
	
	
	private void exit() {
		// TODO Auto-generated method stub
		frame.closeFrame();
		
		try {
			Thread.sleep(500);
			
			new LoginUI();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	}
		
	
