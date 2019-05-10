package ocp;

public class CoffeeService {

	ICoffeeService coffeeService;
	
	public CoffeeService(ICoffeeService coffeeService) {
		this.coffeeService = coffeeService; 
	}
	
	public void apply() {
		coffeeService.sell();
	}
	
	
}
