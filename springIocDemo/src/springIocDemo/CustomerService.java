package springIocDemo;

import org.springframework.stereotype.Component;

@Component("service")
public class CustomerService implements ICustomerService {

	ICustomerDao customerDao;
	
	public CustomerService(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	
	
	@Override
	public void add() {
		this.customerDao.add();
	}

//	public ICustomerDao getCustomerDao() {
//		return customerDao;
//	}
//
//	public void setCustomerDao(ICustomerDao customerDao) {
//		this.customerDao = customerDao;
//	}

	
}
