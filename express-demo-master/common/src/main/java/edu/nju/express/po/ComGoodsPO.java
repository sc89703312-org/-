package edu.nju.express.po;

import java.io.Serializable;

import edu.nju.express.vo.OrderVO;



public class ComGoodsPO extends PersistentObj implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	OrderPO order;
	int type;
	int line;
	int shelf;
	int cell;
	
	public ComGoodsPO(OrderPO order, int type, int line, int shelf, int cell){
		this.order = order;
		this.type = type;
		this.line = line;
		this.shelf = shelf;
		this.cell = cell;
		this.id = order.id;
		this.date = "";
	}
	
	public OrderPO getOrder(){
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
