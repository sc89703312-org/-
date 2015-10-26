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
	
}
