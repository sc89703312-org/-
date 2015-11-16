package edu.nju.express.blservice;

import edu.nju.express.common.ResultMessage;
import edu.nju.express.vo.Carvo;


public interface CarControlService {

	public ResultMessage addCar(Carvo vo);
	public ResultMessage deleteCar(int id);
	public ResultMessage modifyCar(int id,Carvo vo);
	public Carvo viewCar(int id);
	
	public void endCar();
	
}
