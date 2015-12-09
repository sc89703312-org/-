package edu.nju.express.businesslogic.vehiclebl;

import java.rmi.RemoteException;

import edu.nju.express.blservice.Vehicleblservice;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.dataservice.*;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.Driverpo;
import edu.nju.express.vo.Drivervo;

/**
 * 
 * @author lenovo
 * @version 2015年12月9日22:49:41
 * 
 * 用于营业厅业务员进行司机信息管理
 * 包括对司机进行增删改查
 */

public class Vehiclebl implements Vehicleblservice{

	vehicledataservice vehicledataservice ;
	
	
	public Vehiclebl() {
		// TODO Auto-generated constructor stub
	vehicledataservice = RMIHelper.getVehicleDataService();
	}
	
	/**
	 * @author lenovo
	 * @version 2015年12月9日22:50:34
	 * 增加司机
	 */
	@Override
	public ResultMessage addDriver(Drivervo vo) {
		// TODO Auto-generated method stub
		try {
			if(vehicledataservice.findDri(vo.getId())!=null){
				System.out.println("Sorry the id of driver has been exsited");
				return ResultMessage.INVALID;
			}else {
				System.out.println("The id is valid");
				vehicledataservice.insertDri(convertVO(vo));
			}
			  
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ResultMessage.VALID;
	}

	/**
	 * @author lenovo
	 * @version 2015年12月9日22:50:34
	 * 删除司机
	 */
	@Override
	public ResultMessage deleteDriver(String id) {
		// TODO Auto-generated method stub
		
		try {
			if(vehicledataservice.findDri(id)!=null){
				System.out.println("The id of driver exsits");
				vehicledataservice.deleteDri(id);
			}else {
				System.out.println("The id of driver doesn't exsit");
				return ResultMessage.INVALID;
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.VALID;
	}

	@Override
	public ResultMessage modifyDriver(String id, Drivervo vo) {
		// TODO Auto-generated method stub
		
		try {
			if(vehicledataservice.findDri(id)!=null){
				vehicledataservice.updateDri(id, convertVO(vo));
			}else {
				System.out.println("The id doesn't exsit");
				return ResultMessage.INVALID;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ResultMessage.VALID;
	}

	

	/**
	 * @author lenovo
	 * @version 2015年12月9日22:50:34
	 * 查看司机
	 */
	@Override
	public Drivervo viewDriver(String id) {
		// TODO Auto-generated method stub
		
		Drivervo tempDrivervo = null;
		
		try {
			if(vehicledataservice.findDri(id)!=null){
				tempDrivervo = convertPO(vehicledataservice.findDri(id));			
			}else {
				System.out.println("The id of driver doesn't exsit");
				return null;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tempDrivervo;
	}

	@Override
	public void endVehicle() {
		// TODO Auto-generated method stub
		System.out.println("End the driver control");
	}
	
	
	
	
	public Driverpo convertVO(Drivervo vo){
		return new Driverpo(vo.getId(), vo.getName(),
				                     vo.getBirthDate(), vo.getCertificate(),
				                     vo.getPhone(), vo.getHallId(),
				                     vo.getSex(), vo.getDdl());
	}
	
	
	public Drivervo convertPO(Driverpo po){
		return new Drivervo(po.getId(), po.getName(),
				                 po.getBirthDate(), po.getCertificate(),
				                 po.getPhone() ,po.getHallId(),
				                 po.getSex(),po.getDdl());
	}
	
	
	
	
	

}
