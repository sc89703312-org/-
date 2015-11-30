package edu.nju.express.presentation.managerui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.StationVO;

public class OrganizationUI extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Font font = new Font("微软雅黑", Font.PLAIN, 16);
	static Color color = Color.white;
	static int width = 900, height = 600;
	static int y = 50; // 由标题栏高度决定
	static int x = 240;
	static int h = 160;

	private ArrayList<HallVO> hallList;
	private ArrayList<StationVO> stationList;

	private JButton addStation, deleteStation, addHall, deleteHall;
	private MyTablePanel table;
	private JPanel buttons;
	private ManageController controller;

	public OrganizationUI(ManageController c) {
		this.controller = c;

		this.add(new ManageGuide(c));

		initButtons();

		initData();

		initTable();
	}

	private void initButtons() {
		buttons = new JPanel();
		buttons.setBounds(x, y, width - x, height);
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 180, 40));
		buttons.setOpaque(false);

		addStation = new JButton("新增中转中心");
		addStation.setActionCommand("AddStationUI");
		addStation.addActionListener(controller);
		buttons.add(addStation);

		deleteStation = new JButton("删除中转中心");
		deleteStation.setActionCommand("DeleteStationUI");
		deleteStation.addActionListener(controller);
		buttons.add(deleteStation);

		addHall = new JButton("新增营业厅");
		addHall.setActionCommand("AddHallUI");
		addHall.addActionListener(controller);
		buttons.add(addHall);

		deleteHall = new JButton("删除营业厅");
		deleteHall.setActionCommand("DeleteHallUI");
		deleteHall.addActionListener(controller);
		buttons.add(deleteHall);

		this.add(buttons);
	}

	private void initTable() {
		String[] header = { "中转中心", "城市编号", "营业厅", "营业厅编号" };

		table = new MyTablePanel(header);
		table.getTable().setPreferredScrollableViewportSize(new Dimension(width - x -80, height - y - h));
		table.setBounds(x+30, y + h, width - x -60, height - y - h - 30);
		this.add(table);
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

	private void initData() {
		stationList = new ArrayList<StationVO>();
		stationList.add(new StationVO("025", "南京"));
		stationList.add(new StationVO("021", "上海"));
		hallList = new ArrayList<HallVO>();
		hallList.add(new HallVO("025001", "鼓楼"));
		hallList.add(new HallVO("025002", "仙林"));
		hallList.add(new HallVO("021001", "？"));
		hallList.add(new HallVO("021002", "？"));
		hallList.add(new HallVO("025001", "鼓楼"));
		hallList.add(new HallVO("025002", "仙林"));
		hallList.add(new HallVO("025001", "鼓楼"));
		hallList.add(new HallVO("025002", "仙林"));
		hallList.add(new HallVO("025001", "鼓楼"));
		hallList.add(new HallVO("025002", "仙林"));
	}
}
