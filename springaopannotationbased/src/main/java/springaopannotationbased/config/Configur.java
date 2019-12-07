package springaopannotationbased.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import springaopannotationbased.aspects.Diagnos;
import springaopannotationbased.cars.ElectricCar;
import springaopannotationbased.cars.PetrolCar;
import springaopannotationbased.service.Cars;

@Configuration
@EnableAspectJAutoProxy
public class Configur {

	@Bean("electricCar")
	public ElectricCar electricCar() {
		return new ElectricCar();
	}
	
	@Bean("petrolCar")
	public PetrolCar petrolCar() {
		return new PetrolCar();
	}
	
	@Bean("cars")
	public Cars cars() {
		return new Cars();
	}
	
	@Bean("diagnos")
	public Diagnos diagnos() {
		return new Diagnos();
	}
}
