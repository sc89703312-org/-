package edu.nju.express.presentation.managerui.constantui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.managerui.ManageController;
import edu.nju.express.presentation.managerui.ManageGuide;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.MyTextField;

public class ConstantUI extends MainPanel{

	private static final long serialVersionUID = 1L;
	static Font font = new Font("黑体", Font.PLAIN, 14);
	static Color color = Color.white;
	static int width = 900, height = 600;
	static int y = 50; // 由标题栏高度决定
	static int x =240;

	ManageController controller;
	
	MyTextField priceField1,priceField2,priceField3;
	MyTextField vanCostField;
	MyTextField railwayCostField;
	MyTextField airplaneCostField;
	MyTextField vanLoadField;
	MyTextField railwayLoadField;
	MyTextField airplaneLoadField;
	
	ConfirmButton distanceConfirm;
	ConfirmButton priceConfirm;
	ConfirmButton LoadConfirm;
	ConfirmButton loadConfirm;
	
	JPanel fieldsPanel;
	JPanel buttonsPanel;
	ManageGuide guide;
	
	private String price1,price2,price3;
	private String vanCost, railwayCost, airplaneCost;
	private String vanLoad, railwayLoad, airplaneLoad;
	
	public ConstantUI(ManageController c) {
		this.setOpaque(false);
		
		this.controller = c;
		initData();

		guide = new ManageGuide(controller);
		this.add(guide);
		
		initFields();
		
	}

	private void initFields() {
		fieldsPanel = new JPanel();
		fieldsPanel.setBounds(x, y, width-x, height-y);
		fieldsPanel.setOpaque(false);;
		fieldsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 160, 80));
		
		priceField1 = new MyTextField(4);
		priceField1.setText(price1);
		priceField1.setOpaque(false);
		fieldsPanel.add(priceField1);
		
		priceField2 = new MyTextField(4);
		priceField2.setText(price2);
		priceField2.setOpaque(false);
		fieldsPanel.add(priceField2);
		
		priceField3 = new MyTextField(4);
		priceField3.setText(price3);
		priceField3.setOpaque(false);
		fieldsPanel.add(priceField3);
		
		vanCostField = new MyTextField(4);
		vanCostField.setText(vanCost);
		vanCostField.setOpaque(false);
		fieldsPanel.add(vanCostField);
		
		railwayCostField = new MyTextField(4);
		railwayCostField.setText(railwayCost);
		railwayCostField.setOpaque(false);
		fieldsPanel.add(railwayCostField);
		
		airplaneCostField = new MyTextField(4);
		airplaneCostField.setText(airplaneCost);
		airplaneCostField.setOpaque(false);
		fieldsPanel.add(airplaneCostField);
		
		vanLoadField = new MyTextField(6);
		vanLoadField.setText(vanLoad);
		vanLoadField.setOpaque(false);
		fieldsPanel.add(vanLoadField);
		
		railwayLoadField = new MyTextField(6);
		railwayLoadField.setText(railwayLoad);
		railwayLoadField.setOpaque(false);
		fieldsPanel.add(railwayLoadField);
		
		airplaneLoadField = new MyTextField(6);
		airplaneLoadField.setText(airplaneLoad);
		airplaneLoadField.setOpaque(false);
		fieldsPanel.add(airplaneLoadField);
		
		this.add(fieldsPanel);
	}

	private void initData() {
		price1 = "23";
		price2 ="18";
		price3 ="25";
		vanCost="2"; 
		railwayCost="0.2"; 
		airplaneCost="1000";
		vanLoad="1000"; 
		railwayLoad="200000"; 
		airplaneLoad="5000";
		
	}
}
