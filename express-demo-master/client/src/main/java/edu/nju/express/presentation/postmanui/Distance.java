package edu.nju.express.presentation.postmanui;

import java.util.ArrayList;

import edu.nju.express.businesslogic.strategybl.constantsettingbl.ConstantSettingBl;

public class Distance {
	
	private static String split = " ";

	public static double get(String name1, String name2) {

		ArrayList<String> refe = ConstantSettingBl.getCityList();
		ArrayList<String> list = ConstantSettingBl.getCityDistance();
		
		int num1=refe.indexOf(name1);
		int num2=refe.indexOf(name2);
		
		System.out.println(num1+" "+num2);
		
		String result = (list.get(num1).split(split))[num2];
		
		return Double.parseDouble(result);
	}
}
