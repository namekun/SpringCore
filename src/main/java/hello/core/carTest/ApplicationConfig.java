package hello.core.carTest;

import hello.core.carTest.car.Car;
import hello.core.carTest.car.CarImpl;
import hello.core.carTest.fix.FixService;
import hello.core.carTest.fix.FixServiceImpl;
import hello.core.carTest.tank.FuelTank;
import hello.core.carTest.tank.GasolineOil;
import hello.core.carTest.transmission.AutoTransmission;
import hello.core.carTest.transmission.Transmission;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public Car carFuelTank() {
        System.out.println("ApplicationConfig.carFuelTank");
        return new CarImpl(getFuelTank());
    }

    @Bean
    public FuelTank getFuelTank() {
        System.out.println("ApplicationConfig.getFuelTank");
        return new GasolineOil();
//        return new ElectricBattery();
    }

    @Bean
    public FixService fixService(){
        System.out.println("ApplicationConfig.fixService");
        return new FixServiceImpl(getFuelTank(), getTransmissionInfo());
    }

    @Bean
    public Transmission getTransmissionInfo(){
        System.out.println("ApplicationConfig.getTransmissionInfo");
        return new AutoTransmission();
    }
}
