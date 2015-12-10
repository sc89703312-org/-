package edu.nju.express.presentation.managerui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.presentation.myUI.RefreshButton;
import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.StationVO;

public class OrganizationUI extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Icon addS1 = new ImageIcon("ui/button/addstation1.png");
	private static Icon addS2 = new ImageIcon("ui/button/addstation2.png");
	private static Icon delS1 = new ImageIcon("ui/button/deletestation1.png");
	private static Icon delS2 = new ImageIcon("ui/button/deletestation2.png");
	private static Icon addH1 = new ImageIcon("ui/button/addhall1.png");
	private static Icon addH2 = new ImageIcon("ui/button/addhall2.png");
	private static Icon delH1 = new ImageIcon("ui/button/deletehall1.png");
	private static Icon delH2 = new ImageIcon("ui/button/deletehall2.png");
	private static final Image bg = new ImageIcon("ui/image/manager/机构管理.png").getImage();
	
	private ArrayList<HallVO> hallList;
	private ArrayList<StationVO> stationList;

	private JButton addStation, deleteStation, addHall, deleteHall;
	private MyTablePanel table;
	private ManageController controller;

	public OrganizationUI(ManageController c) {
		this.controller = c;

		ManageGuide guide = new ManageGuide(c);
		guide.organization.setIcon(null);
		this.add(guide);

		initButtons();

		initTable();
		
		RefreshButton refresh = new RefreshButton();
		this.add(refresh);
		refresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
	}

	private void initButtons() {

		addStation = new JButton(addS1);
		addStation.setRolloverIcon(addS2);
		addStation.setBounds(210,537,100,30);
		addStation.setBorderPainted(false);
		addStation.setContentAreaFilled(false);
		addStation.setBorderPainted(false);
		addStation.setContentAreaFilled(false);
		addStation.setActionCommand("AddStationUI");
		addStation.addActionListener(controller);
		this.add(addStation);

		deleteStation = new JButton(delS1);
		deleteStation.setRolloverIcon(delS2);
		deleteStation.setBorderPainted(false);
		deleteStation.setContentAreaFilled(false);
		deleteStation.setBounds(360,537,100,30);
		deleteStation.setActionCommand("DeleteStationUI");
		deleteStation.addActionListener(controller);
		this.add(deleteStation);

		addHall = new JButton(addH1);
		addHall.setRolloverIcon(addH2);
		addHall.setBorderPainted(false);
		addHall.setContentAreaFilled(false);
		addHall.setBounds(510,537,100,30);
		addHall.setActionCommand("AddHallUI");
		addHall.addActionListener(controller);
		this.add(addHall);

		deleteHall = new JButton(delH1);
		deleteHall.setRolloverIcon(delH2);
		deleteHall.setBorderPainted(false);
		deleteHall.setContentAreaFilled(false);
		deleteHall.setBounds(660,537,100,30);
		deleteHall.setActionCommand("DeleteHallUI");
		deleteHall.addActionListener(controller);
		this.add(deleteHall);

	}

	private void initTable() {
		String[] header = { "中转中心", "城市编号", "营业厅", "营业厅编号" };

		table = new MyTablePanel(header);
		table.setRowHeight(30);
		table.getTable().setPreferredScrollableViewportSize(new Dimension(727,390));
		table.setBounds(128,107,726,422);
		this.add(table);
		
		
		initData();
	}

	private void initData() {
		stationList = controller.getStationList();
		hallList = controller.getHallList();
		
		DefaultTableModel model = table.getTableModel();

		String[] rowData = new String[4];

		Map<String, String> city = new HashMap<String, String>();
		
		for (StationVO vo : stationList) {
			city.put(vo.getId(), vo.getName());
		}
		
		for (HallVO vo : hallList) {
			rowData[2] = vo.getName();
			rowData[3] = vo.getId();
			rowData[1] = vo.getId().substring(0, 3);
			rowData[0] = city.get(rowData[1]);
			model.addRow(rowData);
		}
	}
	
	private void refresh(){
		int n = table.getTable().getRowCount();
		for(int i =0 ;i<n;i++){
			table.getTableModel().removeRow(0);
		}
		initData();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	}
}
