package edu.nju.express.vo;



public class ComGoodsVO {

	OrderVO order;
	int type;
	int line;
	int shelf;
	int cell;
	
	public ComGoodsVO(OrderVO order, int type, int line, int shelf, int cell){
		
		this.order = order;
		this.type = type;
		this.line = line;
		this.shelf = shelf;
		this.cell = cell;
		
	}
	
	public OrderVO getOrder(){
		return order;
	}
	
    public int getType(){
    	return type;
    }
    
    public int getLine(){
    	return line;
    }
    
    public int getShelf(){
    	return shelf;
    }
    
    public int getCell(){
    	return cell;
    }
	
}
