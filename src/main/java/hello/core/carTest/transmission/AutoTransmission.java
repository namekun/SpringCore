package hello.core.carTest.transmission;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class AutoTransmission implements Transmission {
    @Override
    public void changeGear() {
        System.out.println("자동으로 바뀝니다아");
    }

    @Override
    public String getInfo() {
        return "auto";
    }
}
