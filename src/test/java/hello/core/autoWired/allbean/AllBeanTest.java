package hello.core.autoWired.allbean;

import hello.core.AutoAppConfig;
import hello.core.carTest.AutoApplicationConfig;
import hello.core.carTest.car.Energy;
import hello.core.carTest.tank.FuelTank;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = applicationContext.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int fixDiscountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(fixDiscountPrice).isEqualTo(1000);

        int rateDiscountPolicy = discountService.discount(member, 20000, "rateDiscountPolicy");
        assertThat(rateDiscountPolicy).isEqualTo(2000);
    }


    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> discountPolicyList;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> discountPolicyList) {
            this.policyMap = policyMap;
            this.discountPolicyList = discountPolicyList;
            System.out.println("policyMap = " + policyMap);
            System.out.println("discountPolicyList = " + discountPolicyList);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }
    }

    @Test
    void findAllBeanTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoApplicationConfig.class, Fuel.class);
        Fuel fuel = ac.getBean(Fuel.class); // Fuel 클래스 타입에 해당하는 Bean을 가져와라.
        String energy1 = fuel.returnEnergy("gasolineOil");
        assertThat(energy1).isEqualTo("gasolineOil");
    }

    static class Fuel{
        Map<String, FuelTank> fuelTankMap;

        @Autowired
        public Fuel(Map<String, FuelTank> fuelTankMap){
            this.fuelTankMap = fuelTankMap;
            System.out.println("fuelTankMap = " + fuelTankMap);
        }

        public String returnEnergy(String fuelCode){
            FuelTank tank = fuelTankMap.get(fuelCode);
            return tank.getEnergy().getEnergy();
        }
    }
}
