package ocp;

public class StarbucksCoffeeService implements ICoffeeService {

	
	StarbucksCampain starbucksCampain;
	
	 public StarbucksCoffeeService(StarbucksCampain campain) {
		this.starbucksCampain = campain;
	}
	 
	 public StarbucksCoffeeService() {
			
		}
	@Override
	public void sell() {
		starbucksCampain.giveStar();
		System.out.println("starbucks coffee sell");
	}
	
}
