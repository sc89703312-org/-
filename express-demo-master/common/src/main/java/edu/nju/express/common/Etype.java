package edu.nju.express.common;

public enum Etype {
	ECONOMICAL("经济快递"), STANDARD("标准快递"), FAST("特快专递");

	String name;

	private Etype(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
