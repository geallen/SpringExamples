package ocp;

public class KrediDemo {

	public static void main(String[] args) {
		
		CreditService creditService = new CreditService(new FarmerCalculationService());
		creditService.apply();
	}
}


