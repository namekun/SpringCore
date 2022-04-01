package hello.core.autoWired;

import hello.core.carTest.tank.FuelTank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false)
        public void setNoBean1(FuelTank fuelTank){
            System.out.println("fuelTank1 = " + fuelTank);
        }

        @Autowired
        public void setNoBean2(@Nullable FuelTank fuelTank){
            System.out.println("fuelTank2 = " + fuelTank);
        }

        @Autowired
        public void setNoBean3(Optional<FuelTank> fuelTank){
            System.out.println("fuelTank3 = " + fuelTank);
        }
    }
}
