package server.data.bankingdata;


public interface BankingDao {

	public void income(String name, int num);
	public void expend(String name, int num);
	public void modifyName(String newName, String name);
	public void addAccount(String name);
	public void removeAccount(String name);
	
}
