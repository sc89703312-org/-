package client.vo.commodityvo;

import java.util.ArrayList;

public class ExitReceiptVO {

	String id;
	String location;
	String date;
	
    ArrayList<ComGoodsVO> list;
	
	public ExitReceiptVO(ArrayList<ComGoodsVO> list, String id, String date, String location){
		
		this.id = id;
		this.location = location;
		this.date = date;
		
		this.list = list;
		
	}
	
}
