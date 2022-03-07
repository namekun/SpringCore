package hello.core.car.tank;

import hello.core.car.car.Energy;

public class ElectricBattery implements FuelTank {

    @Override
    public Energy getEnergy() {
        String type = "eletric";
        Energy energy = new Energy();
        energy.setEnergy(type);
        return energy;
    }
}
