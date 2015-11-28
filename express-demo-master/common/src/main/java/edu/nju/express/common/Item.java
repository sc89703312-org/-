package edu.nju.express.common;

public enum Item {

	RENT("租金"), TRANSPORT("运费"), SALARY("工资"), BONUS("奖励");

	String name;

	private Item(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
