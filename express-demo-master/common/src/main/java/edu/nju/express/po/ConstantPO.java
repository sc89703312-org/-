package edu.nju.express.po;

import java.io.Serializable;
import java.util.List;

public class ConstantPO implements Serializable{

	private static final long serialVersionUID = -1926679450602183759L;
	private List<String> cityList;
	private List<Double> cityDistance;
	private double price;
	private double vanCost, railwayCost, airplaneCost;
	private int vanLoad, railwayLoad, airplaneLoad;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public double getPrice() {
		return price;
	}
	public double getVanCost() {
		return vanCost;
	}
	public double getRailwayCost() {
		return railwayCost;
	}
	public double getAirplaneCost() {
		return airplaneCost;
	}
	public int getVanLoad() {
		return vanLoad;
	}
	public int getRailwayLoad() {
		return railwayLoad;
	}
	public int getAirplaneLoad() {
		return airplaneLoad;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setVanCost(double vanCost) {
		this.vanCost = vanCost;
	}
	public void setRailwayCost(double railwayCost) {
		this.railwayCost = railwayCost;
	}
	public void setAirplaneCost(double airplaneCost) {
		this.airplaneCost = airplaneCost;
	}
	public void setVanLoad(int vanLoad) {
		this.vanLoad = vanLoad;
	}
	public void setRailwayLoad(int railwayLoad) {
		this.railwayLoad = railwayLoad;
	}
	public void setAirplaneLoad(int airplaneLoad) {
		this.airplaneLoad = airplaneLoad;
	}
	public List<String> getCityList() {
		return cityList;
	}
	public List<Double> getCityDistance() {
		return cityDistance;
	}
	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}
	public void setCityDistance(List<Double> cityDistance) {
		this.cityDistance = cityDistance;
	}

	
}
