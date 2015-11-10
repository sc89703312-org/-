package client.businesslogic.paymentbl;

public class MockBanking {

	String[] accountNames =new String[3];
	
	int[] money =new int[3];
	
	
	public MockBanking() {
		// TODO Auto-generated constructor stub
	
		accountNames[0]="sc";
		money[0]=100000;
		
		accountNames[1]="a";
		money[1]=100000;
		
		accountNames[2]="hehe";
		money[2]=100000;
		
		
	}
	
	public void modify(int modify,String name){
		
		
		for(int i=0;i<3;i++){
			if(name.equals(accountNames[i])){
				money[i]+=modify;
				System.out.println("The banking of:"+accountNames[i]+" has changed");
			    break;
			}
				
		}
		
	}	
	
	
		
		public int getMoney(String name){
			
			
			for(int i=0;i<3;i++){
				if(name.equals(accountNames[i])){
					
					return money[i];
				
				}
					
			}
			return 0;
		}
		
		
		
	
}
