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

	//根据城市的名称获取距离
	public static double getDistance(String cityname1, String cityname2) {

		ArrayList<String> refe = ConstantSettingBl.getCityList();
		ArrayList<String> list = ConstantSettingBl.getCityDistance();
		
		int num1 = refe.indexOf(cityname1);
		int num2 = refe.indexOf(cityname2);
		if (num1 == -1 || num2 == -1) {
			return 0;
		}

		String result = (list.get(num1).split(split))[num2];

		return Double.parseDouble(result);
	}

	//两个城市之间
	public static double getTransFee(String cityname1, String cityname2, Etype type,double weight) {

		double price = ConstantSettingBl.getPrice();
		switch (type) {
		case ECONOMICAL:
			price = price / 23.0 * 18.0 *weight;
			break;
		case FAST:
			price = price / 23.0 * 25.0 *weight;
			break;
		}

		BigDecimal bd = new BigDecimal( getDistance(cityname1, cityname2) / 1000.0 * price);
		return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	//如果是同城快递，只需要一次营业厅间的运费
	public static double getTransFee(Etype type, double weight) {

		double price = ConstantSettingBl.getPrice();
		switch (type) {
		case ECONOMICAL:
			price = price / 23.0 * 18.0 *weight;
			break;
		case FAST:
			price = price / 23.0 * 25.0 *weight;
			break;
		}

		BigDecimal bd = new BigDecimal(30.0  / 1000.0 * price);
		return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static double getPkgCost(String pkg) {
		
		System.out.println(pkg);

		switch (pkg) {
		case "快递袋":
			return 2;

		case "纸箱":
			return 5;

		case "木箱":
			return 10;
		}

		return -1;
	}
	
	public static int getExpectedDays(String city1,String city2){
		double distance = FeeCalculator.getDistance(city1, city2);
		int expect;
		if (distance <= 300)
			expect = 1;
		else if(distance <=1000)
			expect = 2;
		else if (distance <= 1500)
			expect = 4;
		else
			expect = 5;
		
		return expect;
	}
	
}
