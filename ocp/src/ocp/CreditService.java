package ocp;

public class CreditService {

//	buna constructor injection denir
	ICalculationService _calculationService;
	
	public CreditService(ICalculationService _calculationService){
		this._calculationService = _calculationService;
	}
	
	public void apply(){
		_calculationService.calculate();
	}
	
}
