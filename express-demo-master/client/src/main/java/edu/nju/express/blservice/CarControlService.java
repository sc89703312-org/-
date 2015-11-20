package edu.nju.express.blservice;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Carvo;


public interface CarControlService {

	public ResultMessage addCar(Carvo vo);
	public ResultMessage deleteCar(String id);
	public ResultMessage modifyCar(String id,Carvo vo);
	public Carvo viewCar(String id);
	
	public void endCar();
	
}
