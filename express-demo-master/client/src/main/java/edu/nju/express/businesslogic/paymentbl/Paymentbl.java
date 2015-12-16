package edu.nju.express.businesslogic.paymentbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.blservice.Paymentblservice;
import edu.nju.express.businesslogic.balancebl.PaymentList.Info.PaymentInfo;
import edu.nju.express.businesslogic.bankingbl.Bankingbl;
import edu.nju.express.businesslogic.hallbl.info.PaymentOrderInfo;
import edu.nju.express.businesslogic.paymentbl.Info.BankingInfo;
import edu.nju.express.businesslogic.receiptbl.Info.PaymentApproveInfo;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.Paymentdataservice;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.log.LogController;
import edu.nju.express.po.LogMessage;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.po.Paymentpo;
import edu.nju.express.vo.BankingAccountVO;
import edu.nju.express.vo.Paymentvo;


/**
 * 
 * @author lenovo
 * @version 2015年12月9日22:41:49
 * 
 * 用于营业厅财务人员进行收款管理 包括新建收款单等
 */


public class Paymentbl implements Paymentblservice,PaymentInfo,PaymentApproveInfo,PaymentOrderInfo {

	
	
	/** 收款单PO的列表 */
	ArrayList<Paymentpo> tempArrayList = new ArrayList<Paymentpo>();
	
	/** 收款单VO的列表 */
	ArrayList<Paymentvo> tempVoList = new ArrayList<Paymentvo>();
	
	/** 收款单的数据实现*/
	Paymentdataservice paymentDataService ;
	
	/** 暂时存放的收款单对象 */
	private Paymentpo temp;
	
	/** 银行账户的业务逻辑 */
	BankingInfo account;
	
	public Paymentbl(BankingInfo account) {
		// TODO Auto-generated constructor stub
	
	paymentDataService =RMIHelper.getPaymentDataService();
	this.account = account;
	}
	
	
	/**
	 * @author lenovo
	 * @version 2015年12月9日22:44:10
	 * 创建收款单
	 * 
	 */
	@Override
	public ResultMessage createReceipt(Paymentvo vo) {
		// TODO Auto-generated method stub
		 
		boolean exsit = false;
		ResultMessage temp = ResultMessage.INVALID;
		
		ArrayList<BankingAccountVO> accounts = account.getAllAccounts();
		for(int i=0;i<accounts.size();i++){
			if(accounts.get(i).getName().equals(vo.getBankaccount())){
		       exsit =true;
		       break;
			}
		
		}
		
		if (!exsit) {

			return ResultMessage.INVALID;
		}
		
		else{
			
			LogController.insertLog(new LogMessage("建立收款单", LoginInfo.getUserName()));
			
		try {
			temp =paymentDataService.insert(convertVO(vo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		if(temp==ResultMessage.VALID)
			modify((int)vo.getPay(),vo.getBankaccount());
			
			
			
			

		
		return temp;
	}
	}
	
	
	/**
	 * @author lenovo
	 * @version 2015年12月9日22:44:47
	 * 根据ID获取对应收款单
	 * 
	 */
	@Override
	public Paymentvo getPayment(String id) {
		// TODO Auto-generated method stub
		
		
		try {
		temp=	paymentDataService.find(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return convertPO(temp);
	}

	@Override
	public void endPayment() {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * @author lenovo
	 * @version 2015年12月9日22:45:22
	 * 查看所有的收款单
	 */
	@Override
	public ArrayList<Paymentvo> viewAll() {
		// TODO Auto-generated method stub
		
		try {
			 tempArrayList=paymentDataService.getAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<tempArrayList.size();i++){
			tempVoList.add(convertPO(tempArrayList.get(i)));
		}
		
		
		
		return tempVoList;
	}
	
	/**
	 * @author lenovo
	 * @version 2015年12月9日22:45:43
	 * 返回所有未审批的收款单
	 */
	@Override
	public ArrayList<Paymentvo> viewAllPaymentSubmitted(){
		
		
		ArrayList<Paymentvo> temps = new ArrayList<>();
		
		try {
			for(Paymentpo po:paymentDataService.viewAllPaymentSubmitted()){
				temps.add(convertPO(po));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temps;
	}
	
	/**
	 * @author lenovo
	 * @version 2015年12月9日22:46:10
	 * 收款单审批通过
	 */
	@Override
	public void approvePayment(String id){
		try {
			Paymentpo po = paymentDataService.find(id);
		    po.approve();
		    paymentDataService.update(id, po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public Paymentpo convertVO(Paymentvo vo){
		
		return new Paymentpo(vo.getDate(), vo.getPay(),
				                        vo.getCourier_id(), vo.getOrder_id(),
				                        vo.getBankaccount());
		
	}
	
	
	public Paymentvo convertPO(Paymentpo po){
		
		return new Paymentvo(po.getDate(), po.getPay(),
				                        po.getCourier_id(), po.getOrder_id(),
				                        po.getBankaccount());
		
	}



	
	
	public void modify(int pay,String name){
		this.account.modify(pay,name);
	}



	/**
	 * @author lenovo
	 * @version 2015年12月9日22:46:34
	 * 根据营业厅编号来获取订单号列表
	 */
	@Override
	public ArrayList<String> getOrderListByHall(String HallId) {
		// TODO Auto-generated method stub
		try {
			return paymentDataService.viewAllOrderListByHall(HallId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	
	
}
