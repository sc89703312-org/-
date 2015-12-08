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
			return -1;
		}

		String result = (list.get(num1).split(split))[num2];

		return Double.parseDouble(result);
	}

	//如果是不同城市，需要两次在营业厅之间运输和一次在城市间运输
	public static double getTransFee(String cityname1, String cityname2, Etype type) {

		double price = ConstantSettingBl.getPrice();
		switch (type) {
		case ECONOMICAL:
			price = price / 23.0 * 18.0;
			break;
		case FAST:
			price = price / 23.0 * 25.0;
			break;
		}

		BigDecimal bd = new BigDecimal((60.0 + getDistance(cityname1, cityname2)) / 1000.0 * price);
		return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	//如果是同城快递，只需要一次营业厅间的运费
	public static double getTransFee(Etype type) {

		double price = ConstantSettingBl.getPrice();
		switch (type) {
		case ECONOMICAL:
			price = price / 23.0 * 18.0;
			break;
		case FAST:
			price = price / 23.0 * 25.0;
			break;
		}

		BigDecimal bd = new BigDecimal(30.0  / 1000.0 * price);
		return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static double getPkgCost(String pkg) {

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
}
