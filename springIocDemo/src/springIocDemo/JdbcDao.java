package springIocDemo;

public class JdbcDao implements ICustomerDao{

	@Override
	public void add() {
		System.out.println("Added by jdbc");
	}

}
