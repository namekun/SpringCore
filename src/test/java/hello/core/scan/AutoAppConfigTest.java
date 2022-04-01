package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.carTest.AutoApplicationConfig;
import hello.core.carTest.car.CarImpl;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan1(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    void basicScan2(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoApplicationConfig.class);
        CarImpl carImpl = ac.getBean(CarImpl.class);
        assertThat(carImpl).isInstanceOf(CarImpl.class);
    }
}
