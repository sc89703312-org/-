package edu.nju.express.po;

import java.io.Serializable;
import java.util.ArrayList;

public class ConstantPO extends PersistentObj implements Serializable{

	private static final long serialVersionUID = -1926679450602183759L;
	private ArrayList<String> cityList;
	private ArrayList<String> cityDistance;
	private ArrayList<String> cityIDList;
	private double price;
	private double vanCost, railwayCost, airplaneCost;
	private int vanLoad, railwayLoad, airplaneLoad;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public ConstantPO( ArrayList<String> cityList,ArrayList<String> cityDistance
			,double price,double vanCost,double railwayCost,double airplaneCost,
			int vanLoad,int railwayLoad,int airplaneLoad,ArrayList<String> cityIDList) {
		// TODO Auto-generated constructor stub
	
	this.cityList = cityList;
	this.cityDistance = cityDistance;
	this.price = price;
	this.vanCost = vanCost;
	this.railwayCost = railwayCost;
	this.airplaneCost = airplaneCost;
	this.vanLoad = vanLoad;
	this.railwayLoad = railwayLoad;
	this.airplaneLoad = airplaneLoad;
	this.cityIDList = cityIDList;
	
	
	
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
	public ArrayList<String> getCityList() {
		return cityList;
	}
	
	public ArrayList<String> getCityIDList(){
		return cityIDList;
	}
	public ArrayList<String> getCityDistance() {
		return cityDistance;
	}
	public void setCityList(ArrayList<String> cityList) {
		this.cityList = cityList;
	}
	public void setCityDistance(ArrayList<String> cityDistance) {
		this.cityDistance = cityDistance;
	}

	public void setCityIDList(ArrayList<String> cityIDList){
		this.cityIDList = cityIDList;
	}
}
