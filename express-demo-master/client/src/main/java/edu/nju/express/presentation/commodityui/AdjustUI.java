package edu.nju.express.presentation.commodityui;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyDashBoard;
import edu.nju.express.presentation.myUI.MyLabel;
import edu.nju.express.presentation.myUI.RefreshButton;
import edu.nju.express.vo.ComZoneVO;

public class AdjustUI extends MainPanel {

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
	private static Icon img7 = new ImageIcon("ui/button/refreshcom.png");
	private static Icon img8 = new ImageIcon("ui/button/refreshcom2.png");

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
	JButton refreshadjust;

	int[] space;
	int[] goodsNum;

	public AdjustUI(CommodityController c, ComZoneVO vo) {
		this.remove(logoLabel);
		this.bg = new ImageIcon("ui/image/commodity/adjust.png").getImage();
		this.vo = vo;
		this.controller = c;

		this.add(new CommodityGuide(c));

		space = vo.getSpace();
		goodsNum = vo.getGoodsNum();

		initDashBoards();

		planeSpace = new LabelTextField("航空区： "+goodsNum[0]+" / ", -1);
		planeSpace.getTextField().setText(space[0] + "");
		trainSpace = new LabelTextField("铁运区： "+goodsNum[1]+" / ", -1);
		trainSpace.getTextField().setText(space[1] + "");
		carSpace = new LabelTextField("汽运区： "+goodsNum[2]+" /  ", -1);
		carSpace.getTextField().setText(space[2] + "");
		temSpace = new LabelTextField("机动区： "+goodsNum[3]+" / ", -1);
		temSpace.getTextField().setText(space[3] + "");

		planeSpace.setBounds(180, 140, 350, 40);
		trainSpace.setBounds(520, 140, 350, 40);
		carSpace.setBounds(180, 350, 350, 40);
		temSpace.setBounds(520, 350, 350, 40);
		
	/*	planeGoods = new MyLabel(200, 220, 200, 20);
		planeGoods.setText("当前货物数： " );
		planeGoods.setBackground(new Color(255, 255, 255));

		
		trainGoods = new MyLabel(550, 220, 200, 20);
		trainGoods.setText("当前货物数： " + goodsNum[1]);
		trainGoods.setBackground(new Color(255, 255, 255));

		
		carGoods = new MyLabel(200, 420, 200, 20);
		carGoods.setText("当前货物数： " + goodsNum[2]);
		carGoods.setBackground(new Color(255, 255, 255));*/

		
	/*	temGoods = new MyLabel(550, 420, 200, 20);
		temGoods.setText("当前货物数： " + goodsNum[3]);
		temGoods.setBackground(new Color(255, 255, 255));*/

		this.add(planeSpace);
		this.add(trainSpace);
		this.add(carSpace);
		this.add(temSpace);
	/*	this.add(planeGoods);
		this.add(trainGoods);
		this.add(carGoods);
		this.add(temGoods);*/

		confirm = new JButton(img1);
		confirm.setRolloverIcon(img2);
		confirm.setContentAreaFilled(false);
		confirm.setBorderPainted(false);
		confirm.setBounds(300, 537, 120, 30);
		confirm.setActionCommand("confirmeditzone");
		confirm.addActionListener(controller);
		this.add(confirm);

		init = new JButton(img3);
		init.setRolloverIcon(img4);
		init.setContentAreaFilled(false);
		init.setBorderPainted(false);
		init.setBounds(430, 537, 120, 30);
		init.setActionCommand("init");
		init.addActionListener(controller);
		this.add(init);

		ctrlz = new JButton(img5);
		ctrlz.setRolloverIcon(img6);
		ctrlz.setContentAreaFilled(false);
		ctrlz.setBorderPainted(false);
		ctrlz.setBounds(560, 537, 120, 30);
		ctrlz.setActionCommand("ctrlz");
		ctrlz.addActionListener(controller);
		this.add(ctrlz);

		refreshadjust = new RefreshButton();
		refreshadjust.setActionCommand("refreshadjust");
		refreshadjust.addActionListener(controller);
		this.add(refreshadjust);

	}

	private void initDashBoards() {
		/*planeSpace.setBounds(180, 170, 300, 50);
		trainSpace.setBounds(520, 170, 300, 50);
		carSpace.setBounds(180, 370, 300, 50);
		temSpace.setBounds(520, 370, 300, 50);
*/
		MyDashBoard dp = new MyDashBoard(goodsNum[0] / space[0]);
		MyDashBoard dtr = new MyDashBoard(goodsNum[1] / space[1]);
		MyDashBoard dc = new MyDashBoard(goodsNum[2] / space[2]);
		MyDashBoard dte = new MyDashBoard(goodsNum[3] / space[3]);
		/*
		MyDashBoard dp = new MyDashBoard(20);
		MyDashBoard dtr = new MyDashBoard(30);
		MyDashBoard dc = new MyDashBoard(40);
		MyDashBoard dte = new MyDashBoard(50);*/
		
		dp.setBounds(260, 180, (int)dp.getPreferredSize().getWidth(),(int)dp.getPreferredSize().getHeight());
		dtr.setBounds(600, 180, (int)dtr.getPreferredSize().getWidth(),(int)dtr.getPreferredSize().getHeight());
		dc.setBounds(260, 390, (int)dc.getPreferredSize().getWidth(),(int)dc.getPreferredSize().getHeight());
		dte.setBounds(600, 390, (int)dte.getPreferredSize().getWidth(),(int)dte.getPreferredSize().getHeight());
		
		this.add(dte);
		this.add(dc);
		this.add(dtr);
		this.add(dp);
		
		Thread th1 = new Thread(dte);
		th1.start();
		Thread th2 = new Thread(dc);
		th2.start();
		Thread th3 = new Thread(dtr);
		th3.start();
		Thread th4 = new Thread(dp);
		th4.start();
		
	}

	public ComZoneVO getZone() {
		return this.vo;
	}

	public int[] getSpace() {
		int plane = Integer.parseInt(planeSpace.getText());
		int train = Integer.parseInt(trainSpace.getText());
		int car = Integer.parseInt(carSpace.getText());
		int tem = Integer.parseInt(temSpace.getText());
		int[] result = { plane, train, car, tem };
		return result;
	}

}
