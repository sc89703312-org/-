package edu.nju.express.presentation.managerui.constantui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.managerui.ManageController;
import edu.nju.express.presentation.managerui.ManageGuide;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.MyEditableTable;
import edu.nju.express.presentation.myUI.MyTextField;
import edu.nju.express.vo.ConstantVO;

public class ConstantUI extends MainPanel{

	private static final long serialVersionUID = 1L;
	static Font font = new Font("黑体", Font.PLAIN, 14);
	static String split = " ";
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
	JTable table;
	private String price1,price2,price3;
	private String vanCost, railwayCost, airplaneCost;
	private String vanLoad, railwayLoad, airplaneLoad;
	private ArrayList<String> cityList;
	private ArrayList<String> cityDistance;
	ConstantVO constantVO;
	
	public ConstantUI(ManageController c) {
		this.setOpaque(false);
		
		this.controller = c;
		initData();

		guide = new ManageGuide(controller);
		this.add(guide);
		
		initFields();
		
		initTable();
	}

	private void initTable() {
		String[] header = {"城市1","-","城市2","：","距离","公里"};
		table = new MyEditableTable(header);
		
		String[] rowdata = new String[6];
		for(int i =0;i<cityList.size()-1;i++){
			for(int j = i+1;j<cityList.size();j++){
				rowdata[0] = cityList.get(i);
				rowdata[1] = "-";
				rowdata[2] = cityList.get(j);
				rowdata[3] = "：";
				rowdata[4] = cityDistance.get(i).split(split)[j];
				rowdata[5] = "公里";
				((DefaultTableModel)table.getModel()).addRow(rowdata);
			}
		}
		table.setPreferredScrollableViewportSize(new Dimension(166,125));
		JScrollPane p = new JScrollPane(table);
		p.setBorder(new EmptyBorder(0, 0, 0, 0));
		p.setBounds(x+200,y+70,240,125);
		p.setOpaque(false);
		p.getViewport().setOpaque(false);
		this.add(p);
	}

	private void initFields() {
		fieldsPanel = new JPanel();
		fieldsPanel.setBounds(x, y+180, width-x, 300);
		fieldsPanel.setOpaque(false);;
		fieldsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 160, 60));
		
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
		
		cityList = new ArrayList<String>();
		cityList.add("南京");
		cityList.add("上海");
		cityList.add("北京");
		cityList.add("广州");
		cityList.add("深圳");
		
		cityDistance = new ArrayList<String>();
		cityDistance.add("0 100 200 300 400");
		cityDistance.add("100 0 300 400 500");
		cityDistance.add("200 300 0 400 600");
		cityDistance.add("300 400 400 0 700");
		cityDistance.add("400 500 600 700 0");
	}
	
	public ConstantVO getInput(){
		return new ConstantVO(cityList, cityDistance,
				price1, price2, price3,
				vanCost, railwayCost, airplaneCost,
				vanLoad, railwayLoad, airplaneLoad);
		
	}
}
