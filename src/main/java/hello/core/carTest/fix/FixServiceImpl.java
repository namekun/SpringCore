package hello.core.carTest.fix;

import hello.core.carTest.tank.FuelTank;
import hello.core.carTest.transmission.Transmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class FixServiceImpl implements FixService {

    private final FuelTank fuelTank;
    private final Transmission transmission;

//    @Autowired
//    public void setFuelTank(FuelTank fuelTank){
//        this.fuelTank = fuelTank;
//    }
//
//    @Autowired
//    public void setTransmission(Transmission transmission) {
//        this.transmission = transmission;
//    }

    @Autowired
    public FixServiceImpl(FuelTank fuelTank, Transmission transmission) {
        this.fuelTank = fuelTank;
        this.transmission = transmission;
    }

    @Override
    public void getFixCost() {
        if(transmission.getInfo().equals("auto")){
            System.out.println("auto는 비싸서 10000원~");
        } else {
            System.out.println("manual은 싸서 5000원~");
        }
    }

    @Override
    public void getTransmissionInfo() {
        System.out.println("transmission = " + transmission.getInfo());
    }


    // Test
    public FuelTank getFuelTank() {
        return fuelTank;
    }
}
