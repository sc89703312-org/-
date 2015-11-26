package edu.nju.express.vo;

import java.util.ArrayList;

public class ComZoneVO {
	
    int planeSpace,trainSpace,carSpace,temSpace;
    
    ArrayList<ComGoodsVO> volist;
    
    public ComZoneVO(ArrayList<ComGoodsVO> volist, int[] space){
    	this.volist = volist;
    	planeSpace = space[0];
    	trainSpace = space[1];
    	carSpace = space[2];
    	temSpace = space[3];
    }
    
    public ArrayList<ComGoodsVO> getGoods(){
    	return volist;
    }
    
    public int[] getSpace(){
    	int result[] = new int[4];
    	result[0] = planeSpace;
    	result[1] = trainSpace;
    	result[2] = carSpace;
    	result[3] = temSpace;
    	return result;
    }
    
    public int[] getGoodsNum(){
    	int result[] = new int[4];
    	result[0] = result[1] = result[2] = result[3] = 0;
    	for(int i=0;i<volist.size();i++){
    		switch(volist.get(i).getType()){
    		case 1:result[0]++;break;
    		case 2:result[1]++;break;
    		case 3:result[2]++;break;
    		case 4:result[3]++;break;
    		}
    	}
    	return result;
    }
    
}
