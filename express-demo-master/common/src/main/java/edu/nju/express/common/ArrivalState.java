package edu.nju.express.common;

public enum ArrivalState {
	NO("未到达"),  YES("已到达");
	
	String name;
	private ArrivalState(String n) {
		name = n;
	}
	@Override
	public String toString() {
		return name;
	}
	
}
