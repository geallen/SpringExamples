package springaopannotationbased.service;

import org.springframework.beans.factory.annotation.Autowired;

import springaopannotationbased.cars.ElectricCar;
import springaopannotationbased.cars.PetrolCar;

public class Cars {

	@Autowired
	ElectricCar eCar;
	
	@Autowired
	PetrolCar pCar; 

	public ElectricCar geteCar() {
		return eCar;
	}

	public void seteCar(ElectricCar eCar) {
		this.eCar = eCar;
	}

	public PetrolCar getpCar() {
		return pCar;
	}

	public void setpCar(PetrolCar pCar) {
		this.pCar = pCar;
	}
	
	
}
