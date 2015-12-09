package edu.nju.express.po;

import java.io.Serializable;



public class ComZonePO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int planeSpace;
	int trainSpace;
	int carSpace;
	int temSpace;
	
	int initPlane;
	int initTrain;
	int initCar;
	int initTem;
	
	int shelfPerLine;
	int cellPerShelf;
	
	boolean isEmptyPlane[];
	boolean isEmptyTrain[];
	boolean isEmptyCar[];
	boolean isEmptyTem[];
	
	public ComZonePO(int totalSpace){
		shelfPerLine = 5;
		cellPerShelf = 10;
		initPlane = planeSpace = totalSpace/3;
		initTrain = trainSpace = totalSpace/3;
		initCar = carSpace = totalSpace/3;
		initTem = temSpace = totalSpace - planeSpace - trainSpace - carSpace;
		isEmptyPlane = new boolean[planeSpace];
		isEmptyTrain = new boolean[trainSpace];
		isEmptyCar = new boolean[carSpace];
		isEmptyTem = new boolean[temSpace];
		for(int i=0;i<planeSpace;i++)
			isEmptyPlane[i] = true;
		for(int i=0;i<trainSpace;i++)
			isEmptyTrain[i] = true;
		for(int i=0;i<carSpace;i++)
			isEmptyCar[i] = true;
		for(int i=0;i<temSpace;i++)
			isEmptyTem[i] = true;
	}

	public ComZonePO(int totalSpace, int shelfPerLine, int cellPerShelf){
		this(totalSpace);
		this.shelfPerLine = shelfPerLine;
		this.cellPerShelf = cellPerShelf;
	}
	
	public ComZonePO(int plane, int train, int car, int tem){
		shelfPerLine = 5;
		cellPerShelf = 10;
		planeSpace = plane;
		trainSpace = train;
		carSpace = car;
		temSpace = tem;
		isEmptyPlane = new boolean[planeSpace];
		isEmptyTrain = new boolean[trainSpace];
		isEmptyCar = new boolean[carSpace];
		isEmptyTem = new boolean[temSpace];
		for(int i=0;i<planeSpace;i++)
			isEmptyPlane[i] = true;
		for(int i=0;i<trainSpace;i++)
			isEmptyTrain[i] = true;
		for(int i=0;i<carSpace;i++)
			isEmptyCar[i] = true;
		for(int i=0;i<temSpace;i++)
			isEmptyTem[i] = true;
	}
	
	public ComZonePO(int plane, int train, int car, int tem, int shelfPerLine, int cellPerShelf){
		this(plane,train,car,tem);
		this.shelfPerLine = shelfPerLine;
		this.cellPerShelf = cellPerShelf;
	}
	
	public int getShelfPerLine(){
		return shelfPerLine;
	}
	
	public int getCellPerShelf(){
		return cellPerShelf;
	}
	
	public int[] getSpace(){
		int result[] = {planeSpace,trainSpace,carSpace,temSpace};
		return result;
	}
	
	public boolean[] getIsEmptyPlane(){
		return isEmptyPlane;
	}
	
	public boolean[] getIsEmptyTrain(){
		return isEmptyTrain;
	}
	
	public boolean[] getIsEmptyCar(){
		return isEmptyCar;
	}
	
	public void setIsEmptyPlane(boolean[] a){
		isEmptyPlane = a;
		planeSpace = a.length;
	}
	
	public void setIsEmptyTrain(boolean[] a){
		isEmptyTrain = a;
		trainSpace = a.length;
	}
	
	public void setIsEmptyCar(boolean[] a){
		isEmptyCar = a;
		carSpace = a.length;
	}
	
	public void setIsEmptyTem(boolean[] a){
		isEmptyTem = a;
		temSpace = a.length;
	}
	
	public boolean[] getIsEmptyTem(){
		return isEmptyTem;
	}
	
	public int[] selectCell(int type){
		
		int result[] = new int[2];
		result[0] = result[1] = 0;
		
		switch(type){
		case 1:
			for(int i=0;i<planeSpace;i++)
				if(isEmptyPlane[i]){
					result[0] = 1;
					result[1] = i+1;
					isEmptyPlane[i] = false;
					break;
				}
			break;
		case 2:
			for(int i=0;i<trainSpace;i++)
				if(isEmptyTrain[i]){
					result[0] = 2;
					result[1] = i+1;
					isEmptyTrain[i] = false;
					break;
				}
			break;
		case 3:
			for(int i=0;i<carSpace;i++)
				if(isEmptyCar[i]){
					result[0] = 3;
					result[1] = i+1;
					isEmptyCar[i] = false;
					break;
				}
			break;
		}
		
		if(result[0]==0)
			for(int i=0;i<temSpace;i++)
				if(isEmptyTem[i]){
					result[0] = 4;
					result[1] = i+1;
					isEmptyTem[i] = false;
					break;
				}
		
		return result;
	}

}
