package edu.nju.express.presentation.managerui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.blservice.ConstantSettingBlService;
import edu.nju.express.blservice.ManagementBlService;
import edu.nju.express.blservice.OrganizationBlService;
import edu.nju.express.blservice.ReceiptBlService;
import edu.nju.express.blservice.SalarySettingBlService;
import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.log.ui.warning.PromptDialog;
import edu.nju.express.presentation.NumberValidation;
import edu.nju.express.presentation.UIController;
import edu.nju.express.presentation.myUI.WarningDialog;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.ConstantVO;
import edu.nju.express.vo.DistanceVO;
import edu.nju.express.vo.EmployeeVO;
import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.ReceiptVOBase;
import edu.nju.express.vo.SalaryVO;
import edu.nju.express.vo.StationVO;
import edu.nju.express.vo.UserMessageVO;

public class ManageController implements UIController {

	private JPanel currentPanel;
	private JFrame frame;
	private ManagementBlService manage;
	private OrganizationBlService org;
	private ConstantSettingBlService constant;
	public ReceiptBlService receipt;
	private SalarySettingBlService salary;

	public ManageController(JFrame f) {
		this.frame = f;
		currentPanel = (JPanel) f.getContentPane();
		manage = DataFactory.createManagementBlInstance();
		org = DataFactory.createOrganizationBl();
		receipt = DataFactory.createReceiptBlInstance();
		salary = DataFactory.createSalarySettingBlInstance();
		constant = DataFactory.createConstantSettingBLInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());

		if (e.getActionCommand().equals("ReceiptUI")) {

			frame.getContentPane().removeAll();
			;
			currentPanel = new ReceiptApprovalUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("EmployeeUI")) {

			frame.getContentPane().removeAll();
			;
			currentPanel = new EmployeeListUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("OrganizationUI")) {

			frame.getContentPane().removeAll();
			;
			currentPanel = new OrganizationUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("SalaryUI")) {

			frame.getContentPane().removeAll();
			;
			currentPanel = new SalaryUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("ConstantUI")) {

			frame.getContentPane().removeAll();
			;
			currentPanel = new ConstantUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("AddEmployeeUI")) {

			frame.getContentPane().removeAll();
			;
			currentPanel = new AddEmployeePanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("DismissEmployeeUI")) {
			frame.getContentPane().removeAll();
			;
			currentPanel = new DismissEmployeePanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("AddStationUI")) {
			frame.getContentPane().removeAll();
			;
			currentPanel = new AddStationPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("DeleteStationUI")) {
			frame.getContentPane().removeAll();
			;
			currentPanel = new DeleteStationPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("AddHallUI")) {

			frame.getContentPane().removeAll();
			;
			currentPanel = new AddHallPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("DeleteHallUI")) {

			frame.getContentPane().removeAll();
			currentPanel = new DeleteHallPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("Approve")) {

			currentPanel = (JPanel) (((JButton) e.getSource()).getParent());
			ArrayList<String> list = ((ReceiptApprovalUI) currentPanel).getIDtoApprove();
			if (list.isEmpty())
				WarningDialog.show("", "未选择任何单据");
			for (String id : list) {
				receipt.approve(id);
			}

		} else if (e.getActionCommand().equals("SetSalary")) {

			SalaryUI ui = (SalaryUI) currentPanel;

			String[] input = ui.getText();

			if (!NumberValidation.isPositiveDecimal(input[0])) {
				ui.clerkField.setError();
				return;
			}
			if (!NumberValidation.isPositiveDecimal(input[1])) {
				ui.driverField.setError();
				return;
			}
			if (!NumberValidation.isPositiveDecimal(input[2])) {
				ui.driverField.setError();
				return;
			}

			salary.setClerkSalary(Double.parseDouble(input[0]));
			salary.setDriverWage(Double.parseDouble(input[1]));
			salary.setPostmanWage(Double.parseDouble(input[2]));

		} else if (e.getActionCommand().equals("ModifyConstant")) {

			ConstantUI ui = (ConstantUI) currentPanel;

			constant.setPrice(ui.getPriceInput());

			/*
			 * constant.setVehicleCost(ui.getVehicleCostInput()[0],
			 * ui.getVehicleCostInput()[1], ui.getVehicleCostInput()[2]);
			 * constant.setVehicleLoad(ui.getVehicleLoadInput()[0],
			 * ui.getVehicleLoadInput()[1], ui.getVehicleLoadInput()[2]);
			 */

			ArrayList<DistanceVO> newDistances = ((ConstantUI) currentPanel).getDistanceInput();
			for (DistanceVO vo : newDistances) {

				constant.setDistance(vo.getId1(), vo.getId2(), vo.getDistance());

			}
		} else if (e.getActionCommand().equals("AddEmployee")) {

			UserMessageVO vo = ((AddEmployeePanel) currentPanel).getTextInput();
			if (manage.addEmployee(vo.getId(), vo.getName(), vo.getRole()) == ResultMessage.INVALID) {
				System.out.println(1322);
				WarningDialog.show("无法新增人员", "该人员编号已存在");
			}

		} else if (e.getActionCommand().equals("DismissEmployee")) {

			String id = ((DismissEmployeePanel) currentPanel).getID();
			manage.dismissEmployee(id);

		} else if (e.getActionCommand().equals("AddStation")) {
			StationVO vo = ((AddStationPanel) currentPanel).getTextInput();
			System.out.println(vo.getId() + " " + vo.getName());
			System.out.println(org.createStation(vo.getId(), vo.getName()));
		} else if (e.getActionCommand().equals("DeleteStation")) {
			System.out.println(org.deleteStation(((DeleteStationPanel) currentPanel).getID()));
		} else if (e.getActionCommand().equals("AddHall")) {
			HallVO vo = ((AddHallPanel) currentPanel).getTextInput();
			System.out.println(org.createHall(vo.getId(), vo.getName()));
		} else if (e.getActionCommand().equals("DeleteHall")) {
			System.out.println(org.deleteHall(((DeleteHallPanel) currentPanel).getID()));
		}

	}

	public void viewReceiptUI(String type, ReceiptVOBase vo) {
		System.out.println(type);
		System.out.println(vo.getDate());
		switch (type) {
		case "收款单":
			frame.getContentPane().removeAll();
			// currentPanel = new BalanceReceipt(this, (Balancevo)vo);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			break;
		case "付款单":
			frame.getContentPane().removeAll();
			currentPanel = new BalanceReceipt(this, (Balancevo) vo);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			break;
		case "中转中心到达单":
			break;
		case "中转中心中转单":
			break;
		case "中转中心入库单":
			break;
		case "中转中心出库单":
			break;
		case "营业厅到达单":
			break;
		case "营业厅派送单":
			break;
		case "营业厅装车单":
			break;
		default:
			break;

		}

	}

	ArrayList<EmployeeVO> getEmployeeList() {
		return manage.viewEmployeeList();
	}

	SalaryVO getSalaryData() {
		return salary.getSalary();
	}

	ConstantVO getConstantData() {
		return constant.getConstant();
	}

	ArrayList<StationVO> getStationList() {
		ArrayList<StationVO> stations = org.viewStationList();
		for (StationVO vo : stations)
			System.out.println(vo.getId() + " " + vo.getName());
		return org.viewStationList();
	}

	ArrayList<HallVO> getHallList() {
		ArrayList<HallVO> halls = org.viewHallList();
		for (HallVO vo : halls)
			System.out.println(vo.getId() + " " + vo.getName());
		return org.viewHallList();
	}

	public int getMessages() {
		return receipt.view().size();
	}

}
