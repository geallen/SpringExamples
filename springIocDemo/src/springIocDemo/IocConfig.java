package springIocDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("springIocDemo")
@PropertySource("classpath:values.properties")
public class IocConfig {

	@Bean
	public ICustomerDao orm() {
		
		return new HibernateCustomerDao();
	}
	
	@Bean
	public ICustomerService service() {
		return new CustomerService(orm());
	}
	
	
}
