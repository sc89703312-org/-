package edu.nju.express.presentation.managerui.constantui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.managerui.ManageController;
import edu.nju.express.presentation.managerui.ManageGuide;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.MyTextField;

public class ConstantUI extends MainPanel{

	private static final long serialVersionUID = 1L;
	static Font font = new Font("微软雅黑", Font.PLAIN, 16);
	static Color color = Color.white;
	static int width = 900, height = 600;
	static int y = 50; // 由标题栏高度决定

	ManageController controller;
	
	MyTextField priceField;
	MyTextField vanCostField;
	MyTextField railwayCostField;
	MyTextField airplaneCostField;
	MyTextField vanLoadField;
	MyTextField railwayLoadField;
	MyTextField airplaneLoadField;
	
	ConfirmButton distanceConfirm;
	ConfirmButton priceConfirm;
	ConfirmButton costConfirm;
	ConfirmButton loadConfirm;
	
	JPanel distancePanel;
	JPanel pricePanel;
	JPanel costPanel;
	JPanel loadPanel;
	ManageGuide guide;
	
	public ConstantUI(ManageController c) {
		this.setOpaque(false);
		
		this.controller = c;
		initData();

		guide = new ManageGuide(controller);
		this.add(guide);
	}

	private void initData() {
		
	}
}
