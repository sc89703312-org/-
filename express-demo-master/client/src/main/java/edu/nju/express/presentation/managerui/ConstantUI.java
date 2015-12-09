package edu.nju.express.presentation.managerui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyEditableTable;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.vo.ConstantVO;
import edu.nju.express.vo.DistanceVO;

public class ConstantUI extends MainPanel{

	private static final long serialVersionUID = 1L;
	private static final Image bg = new ImageIcon("ui/image/manager/常量制定.png").getImage();
	private static Font font = new Font("黑体", Font.PLAIN, 18);
	private static Color color = new Color(44,62,80);
	private static String split = " ";
	private static int width = 900, height = 600;
	
	ManageController controller;
	ConstantUI ui;
	
	private LabelTextField priceStd;
	private JLabel priceEco,priceFast;
	private LabelTextField vanCField;
	private LabelTextField railCField;
	private LabelTextField airCField;
	private LabelTextField vanLField;
	private LabelTextField railLField;
	private LabelTextField airLField;
	private MyEditableTable table;
	private JPanel p;
	private ConfirmButton confirm;
	
	private String price1, price2,price3;
	private String vanCost, railwayCost, airplaneCost;
	private String vanLoad, railwayLoad, airplaneLoad;
	private ArrayList<String> cityList;
	private ArrayList<String> cityDistance;
	private ConstantVO vo;
	
	public ConstantUI(ManageController c) {
		ui = this;
		this.controller = c;
		this.add(new ManageGuide(controller));
		
		p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setOpaque(false);
		p.setBounds(128, 112, 715, 1000);
		p.setOpaque(false);
		
		JScrollPane s = new JScrollPane();
		s.setViewportView(p);
		s.setOpaque(false);
		s.getViewport().setOpaque(false);
		s.setBackground(new Color(255,255,255,50));
		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		s.setBounds(128, 112, 726, 422);
		s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		s.getVerticalScrollBar().setUI(new MyScrollBarUI());
		s.getVerticalScrollBar().setOpaque(false);
		this.add(s);
		
		initData();
		
		JLabel l1 = new JLabel("·城市间距离(双击数字可修改)：");
		l1.setName("title");
		p.add(l1);
		initTable();
		table.setPreferredScrollableViewportSize(new Dimension(248,90));
		JScrollPane sp = new JScrollPane(table);
		sp.setBorder(new EmptyBorder(0, 0, 0, 0));
		sp.setOpaque(false);
		sp.getViewport().setOpaque(false);
		sp.getVerticalScrollBar().setUI(new MyScrollBarUI());
		sp.setPreferredSize(new Dimension( 260, 120));
		JPanel p0 = new JPanel();
		p0.setOpaque(false);
		p0.add(sp);
		p0.setName("Table");
		p.add(p0);
		p.add(new JLabel());
		
		
		JLabel l2 = new JLabel("·快递价格：        ");
		l2.setName("title");
		p.add(l2);
		initTable();
		priceEco = new JLabel("经济快递：     "+price2+"      元");
		priceFast = new JLabel("次晨特快：     "+price3+"      元");
		priceEco.setFont(font);
		priceEco.setOpaque(false);
		priceEco.setForeground(color);
		priceFast.setFont(font);
		priceFast.setOpaque(false);
		priceFast.setForeground(color);
		priceEco.setPreferredSize(new Dimension(400,40));
		priceFast.setPreferredSize(new Dimension(400,40));
		priceEco.setHorizontalAlignment(JLabel.CENTER);
		priceFast.setHorizontalAlignment(JLabel.CENTER);
		priceStd = new LabelTextField("标准快递： ", -1," 元");
		priceStd.setText(price1);
		priceStd.getTextField().addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				super.focusLost(e);
				Double price = Double.parseDouble(priceStd.getText());
				
				BigDecimal eco = new BigDecimal(price/23*18);
				price2 = eco.setScale(2,BigDecimal.ROUND_HALF_UP)+"";
				
				BigDecimal fast = new BigDecimal(price/23*25);
				price3 = fast.setScale(2, BigDecimal.ROUND_HALF_UP)+"";
				
				priceEco.setText("经济快递：     "+price2+"      元");
				priceFast.setText("次晨特快：     "+price3+"      元");
				
			}
		});	
		priceStd.setBounds(165, 160, 400, 40);
		priceEco.setBounds(165, 200, 400, 40);
		priceFast.setBounds(165, 240,400,40);
		JPanel p1 = new JPanel();
		p1.setOpaque(false);
		p1.add(priceEco);
		JPanel p2 = new JPanel();
		p2.setOpaque(false);
		p2.add(priceFast);
		p.add(priceStd);
		p.add(p1);
		p.add(p2);
		p.add(new JLabel());
		
		
		JLabel l3 = new JLabel("·运输成本：");
		l3.setBounds(120, 270, 400, 40);
		l3.setName("title");
		p.add(l3);
		vanCField = new LabelTextField("公路:", -1, "元/公里·吨");
		vanCField.setText(vanCost);
		railCField = new LabelTextField("铁路:",-1,"元/公里·吨");
		railCField.setText(railwayCost);
		airCField = new LabelTextField("航空:", -1, "元/公里·吨");
		airCField.setText(airplaneCost);
		vanCField.setBounds(165, 320, 400, 40);
		railCField.setBounds(165, 360,  400, 40);
		airCField.setBounds(165, 400, 400,40);
		p.add(vanCField);
		p.add(railCField);
		p.add(airCField);
		p.add(new JLabel());
		
		
		JLabel l4 = new JLabel("·交通载量：");
		l4.setName("title");
		p.add(l4);
		vanLField = new LabelTextField("公路:", -1, "吨");
		vanLField.setText(vanLoad);
		railLField = new LabelTextField("铁路:",-1,"吨");
		railLField.setText(railwayLoad);
		airLField = new LabelTextField("航空:", -1, "吨");
		airLField.setText(airplaneLoad);
		vanLField.setBounds(165, 480, 400, 40);
		railLField.setBounds(165, 520,  400, 40);
		airLField.setBounds(165, 560, 400,40);
		p.add(vanLField);
		p.add(railLField);
		p.add(airLField);
		p.add(new JLabel());
		
		for(Component co : p.getComponents()){
			co.setBackground(new Color(0,0,0,0));
			if(co.getName()==null)
				co.setPreferredSize(new Dimension(400,40));
			else if(co.getName().equals("title")){
				co.setFont(new Font("黑体",font.PLAIN,18));
				co.setForeground(new Color(39,194,156));
				co.setPreferredSize(new Dimension(480,48));
				((JLabel)co).setHorizontalAlignment(JLabel.LEFT);
			}
		}
		
		
		

	}


	private void initTable() {
		String[] header = {"城市1","-","城市2","：","距离","公里"};
		
		DefaultTableModel model = new DefaultTableModel(null,header){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column == 4)
					return true;
				return false;
			}
		};
		
		table = new MyEditableTable(header,model);
		
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
		
		
		confirm = new ConfirmButton();
		this.add(confirm);
		confirm.addActionListener(controller);
		confirm.setActionCommand("ModifyConstant");
	}


	private void initData() {
		vo = controller.getConstantData();
		price1 = vo.getPriceStandard();
		price2 = vo.getPriceLow();
		price3 =vo.getPriceHigh();
		vanCost=vo.getVanCost(); 
		railwayCost=vo.getRailwayCost(); 
		airplaneCost=vo.getAirplaneCost();
		vanLoad=vo.getVanLoad(); 
		railwayLoad=vo.getRailwayLoad(); 
		airplaneLoad=vo.getAirplaneLoad();
		cityList = vo.getCityList();
		cityDistance = vo.getCityDistance();
	}
	
	public ArrayList<DistanceVO> getDistanceInput(){
		
		ArrayList<DistanceVO> tempList = new ArrayList<>();
		
		
		ArrayList<String> infos = table.getEditedRows();
		int m=0;
		
		for(int i =0;i<cityList.size()-1;i++){
			for(int j = i+1;j<cityList.size();j++){
				tempList.add(new DistanceVO(cityList.get(i), cityList.get(j), Double.parseDouble(infos.get(m))));
			    m++;
			}
		}
		
		return tempList;
	}
	
	public double getPriceInput(){
		return Double.parseDouble(priceStd.getText());
	}
	
	public double[] getVehicleCostInput(){
		double[] input1 = new double[3];
		input1[0] =  Double.parseDouble(vanCField.getText());
		input1[1] =  Double.parseDouble(railCField.getText());
		input1[2] =  Double.parseDouble(airCField.getText());
		return input1;
	}
	
	public int[] getVehicleLoadInput(){
		int[] input2 = new int[3];
		input2[0] =  Integer.parseInt(vanLField.getText());
		input2[1] =  Integer.parseInt(railLField.getText());
		input2[2] =  Integer.parseInt(airLField.getText());
		return input2;
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	}
}
