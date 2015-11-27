package edu.nju.express.vo;

public class ConstantVO {
	private String priceStandard, priceLow,priceHigh;
	private String vanCost, railwayCost, airplaneCost;
	private String vanLoad, railwayLoad, airplaneLoad;
	/**
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
	public ConstantVO(String priceStandard, String priceLow, String priceHigh, String vanCost, String railwayCost,
			String airplaneCost, String vanLoad, String railwayLoad, String airplaneLoad) {
		super();
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
	
	
}
