package hello.core.carTest.car;

import hello.core.carTest.tank.FuelTank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CarImpl implements Car {
    //    private final FuelTank fuelTank = new GasolineOil();
    //    private final FuelTank fuelTank = new ElectricBattery();

    private final FuelTank fuelTank;

    @Autowired
    public CarImpl(FuelTank fuelTank) {
        this.fuelTank = fuelTank;
    }

    @Override
    public Energy runEngine() {
        return fuelTank.getEnergy();
    }

    // for Test
    public FuelTank getFuelTank() {
        return fuelTank;
    }
}
