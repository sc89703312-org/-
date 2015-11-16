package edu.nju.express.businesslogic.strategybl.constantsettingbl;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.nju.express.common.BasicValues;
import edu.nju.express.common.ResultMessage;



public class ConstantSettingTester {

	@Test
	public void test(){
		ConstantSettingBl cs = new ConstantSettingBl();
		
		assertEquals(cs.setPrice(0), ResultMessage.INVALID);
		
		assertEquals(cs.setPrice(0.25), ResultMessage.VALID);
		assertEquals(BasicValues.price, 0.25, 0);
		
		cs.setVehicleCost(20, 10, 200);
		assertEquals(BasicValues.airplaneCost, 200,0);
		assertEquals(BasicValues.vanCost,20,0);
		assertEquals(BasicValues.railwayCost,10,0);
		
		assertEquals(cs.setVehicleLoad(100, 10000, 500), ResultMessage.VALID);
		assertEquals(BasicValues.airplaneLoad,500);
	}
}
