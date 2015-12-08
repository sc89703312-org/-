package edu.nju.express.presentation.commodityui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.blservice.CommodityBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.presentation.myUI.MyFrame;

public class Commodity_Frame extends MyFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Commodity_Frame() {
		// TODO Auto-generated constructor stub
	
        CommodityBlService service = DataFactory.createCommodityBlInstance();
		
		this.setBackground(new Color(0, 0, 0,0));
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
   
        JPanel p = null;
        p = new EnterManageUI(new CommodityController(this), service.showArriveReceiptList());
        this.add(p);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
