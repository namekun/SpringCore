package hello.core.carTest;

import hello.core.carTest.car.Car;
import hello.core.carTest.fix.FixService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarApp {
    public static void main(String[] args) {
        // DI 도입
//        ApplicationConfig applicationConfig = new ApplicationConfig();
//        Car car = applicationConfig.carFuelTank();

        // java to spring
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoApplicationConfig.class);
        Car car = applicationContext.getBean("carFuelTank", Car.class);

        System.out.println("energy = " + car.runEngine().getEnergy());

        FixService fixService = applicationContext.getBean(FixService.class);
        fixService.getFixCost();
        fixService.getTransmissionInfo();
    }
}
