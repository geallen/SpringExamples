package ocp;

public class CoffeeDemo {

	public static void main(String[] args) {

		CoffeeService coffeeService = new CoffeeService(new StarbucksCoffeeService(new StarbucksCampain()));
		
		coffeeService.apply();
	}

}
