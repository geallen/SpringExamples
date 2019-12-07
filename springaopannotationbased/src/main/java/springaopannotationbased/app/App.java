package springaopannotationbased.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import springaopannotationbased.config.Configur;
import springaopannotationbased.service.Cars;

public class App {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configur.class);
		Cars car = context.getBean("cars", Cars.class);
		try {
			//car.getpCar().run(100, 50);
			car.getpCar().run("deneme");
			//car.getpCar().test();
			//car.geteCar().run();
		} catch (Exception e) {
			System.out.println("Exception occured " + e.getMessage());
		}
		//car.geteCar().run();
		context.close();
	}

}
