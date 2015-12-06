package edu.nju.express.businesslogic;

import edu.nju.express.businesslogic.accountbl.Accountbl;
import edu.nju.express.businesslogic.balancebl.CostList.CostList;
import edu.nju.express.businesslogic.balancebl.CreateCost.CostControlbl;
import edu.nju.express.businesslogic.balancebl.PaymentList.PaymentList;
import edu.nju.express.businesslogic.balancebl.ViewPayment.ViewPaymentbl;
import edu.nju.express.businesslogic.balancebl.balance.Balancebl;
import edu.nju.express.businesslogic.bankingbl.Bankingbl;
import edu.nju.express.businesslogic.commoditybl.CommodityBl;
import edu.nju.express.businesslogic.hallbl.HallBL;
import edu.nju.express.businesslogic.hallbl.HallReceiptBL;
import edu.nju.express.businesslogic.login.Login;
import edu.nju.express.businesslogic.logisticsbl.LogisticsBL;
import edu.nju.express.businesslogic.orderbl.OrderBL;
import edu.nju.express.businesslogic.paymentbl.Paymentbl;
import edu.nju.express.businesslogic.receiptbl.ReceiptBl;
import edu.nju.express.businesslogic.stationbl.StationBl;
import edu.nju.express.businesslogic.stationbl.StationReceiptBl;
import edu.nju.express.businesslogic.strategybl.constantsettingbl.ConstantSettingBl;
import edu.nju.express.businesslogic.strategybl.managementbl.ManagementBl;
import edu.nju.express.businesslogic.strategybl.organizationbl.OrganizationBl;
import edu.nju.express.businesslogic.strategybl.salarysettingbl.SalarySettingBl;
import edu.nju.express.businesslogic.userbl.UserBl;
import edu.nju.express.businesslogic.vehiclebl.CarControl;
import edu.nju.express.businesslogic.vehiclebl.Vehiclebl;
import edu.nju.express.po.LoginInfo;

public class DataFactory {

	public static Bankingbl createBankingInstance(){
		return new Bankingbl();
	}
	
	
	public static HallBL createHallBLInstance(){
		return new HallBL();
	}
	
	public static OrderBL createOrderBLInstance(){
		return new OrderBL();
	}
	
	
	public static StationBl createStationBLInstance(){
		return new StationBl();
	}
	
	
	public static ConstantSettingBl createConstantSettingBLInstance(){
		return new ConstantSettingBl();
	}
	
	
	public static SalarySettingBl createSalarySettingBlInstance(){
		return new SalarySettingBl();
	}
	
	
	public static UserBl createUserBlInstance(){
		return new UserBl();
	}
	
	
	public static CarControl createCarBLInstance(){
		return new CarControl();
	}
	
	public static Vehiclebl createDriverInstance(){
		return new Vehiclebl();
	}
	
	
	public static Login createLoginBLInstance(){
		return new Login();
	}
	
	
	public static CostControlbl createCostInstance(){
		return new CostControlbl(createBankingInstance());
	}
	
	public static Paymentbl createPaymentBLInstance(){
		return new Paymentbl(createBankingInstance());
	}
	
	
	public static ViewPaymentbl createViewPaymentblInstance(){
		return new ViewPaymentbl(new PaymentList(createPaymentBLInstance()));
	}
	
	
	public static Balancebl createBalanceBLInstance(){
		return new Balancebl(new PaymentList(createPaymentBLInstance()),
				new CostList(createCostInstance()));
	}
	
	
	
	public static LogisticsBL createLogisticBLInstance(){
		return new LogisticsBL(createOrderBLInstance());
	}
	
	
	public static ManagementBl createManagementBlInstance(){
		return new ManagementBl(createUserBlInstance());
	}
	
	
	public static StationReceiptBl createStationReceiptBlInstance(){
		return new StationReceiptBl(createOrderBLInstance(), createOrderBLInstance());
	}
	
	public static HallReceiptBL createHallReceiptBLInstance(){
		return new HallReceiptBL(createPaymentBLInstance(),
				createOrderBLInstance(),
				createDriverInstance(), 
				createOrderBLInstance());
	}
	
	public static CommodityBl createCommodityBlInstance(){
		return new CommodityBl(createStationReceiptBlInstance(), LoginInfo.getUserID());
	}
	
	
	public static OrganizationBl createOrganizationBl(){
		return new OrganizationBl(createStationBLInstance(), createHallBLInstance(), createConstantSettingBLInstance());
	}
	
	
	public static ReceiptBl createReceiptBlInstance(){
		return new ReceiptBl(createCommodityBlInstance(),createCostInstance(),createHallReceiptBLInstance(),
				createPaymentBLInstance(), createStationReceiptBlInstance());
	}
	
	public static Accountbl createAccountblInstance(){
		return new Accountbl(createManagementBlInstance(),
				createOrganizationBl(), createCarBLInstance(),
				createBankingInstance(), createCommodityBlInstance());
	}
}
