package hello.core.car;

import hello.core.car.car.Car;
import hello.core.car.tank.FuelTank;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarApp {
    public static void main(String[] args) {
        // DI 도입
//        ApplicationConfig applicationConfig = new ApplicationConfig();
//        Car car = applicationConfig.carFuelTank();

        // java to spring
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Car car = applicationContext.getBean("carFuelTank", Car.class);

        System.out.println("energy = " + car.runEngine().getEnergy());
    }
}
