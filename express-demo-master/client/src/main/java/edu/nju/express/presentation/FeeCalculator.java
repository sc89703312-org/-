package edu.nju.express.presentation;

import java.math.BigDecimal;
import java.util.ArrayList;

import edu.nju.express.businesslogic.strategybl.constantsettingbl.ConstantSettingBl;
import edu.nju.express.common.Etype;


/**
 * 运费计算器
 */
public class FeeCalculator {
	
	private static String split = " ";

	public static double getDistance(String name1, String name2) {

		ArrayList<String> refe = ConstantSettingBl.getCityList();
		ArrayList<String> list = ConstantSettingBl.getCityDistance();
		
		int num1=refe.indexOf(name1);
		int num2=refe.indexOf(name2);
		if(num1==-1||num2==-1){
			return -1;
		}
		
		String result = (list.get(num1).split(split))[num2];
		
		return Double.parseDouble(result);
	}
	
	public static double getTransFee(String name1, String name2,Etype type) {
		
		double price =ConstantSettingBl.getPrice();
		switch(type){
		case ECONOMICAL:price = price/23.0*18.0;break;
		case FAST:price = price/23.0*25.0;break;
		}
		
		BigDecimal bd = new BigDecimal(getDistance(name1, name2)/1000.0*price);
		return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static double getPkgCost(String pkg){
		
		switch (pkg) {
		case "快递袋":
			return	 2;

		case "纸箱":
			return 5;
			
		case "木箱":
			return 10;
		}
		
		return -1;
	}
}
