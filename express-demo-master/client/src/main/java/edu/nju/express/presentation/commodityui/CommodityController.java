package edu.nju.express.presentation.commodityui;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.blservice.CommodityBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.presentation.UIController;

public class CommodityController implements UIController{
	
	JPanel currentPanel;
	JFrame frame;
	
	CommodityBlService service;
	
	public CommodityController(JFrame frame){
		this.frame = frame;
		//service = DataFactory.createCommodityBlInstance();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
