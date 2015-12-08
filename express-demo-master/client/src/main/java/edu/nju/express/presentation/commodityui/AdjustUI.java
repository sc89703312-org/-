package edu.nju.express.presentation.commodityui;

import javax.swing.ImageIcon;

import edu.nju.express.presentation.MainPanel;

public class AdjustUI extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CommodityController controller;
	
	public AdjustUI(CommodityController c){
		
		this.bg = new ImageIcon("ui/image/combg.png").getImage();
		
		this.controller = c;
		
		this.add(new CommodityGuide(c));
		
	}
	
}
