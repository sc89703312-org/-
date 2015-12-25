package org.server.paymentdata;

public class PaymentDataTest {
/*
	PaymentDataservice_Impl paymentData;
	
	
	public PaymentDataTest() {
		// TODO Auto-generated constructor stub
	
		try {
			paymentData = new PaymentDataservice_Impl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	
	@Before
	public void setUp(){
		System.out.println();System.out.println();
		System.out.println("测试收款单模块数据区相关功能");
		System.out.println("——————————————————————————————————————————————————————");
		
	}
	
	
	@After
	public void tearDown(){
		System.out.println("——————————————————————————————————————————————————————");
		System.out.println("测试结束");
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	@Test
	public void testAllPayments() throws RemoteException{
		
		System.out.println("显示所有的收款单");
		
		ArrayList<Paymentpo> paymentList = paymentData.getAll();
		for(Paymentpo temp: paymentList)
			System.out.println(temp.getDate()+"     "+
		                       temp.getOrder_id()+"    "+
					           temp.getCourier_id()+"     "+
		                       temp.getPay());
	}
	
	
	
	
	@Test
    public void testPaymentsSubmitted() throws RemoteException{
		
		
		System.out.println("显示所有未审批通过的收款单");
		
		
		ArrayList<Paymentpo> paymentList = paymentData.viewAllPaymentSubmitted();
		for(Paymentpo temp: paymentList)
			System.out.println(temp.getDate()+"     "+
		                       temp.getOrder_id()+"    "+
					           temp.getCourier_id()+"     "+
		                       temp.getPay());
	}
	
	
	
	
	@Test
	public void testInsertPayment() throws RemoteException{
		
		System.out.println("测试添加收款单");
		
		ResultMessage result = ResultMessage.INVALID;
		
		result = paymentData.insert(new Paymentpo("2015/12/11", 500, "02500101", "0000000001", "sc"));
				
		System.out.println(result);
		
		assertEquals("收款单创建失败", ResultMessage.INVALID, result);
	}
	
	
	
	
	@Test
	public void testFindPaymentById() throws RemoteException{
		
		System.out.println("测试查找收款单");
		Scanner reader = new Scanner(System.in);
		
		Paymentpo po = paymentData.find(reader.next());
		
		if(po!=null){
			System.out.println("存在订单");
			System.out.println(po.getDate()+"    "+
		                       po.getOrder_id()+"    "+
					           po.getCourier_id()+"    "+
		                       po.getPay());
		}else {
			System.out.println("Not Found");
		}
	}
	
	
	
	@Test
	public void testFindOrderByHallID() throws RemoteException{
		
		System.out.println("按营业厅查看订单单号");
		
		Scanner in = new Scanner(System.in);
		
		ArrayList<String> orderList = paymentData.viewAllOrderListByHall(in.next());
		
		for(String orderID:orderList)
			System.out.println(orderID);
	}
	*/
}
