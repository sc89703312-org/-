package edu.nju.express.businesslogic.stationbl.Mock_Test;

import java.util.ArrayList;

import edu.nju.express.businesslogic.stationbl.StationBl;
import edu.nju.express.init.RMIHelper;
import edu.nju.express.vo.StationVO;

public class StationTest {

	public static void main(String[] args){
		RMIHelper.init();
		System.out.println("Client creates!");
		
		StationBl stationbl = new StationBl();
		stationbl.addStation("025", "Nanjing");
		stationbl.addStation("026", "Shanghai");
		ArrayList<StationVO> list = stationbl.showStation();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getId()+" "+list.get(i).getName());
		}
		
	}
	
}
