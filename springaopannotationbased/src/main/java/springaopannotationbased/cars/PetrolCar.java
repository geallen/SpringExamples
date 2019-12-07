package springaopannotationbased.cars;

public class PetrolCar {

	public void run() throws Exception {
		System.out.println("running petrol car");
	//	throw new Exception("Petrol car exception");
	}
	
	public void run(int speed) {
		System.out.println("running with speed " + speed);
	}
	
	public void run(int speed, int kms) {
		System.out.println("running with speed "+ speed + " for "+ kms);
	}
	
	public String run(String msg){
		System.out.println(msg);
		return msg;
	}
	
	public void test() {
		System.out.println("Test");
	}
}
