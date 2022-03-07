package hello.core.car;

import hello.core.car.car.Car;
import hello.core.car.car.CarImpl;
import hello.core.car.tank.FuelTank;
import hello.core.car.tank.GasolineOil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public Car carFuelTank() {
        return new CarImpl(getFuelTank());
    }

    @Bean
    public FuelTank getFuelTank() {
        return new GasolineOil();
//        return new ElectricBattery();
    }
}
