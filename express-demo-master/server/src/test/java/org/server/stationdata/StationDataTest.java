package org.server.stationdata;

public class StationDataTest {
/*
	StationDataService_Impl impl;
	
	public StationDataTest(){
		
		try {
			impl = new StationDataService_Impl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Before
	public void setUp(){
		System.out.println("对营业厅数据进行功能测试");
		System.out.println("——————————————————————");
		System.out.println();
	}
	
	@After
	public void tearDown(){
		System.out.println();
		System.out.println("——————————————————————");
		System.out.println("结束此次功能测试");
	}
	
	@Test
	public void testGetStationLocation() throws RemoteException{
		
        System.out.println("测试获取中转站位置");
		
		Scanner sc = new Scanner(System.in);
		String stationD = sc.next();
		
		System.out.println(impl.getLocation(stationD)); 
		
	}
	
	@Test
	public void testGetArrive() throws RemoteException{
		
		System.out.println("测试获取中转站到达单");
		
		Scanner sc = new Scanner(System.in);
		String stationID = sc.next();
		
		ArrayList<ArriveReceiptPO> list = impl.getArriveReceipt(stationID);
		for(int i=0;i<list.size();i++){
			System.out.println("到达单ID："+list.get(i).getId());
			System.out.println("货物来源："+list.get(i).getFrom());
			System.out.println("货物数量："+list.get(i).getOrderList().size());
		}
		
	}
	
	@Test
	public void testGetTransfer() throws RemoteException{
		
		System.out.println("测试获取中转站中转单");
		
		Scanner sc = new Scanner(System.in);
		String stationID = sc.next();
		
		ArrayList<TransferReceiptPO> list = impl.getTransferReceipt(stationID);
		for(int i=0;i<list.size();i++){
			System.out.println("中转单ID："+list.get(i).getId());
			System.out.println("货物来源："+list.get(i).getTo());
			System.out.println("货物数量："+list.get(i).getOrderList().size());
		}
		
	}
	*/
}
