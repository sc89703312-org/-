package edu.nju.express.presentation.managerui.organizationui;

import java.awt.Color;
import java.awt.Font;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.managerui.ManageController;

public class AddStationPanel extends MainPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Font font = new Font("黑体", Font.PLAIN, 16);
	static Color color = Color.white;
	static int width = 900, height = 600;
	static int y = 50; // 由标题栏高度决定
	static int x=240;
	static int h=200;
	

	private ManageController controller;
	
	public AddStationPanel(ManageController c) {
		this.controller = c;
		
	}
}
