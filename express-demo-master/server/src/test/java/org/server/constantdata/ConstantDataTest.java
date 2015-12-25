package org.server.constantdata;

public class ConstantDataTest {
	/*
	
	ConstantDataService_Impl constant;
	
	public ConstantDataTest() {
		// TODO Auto-generated constructor stub
	
		try {
			constant = new ConstantDataService_Impl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	@Before
	public void setUp(){
		System.out.println("常量制定数据层功能测试");
		System.out.println("——————————————————————");
		System.out.println();
	}

	@After
	public void tearDown(){
		System.out.println();
		System.out.println("结束此次测试");
		System.out.println("———————————————————————");
		
	}
	
	@Test
	public void testGetCityList() throws RemoteException{
		System.out.println("城市列表");
		ArrayList<String> cityList = 
				(constant.getCityList()==null)?new ArrayList<String>()
						:constant.getCityList();
				
				
		for(String city:cityList)	
			System.out.println(city);
	}
	
	
	@Test
	public void testGetCityDistance() throws RemoteException{
		
		System.out.println("城市距离");
		ArrayList<String> cityDistanceList = 
				(constant.getCityDistance()==null)?new ArrayList<String>()
						:constant.getCityDistance();
				
		for(String cityDistance:cityDistanceList)	
			System.out.println(cityDistance);
	}
	
	
	
	
	@Test
	public void testGetPrice() throws RemoteException{
		
		System.out.println("价格");
		double price = constant.getPrice();
		System.out.println(price);
	}
	
	
	@Test
	public void testGetVehicleCost()throws RemoteException{
		
		System.out.println("交通运费");
		double cost[] = constant.getVehicleCost();
		System.out.println("van: "+cost[0]+" "+
				           "railway: "+cost[1]+" "+
				           "airplane: "+cost[2]);
	}
	
	
	
	@Test
	public void testGetVehicleLoad()throws RemoteException{
		
		System.out.println("交通负重");
		int cost[] = constant.getVehicleLoad();
		System.out.println("van: "+cost[0]+" "+
				           "railway: "+cost[1]+" "+
				           "airplane: "+cost[2]);
	}
	*/
}
