package hello.core.carTest.tank;

import hello.core.carTest.car.Energy;
import org.springframework.stereotype.Component;

@Component
public class GasolineOil implements FuelTank{

    @Override
    public Energy getEnergy() {
        String type = "Gasoline";
        Energy energy = new Energy();
        energy.setEnergy(type);
        return energy;
    }

}
