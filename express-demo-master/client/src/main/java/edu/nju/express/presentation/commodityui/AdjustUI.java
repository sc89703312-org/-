package edu.nju.express.presentation.commodityui;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyLabel;
import edu.nju.express.vo.ComZoneVO;

public class AdjustUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CommodityController controller;
	ComZoneVO vo;
	private static Icon img1 = new ImageIcon("ui/button/confirmmove1.png");
	private static Icon img2 = new ImageIcon("ui/button/confirmmove2.png");
	private static Icon img3 = new ImageIcon("ui/button/init1.png");
	private static Icon img4 = new ImageIcon("ui/button/init2.png");
	private static Icon img5 = new ImageIcon("ui/button/ctrlz1.png");
	private static Icon img6 = new ImageIcon("ui/button/ctrlz2.png");
	
	LabelTextField planeSpace;
	LabelTextField trainSpace;
	LabelTextField carSpace;
	LabelTextField temSpace;
	MyLabel planeGoods;
	MyLabel trainGoods;
	MyLabel carGoods;
	MyLabel temGoods;
	
	JButton confirm;
	JButton init;
	JButton ctrlz;
	
	public AdjustUI(CommodityController c, ComZoneVO vo){
		
		this.bg = new ImageIcon("ui/image/combg.png").getImage();
		this.vo = vo;		
		this.controller = c;
		
		this.add(new CommodityGuide(c));
		
		int[] space = vo.getSpace();
		int[] goodsNum = vo.getGoodsNum();
		
		planeSpace = new LabelTextField("航空区容量： ",-1);
		planeSpace.getTextField().setText(space[0]+"");
		trainSpace = new LabelTextField("铁运区容量： ",-1);
		trainSpace.getTextField().setText(space[1]+"");
		carSpace = new LabelTextField("汽运区容量： ",-1);
		carSpace.getTextField().setText(space[2]+"");
		temSpace = new LabelTextField("机动区容量： ",-1);
		temSpace.getTextField().setText(space[3]+"");
		
		planeSpace.setBounds(180, 170, 300, 50);
		planeGoods = new MyLabel(200,220,200,20);
		planeGoods.setText("当前货物数： "+goodsNum[0]);
		planeGoods.setBackground(new Color(255,255,255));
		
		trainSpace.setBounds(520,170,300,50);
		trainGoods = new MyLabel(550,220,200,20);
		trainGoods.setText("当前货物数： "+goodsNum[1]);
		trainGoods.setBackground(new Color(255,255,255));
		
		carSpace.setBounds(180,370,300,50);
		carGoods = new MyLabel(200,420,200,20);
	    carGoods.setText("当前货物数： "+goodsNum[2]);
	    carGoods.setBackground(new Color(255,255,255));
	    
	    temSpace.setBounds(520,370,300,50);
		temGoods = new MyLabel(550,420,200,20);
		temGoods.setText("当前货物数： "+goodsNum[3]);
		temGoods.setBackground(new Color(255,255,255));	
		
		this.add(planeSpace);
		this.add(trainSpace);
		this.add(carSpace);
		this.add(temSpace);
		this.add(planeGoods);
		this.add(trainGoods);
		this.add(carGoods);
		this.add(temGoods);
		
		confirm = new JButton(img1);
		confirm.setRolloverIcon(img2);
		confirm.setContentAreaFilled(false);
		confirm.setBorderPainted(false);
		confirm.setBounds(300,537,120,30);
		confirm.setActionCommand("confirmeditzone");
		confirm.addActionListener(controller);
		this.add(confirm);
		
		init = new JButton(img3);
		init.setRolloverIcon(img4);
		init.setContentAreaFilled(false);
		init.setBorderPainted(false);
		init.setBounds(430,537,120,30);
		init.setActionCommand("init");
		init.addActionListener(controller);
		this.add(init);
		
		ctrlz = new JButton(img5);
		ctrlz.setRolloverIcon(img6);
		ctrlz.setContentAreaFilled(false);
		ctrlz.setBorderPainted(false);
		ctrlz.setBounds(560,537,120,30);
		ctrlz.setActionCommand("ctrlz");
		ctrlz.addActionListener(controller);
		this.add(ctrlz);
		
	}
	
	public ComZoneVO getZone(){
		return this.vo;
	}
	
	public int[] getSpace(){
		int plane = Integer.parseInt(planeSpace.getText());
		int train = Integer.parseInt(trainSpace.getText());
		int car = Integer.parseInt(carSpace.getText());
		int tem = Integer.parseInt(temSpace.getText());
		int[] result = {plane,train,car,tem};
		return result;
	}
	
}
