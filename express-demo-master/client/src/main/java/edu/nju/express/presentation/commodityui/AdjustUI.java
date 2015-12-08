package edu.nju.express.presentation.commodityui;

import edu.nju.express.presentation.MainPanel;

public class AdjustUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CommodityController controller;
	
	public AdjustUI(CommodityController c){
		
		this.controller = c;
		
		this.add(new CommodityGuide(c));
		
	}
	
}
