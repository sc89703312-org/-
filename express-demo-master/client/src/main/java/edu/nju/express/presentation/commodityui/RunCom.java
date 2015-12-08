package edu.nju.express.presentation.commodityui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.blservice.CommodityBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.presentation.myUI.MyFrame;

public class RunCom {

	public static void main(String[] args){
		
		MyFrame f = new MyFrame();
		
		CommodityBlService service = DataFactory.createCommodityBlInstance();
		
		f.setBackground(new Color(0, 0, 0,0));
		f.setSize(900, 600);
        f.setLocationRelativeTo(null);
        f.setUndecorated(true);
   
        JPanel p = null;
        p = new EnterManageUI(new CommodityController(f), service.showArriveReceiptList());
        f.add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
