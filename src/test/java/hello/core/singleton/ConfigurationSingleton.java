package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.carTest.ApplicationConfig;
import hello.core.carTest.car.CarImpl;
import hello.core.carTest.fix.FixServiceImpl;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingleton {

    @Test
    void configurationTest(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = annotationConfigApplicationContext.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = annotationConfigApplicationContext.getBean("orderService", OrderServiceImpl.class);

        System.out.println("memberService.getMemberRepository() = " + memberService.getMemberRepository());
        System.out.println("orderService.getMemberRepository() = " + orderService.getMemberRepository());

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(orderService.getMemberRepository());
    }

    @Test
    void test(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        CarImpl carFuelTank = annotationConfigApplicationContext.getBean("carFuelTank", CarImpl.class);
        FixServiceImpl fixService = annotationConfigApplicationContext.getBean("fixService", FixServiceImpl.class);

        System.out.println("carFuelTank.getFuelTank() = " + carFuelTank.getFuelTank());
        System.out.println("fixService.getFuelTank() = " + fixService.getFuelTank());

        Assertions.assertThat(carFuelTank.getFuelTank()).isSameAs(fixService.getFuelTank());
    }

    @Test
    void configurationDeep(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ApplicationConfig bean = annotationConfigApplicationContext.getBean(ApplicationConfig.class);
        System.out.println("bean = " + bean.getClass());
    }
}
