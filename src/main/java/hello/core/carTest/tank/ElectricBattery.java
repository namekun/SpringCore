package hello.core.carTest.tank;

import hello.core.carTest.car.Energy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ElectricBattery implements FuelTank {

    @Override
    public Energy getEnergy() {
        String type = "eletric";
        Energy energy = new Energy();
        energy.setEnergy(type);
        return energy;
    }
}
