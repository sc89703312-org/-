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
import edu.nju.express.presentation.NumberValidation;
import edu.nju.express.presentation.UIController;
import edu.nju.express.presentation.myUI.WarningDialog;
import edu.nju.express.vo.ArrivalReceiptVO;
import edu.nju.express.vo.ArriveReceiptVO;
import edu.nju.express.vo.Balancevo;
import edu.nju.express.vo.ConstantVO;
import edu.nju.express.vo.DeliverReceiptVO;
import edu.nju.express.vo.DistanceVO;
import edu.nju.express.vo.EmployeeVO;
import edu.nju.express.vo.EnterReceiptVO;
import edu.nju.express.vo.ExitReceiptVO;
import edu.nju.express.vo.HallTransferReceiptVO;
import edu.nju.express.vo.HallVO;
import edu.nju.express.vo.Paymentvo;
import edu.nju.express.vo.ReceiptVOBase;
import edu.nju.express.vo.SalaryVO;
import edu.nju.express.vo.StationVO;
import edu.nju.express.vo.TransferReceiptVO;
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

			showEmployeeUI();
			
		} else if (e.getActionCommand().equals("OrganizationUI")) {

			frame.getContentPane().removeAll();
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
			currentPanel = new AddStationPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		} else if (e.getActionCommand().equals("DeleteStationUI")) {
			frame.getContentPane().removeAll();
			currentPanel = new DeleteStationPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			
		} else if (e.getActionCommand().equals("AddHallUI")) {

			frame.getContentPane().removeAll();
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
				WarningDialog.show("操作失败", "未选择任何单据");
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
			
			WarningDialog.show("操作成功", "薪水信息已更新");

		} else if (e.getActionCommand().equals("ModifyConstant")) {

			ConstantUI ui = (ConstantUI) currentPanel;

			
			if(ui.getPriceInput()==-1||ui.getVehicleCostInput()==null||ui.getVehicleLoadInput()==null)
				return;
			
			
			ArrayList<DistanceVO> newDistances = ((ConstantUI) currentPanel).getDistanceInput();
			if(newDistances == null){
				WarningDialog.show("操作失败","请检查城市间距离");
			}
				
			for (DistanceVO vo : newDistances) {

				constant.setDistance(vo.getId1(), vo.getId2(), vo.getDistance());
			}
			
			constant.setPrice(ui.getPriceInput());
			
			double[] cost = ui.getVehicleCostInput();
			constant.setVehicleCost(cost[0], cost[1], cost[2]);

			int[] load = ui.getVehicleLoadInput();
			constant.setVehicleLoad(load[0], load[1], load[2]);
			
			WarningDialog.show("操作成功", "常量信息已更新");
			
		} else if (e.getActionCommand().equals("AddEmployee")) {

			if(((AddEmployeePanel) currentPanel).getTextInput()==null)
				return;
			UserMessageVO vo = ((AddEmployeePanel) currentPanel).getTextInput();
			if (manage.addEmployee(vo.getId(), vo.getName(), vo.getRole()) == ResultMessage.INVALID) {
				WarningDialog.show("操作失败", "该人员编号已存在");
			}else{
				WarningDialog.show("操作成功", "等待管理员新建账号");
				showEmployeeUI();
			}
			
			
		} else if (e.getActionCommand().equals("DismissEmployee")) {

			
			String id = ((DismissEmployeePanel) currentPanel).getID();
			
			if(id == null)
				return;
			
			if(manage.dismissEmployee(id)==ResultMessage.INVALID)
				WarningDialog.show("操作失败", "该人员编号不存在");
			else{
				WarningDialog.show("操作成功", "等待管理员删除账号");
				showEmployeeUI();
			}
			

		} else if (e.getActionCommand().equals("AddStation")) {
			
			
			if( ((AddStationPanel) currentPanel).getTextInput()==null)
				return;
			
			StationVO vo = ((AddStationPanel) currentPanel).getTextInput();
			if(org.createStation(vo.getId(), vo.getName())==ResultMessage.INVALID)
				WarningDialog.show("操作失败", "该城市编号已存在");
			else{
				WarningDialog.show("操作成功", "请尽快更新城市间距离");
				frame.getContentPane().removeAll();
				currentPanel = new OrganizationUI(this);
				frame.add(currentPanel);
				frame.validate();
				frame.repaint();
			}
		} else if (e.getActionCommand().equals("DeleteStation")) {
			String id = ((DeleteStationPanel) currentPanel).getID();
			
			if(id == null)
				return;
			
			
			if (org.deleteStation(id) == ResultMessage.INVALID)
				WarningDialog.show("操作失败", "该城市编号不存在");
			else {
				WarningDialog.show("操作成功", "机构列表已更新");
				frame.getContentPane().removeAll();
				currentPanel = new OrganizationUI(this);
				frame.add(currentPanel);
				frame.validate();
				frame.repaint();
			}

		} else if (e.getActionCommand().equals("AddHall")) {
			if(((AddHallPanel) currentPanel).getTextInput()==null)
				return ;
			
			HallVO vo = ((AddHallPanel) currentPanel).getTextInput();
			if (org.createHall(vo.getId(), vo.getName()) == ResultMessage.INVALID)
				WarningDialog.show("操作失败", "该营业厅已存在");
			else {
				WarningDialog.show("操作成功", "机构列表已更新");
				frame.getContentPane().removeAll();
				currentPanel = new OrganizationUI(this);
				frame.add(currentPanel);
				frame.validate();
				frame.repaint();
			}
		} else if (e.getActionCommand().equals("DeleteHall")) {
			String id = ((DeleteHallPanel) currentPanel).getID();
			if(id==null)
				return;
			if(org.deleteHall(id)==ResultMessage.INVALID)
				WarningDialog.show("操作失败", "该营业厅编号不存在");
			else{
				WarningDialog.show("操作成功", "机构列表已更新");
				frame.getContentPane().removeAll();
				currentPanel = new OrganizationUI(this);
				frame.add(currentPanel);
				frame.validate();
				frame.repaint();
			}
		}
	}

	public void viewReceiptUI(String type, ReceiptVOBase vo) {
		System.out.println(type);
		System.out.println(vo.getDate());
		switch (type) {
		case "收款单":
			frame.getContentPane().removeAll();
			currentPanel = new PaymentReceipt(this, (Paymentvo)vo);
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
			frame.getContentPane().removeAll();
			currentPanel = new StationArrivalReceipt(this, (ArriveReceiptVO) vo);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			break;
		case "中转中心中转单":
			frame.getContentPane().removeAll();
			currentPanel = new StationTransReceipt(this,(TransferReceiptVO)vo);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			break;
		case "中转中心入库单":
			frame.getContentPane().removeAll();
			currentPanel = new ComEnterReceipt(this,(EnterReceiptVO)vo);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			break;
		case "中转中心出库单":
			frame.getContentPane().removeAll();
			currentPanel = new ComQuitReceipt(this,(ExitReceiptVO)vo);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			break;
		case "营业厅到达单":
			frame.getContentPane().removeAll();
			currentPanel = new HallArrivalReceipt(this,(ArrivalReceiptVO)vo);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			break;
		case "营业厅派送单":
			frame.getContentPane().removeAll();
			currentPanel = new DeliverReceipt(this,(DeliverReceiptVO)vo);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
			break;
		case "营业厅装车单":
			frame.getContentPane().removeAll();
			currentPanel = new HallTransReceipt(this,(HallTransferReceiptVO)vo);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
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

	private void showEmployeeUI(){
		frame.getContentPane().removeAll();
		currentPanel = new EmployeeListUI(this);
		frame.add(currentPanel);
		frame.validate();
		frame.repaint();
	}
}
