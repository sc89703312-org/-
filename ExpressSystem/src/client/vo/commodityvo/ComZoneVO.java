package client.vo.commodityvo;

public class ComZoneVO {

	int planeSpace;
	int trainSpace;
	int carSpace;
	int temSpace;
	
	int planeGoods;
	int trainGoods;
	int carGoods;
	int temGoods;
	
	public ComZoneVO(int[] space){
		
		planeSpace = space[0];
		trainSpace = space[1];
		carSpace = space[2];
		temSpace = space[3];
		
	}
	
	public int[] getSpace(){
		int[] space = new int[4];
		space[0] = planeSpace;
		space[1] = trainSpace;
		space[2] = carSpace;
		space[3] = temSpace;
		return space;
	}
	
}
