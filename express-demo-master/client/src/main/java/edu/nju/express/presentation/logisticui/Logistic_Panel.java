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
	MyLabel label_1,label,label2;
	MyButton search;

	LogisticsBLService logistic	=new LogisticsBL(new OrderBL());
	
	LogisticsVO vo;
	
	

	
	


	public  Logistic_Panel()
		// TODO Auto-generated constructor stub
	 {
		this.setOpaque(false);
		this.setLayout(null);
		
		
		label2 = new MyLabel(673, 260, 190, 23);
		label2.setVisible(false);
		label2.setOpaque(false);
		this.add(label2);
	
		
	
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
			}
		}
		
		
		
		public void mouseExited(MouseEvent e) {
			if(e.getSource()==search){
				label.setVisible(false);
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
				
			}
			
		}



		
	}
	
	
	private void showLogistic() {
		// TODO Auto-generated method stub
		ArrayList<String> history = vo.getHistory();
		
	
		label2.setText(history.get(0));
		label2.setVisible(true);


		
	}
	}
		
	
