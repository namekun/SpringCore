package hello.core.car.car;

import hello.core.car.tank.FuelTank;

public class CarImpl implements Car {
    //    private final FuelTank fuelTank = new GasolineOil();
    //    private final FuelTank fuelTank = new ElectricBattery();

    private final FuelTank fuelTank;

    public CarImpl(FuelTank fuelTank) {
        this.fuelTank = fuelTank;
    }

    @Override
    public Energy runEngine() {
        return fuelTank.getEnergy();
    }
}
