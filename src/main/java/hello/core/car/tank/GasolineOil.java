package hello.core.car.tank;

import hello.core.car.car.Energy;

public class GasolineOil implements FuelTank{

    @Override
    public Energy getEnergy() {
        String type = "Gasoline";
        Energy energy = new Energy();
        energy.setEnergy(type);
        return energy;
    }
}
