package edu.nju.express.common;

public enum Item {

	RENT("租金"), TRANSPORT("运费"), SALARY_C("业务员月薪"),
	SALARY_P("快递员提成"),SALARY_D("司机提成"), BONUS("奖励");

	String name;

	private Item(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static Item getItem(String name){
		 for( Item i : values())
	            if(i.getName().equals(name))
	            	return i;
		 throw new IllegalArgumentException();
	}

}
