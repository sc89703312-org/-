package edu.nju.express.vo;

import java.util.ArrayList;

public class ConstantVO {
	private ArrayList<String> cityList;
	private ArrayList<String> cityDistance;
	private String priceStandard, priceLow,priceHigh;
	private String vanCost, railwayCost, airplaneCost;
	private String vanLoad, railwayLoad, airplaneLoad;
	
	/**
	 * @param cityList
	 * @param cityDistance
	 * @param priceStandard
	 * @param priceLow
	 * @param priceHigh
	 * @param vanCost
	 * @param railwayCost
	 * @param airplaneCost
	 * @param vanLoad
	 * @param railwayLoad
	 * @param airplaneLoad
	 */
	public ConstantVO(ArrayList<String> cityList, ArrayList<String> cityDistance, String priceStandard, String priceLow,
			String priceHigh, String vanCost, String railwayCost, String airplaneCost, String vanLoad,
			String railwayLoad, String airplaneLoad) {
		super();
		this.cityList = cityList;
		this.cityDistance = cityDistance;
		this.priceStandard = priceStandard;
		this.priceLow = priceLow;
		this.priceHigh = priceHigh;
		this.vanCost = vanCost;
		this.railwayCost = railwayCost;
		this.airplaneCost = airplaneCost;
		this.vanLoad = vanLoad;
		this.railwayLoad = railwayLoad;
		this.airplaneLoad = airplaneLoad;
	}
	public String getPriceStandard() {
		return priceStandard;
	}
	public String getPriceLow() {
		return priceLow;
	}
	public String getPriceHigh() {
		return priceHigh;
	}
	public String getVanCost() {
		return vanCost;
	}
	public String getRailwayCost() {
		return railwayCost;
	}
	public String getAirplaneCost() {
		return airplaneCost;
	}
	public String getVanLoad() {
		return vanLoad;
	}
	public String getRailwayLoad() {
		return railwayLoad;
	}
	public String getAirplaneLoad() {
		return airplaneLoad;
	}
	public ArrayList<String> getCityList() {
		return cityList;
	}
	public ArrayList<String> getCityDistance() {
		return cityDistance;
	}
	
	
}
