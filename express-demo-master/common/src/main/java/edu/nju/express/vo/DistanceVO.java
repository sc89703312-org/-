package edu.nju.express.vo;

public class DistanceVO {

	String id1;
	String id2;
	double distance;
	
	
	/**
	 * @param id1
	 * @param id2
	 * @param distance
	 */
	public DistanceVO(String id1, String id2, double distance) {
		super();
		this.id1 = id1;
		this.id2 = id2;
		this.distance = distance;
	}

	public double getDistance() {
		return distance;
	}
	
	public String getId1() {
		return id1;
	}
	
	public String getId2() {
		return id2;
	}
}
