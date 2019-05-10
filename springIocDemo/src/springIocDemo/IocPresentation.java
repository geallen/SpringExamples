package springIocDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocPresentation {

	public static void main(String[] args) {
//		CustomerService customerService = 
//				new CustomerService(new HibernateCustomerDao());
//		customerService.add();

		// yukardaki kisim yerine alttaki yapilabilir
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(IocConfig.class);
		
//		ICustomerDao customerDao = context.getBean("orm",ICustomerDao.class);
//		customerDao.add();
//		
	
		ICustomerService customerService = 
				context.getBean("service", ICustomerService.class);
		
		
		customerService.add();

	}

}
