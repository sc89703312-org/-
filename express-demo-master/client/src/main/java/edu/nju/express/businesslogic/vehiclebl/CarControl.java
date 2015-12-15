package edu.nju.express.businesslogic.vehiclebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.express.blservice.CarControlService;
import edu.nju.express.businesslogic.accountbl.Info.CarControlInfo;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.config.RMIConfig;
import edu.nju.express.dataservice.*;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.po.Carpo;
import edu.nju.express.vo.Carvo;

/**
 * 
 * @author lenovo
 * @version 2015年12月9日22:47:17
 * 
 * 用于营业厅业务员进行车辆信息管理
 */


public class CarControl implements CarControlService,CarControlInfo{

	vehicledataservice vehicledataservice;
	
	
	public CarControl() {
		// TODO Auto-generated constructor stub
		try {
			vehicledataservice = (vehicledataservice) Naming.lookup("rmi://" + RMIConfig.HOST + "/vehicle-service");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author lenovo
	 * @version 2015年12月9日22:47:48
	 * 新增车辆
	 */
	@Override
	public ResultMessage addCar(Carvo vo) {
		// TODO Auto-generated method stub
		try {
			if(vehicledataservice.findCar(vo.getId())!=null){
				System.out.println("Sorry the id of car has been exsited");
				return ResultMessage.INVALID;
			}else {
				System.out.println("The id is valid");
				vehicledataservice.insertCar(convertVO(vo));
			}
			  
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ResultMessage.VALID;
	}

	
	/**
	 * @author lenovo
	 * @version 2015年12月9日22:48:11
	 * 删除车辆信息
	 */
	@Override
	public ResultMessage deleteCar(String id) {
		// TODO Auto-generated method stub
		
		try {
			if(vehicledataservice.findCar(id)!=null){
				System.out.println("The id of car exsits");
				vehicledataservice.deleteCar(id);
			}else {
				System.out.println("The id of car doesn't exsit");
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
	 * @version 2015年12月9日22:48:29
	 * 修改车辆信息
	 */
	@Override
	public ResultMessage modifyCar(String id, Carvo vo) {
		// TODO Auto-generated method stub
		
		try {
			if(vehicledataservice.findCar(id)!=null){
				vehicledataservice.updateCar(id, convertVO(vo));
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
	 * @version 2015年12月9日22:48:51
	 * 查看车辆
	 */
	@Override
	public Carvo viewCar(String id) {
		// TODO Auto-generated method stub
		
		Carvo tempCarvo = null;
		
		try {
			if(vehicledataservice.findCar(id)!=null){
				tempCarvo = convertPO(vehicledataservice.findCar(id));			
			}else {
				System.out.println("The id of car doesn't exsit");
				return null;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tempCarvo;
	}

	@Override
	public void endCar() {
		// TODO Auto-generated method stub
		System.out.println("End the car control");
	}
	
	
	
	
	
	public Carpo convertVO(Carvo vo){
		return new Carpo(vo.getId(), vo.getMotor(),
				                 vo.getCar(), vo.getBase(),
				                 vo.getPurchase(), vo.getUse());
	}
	
	
	public Carvo convertPO(Carpo po){
		return new Carvo(po.getId(), po.getMotor(),
				                 po.getCar(), po.getBase(),
				                 po.getPurchase() ,po.getUse());
	}


	/**
	 * @author lenovo
	 * @version 2015年12月9日22:49:11
	 * 获取所有的车辆的列表
	 */

	@Override
	public ArrayList<Carvo> getAll() {
		// TODO Auto-generated method stub
		
		ArrayList<Carvo> cars = new ArrayList<>();
		
		try {
			ArrayList<Carpo> temp = vehicledataservice.getAllCars();
		    for(int i=0;i<temp.size();i++)
		    	cars.add(convertPO(temp.get(i)));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cars;
	}

}
