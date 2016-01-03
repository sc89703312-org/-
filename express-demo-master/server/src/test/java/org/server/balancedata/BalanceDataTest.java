package org.server.balancedata;





public class BalanceDataTest {

	/*
	private BalanceDataService_Impl balanceData;
	
	public BalanceDataTest() {
		// TODO Auto-generated constructor stub
	
		try {
			balanceData = new BalanceDataService_Impl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	
	
	@Before
	public void setUp(){
		System.out.println("对付款单数据层进行功能测试");
		System.out.println("————————————————————————————————");
		System.out.println();System.out.println();
	}
	
	
	@After
	public void tearDown(){
		System.out.println();System.out.println();
		System.out.println("————————————————————————————————");
		System.out.println("结束对付款单数据层进行功能测试");
	}
	
	
	@Test
	public void testAllCost() throws RemoteException{
		System.out.println("显示所有的付款单");
		
		ArrayList<Balancepo> tempList = balanceData.getAll();
		ArrayList<Balancepo> costList = new ArrayList<>();
		costList = (tempList==null?new ArrayList<Balancepo>():tempList);
		
		for(Balancepo po:costList)
			System.out.println(po.getDate()+"      "+
		                       po.getId()+"      "+
					           po.getName()+"      "+
		                       po.getMoney()
		);
				
		
	}
	
	
	
	@Test
	public void testCostSubmitted() throws RemoteException{
		System.out.println("显示所有未审批的付款单");
		
		ArrayList<Balancepo> tempList = balanceData.viewAllCostSubmitted();
		ArrayList<Balancepo> costList = new ArrayList<>();
		costList = (tempList==null?new ArrayList<Balancepo>():tempList);
		
		
		for(Balancepo po:costList)
			System.out.println(po.getDate()+"      "+
		                       po.getId()+"      "+
					           po.getName()+"      "+
		                       po.getMoney()
		);
		
		
	}
	
	
	
	
	@Test
	public void testInsertCost() throws RemoteException{
		System.out.println("新增付款单");
		
		
		Balancepo po = new Balancepo("2015/12/12", 200, "生宸", "sc925200", Item.BONUS, "a", "0000000001");
	
	
		ResultMessage result = balanceData.insert(po);
		System.out.println(result);
		
		assertEquals("创建付款单成功",result,ResultMessage.INVALID);
	
	
	}
	
	
	
	@Test
	public void testFindCostByDate() throws RemoteException{
		
		System.out.println("按日期查询付款单");
		Scanner in = new Scanner(System.in);
		
		ArrayList<Balancepo> tempList = balanceData.find(in.next());
		for(Balancepo po:tempList)
			System.out.println(po.getDate()+"      "+
                    po.getId()+"      "+
			           po.getName()+"      "+
                    po.getMoney()
);
		
	}
	
	*/
}
