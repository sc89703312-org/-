package edu.nju.express.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 * 常量的数据层接口
 * @author Dora
 * @version 2015-12-9 22:15:29
 */
public interface ConstantDataService extends Remote{
	/**
	 * 将数据写入文件
	 * @author Dora
	 * @throws RemoteException
	 */
	public void flush() throws RemoteException;
	
	/**
	 * 更改快递单价
	 * @author Dora
	 * @param price
	 * @throws RemoteException
	 */
	public void setPrice(double price) throws RemoteException;
	
	/**
	 * 查询标准快递单价
	 * @author Dora
	 * @return 快递单价
	 * @throws RemoteException
	 */
	public double getPrice() throws RemoteException;
	
	/**
	 * 更改交通工具的成本
	 * @author Dora
	 * @param van
	 * @param railway
	 * @param airplane
	 * @throws RemoteException
	 */
	public void setVehicleCost(double van, double railway, double airplane)throws RemoteException;
	
	/**
	 * 查询交通工具的成本
	 * @author Dora
	 * @return
	 * @throws RemoteException
	 */
	public double[] getVehicleCost()throws RemoteException;
	/**
	 * 更改交通工具载量
	 * @author Dora
	 * @param van
	 * @param railway
	 * @param airplane
	 * @throws RemoteException
	 */
	public void setVehicleLoad(int van, int railway, int airplane) throws RemoteException;
	
	/**
	 * 查询交通工具载量
	 * @author Dora
	 * @return
	 * @throws RemoteException
	 */
	public int[] getVehicleLoad() throws RemoteException;
	
	/**
	 * 获得城市名称列表
	 * @author Dora
	 * @return 城市名称集合
	 * @throws RemoteException
	 */
	public ArrayList<String> getCityList() throws RemoteException;
	
	/**
	 * 获得城市距离
	 * @author Dora
	 * @return 城市距离集合
	 * @throws RemoteException
	 */
	public ArrayList<String> getCityDistance() throws RemoteException;
	
	/**
	 * 插入一个城市
	 * @author Dora
	 * @param CityID
	 * @param id
	 * @throws RemoteException
	 */
	public void addCity(String CityID,String id)throws RemoteException;
	
	/**
	 * 删除一个城市
	 * @author Dora
	 * @param CityID
	 * @throws RemoteException
	 */
	public void deleteCity(String CityID) throws RemoteException;
	
	/**
	 * 设置两城市间距离
	 * @author Dora
	 * @param CityID1
	 * @param CityID2
	 * @param distance
	 * @throws RemoteException
	 */
	public void setCityDistance(String CityID1,String CityID2, double distance)throws RemoteException;
	
}
