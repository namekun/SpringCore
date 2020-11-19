package hello.core.beanfind;

import hello.core.member.repository.MemberRepository;
import hello.core.member.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 두개 이상이면, 중복오류가 발생한다.")
    void findBeanByTypeDuplicate() {
        //expected single matching bean but found 2: memberRepository1,memberRepository2
        MemberRepository bean = ac.getBean(MemberRepository.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, ()->ac.getBean(MemberRepository.class));

    }

    @Test
    @DisplayName("타입으로 조회시, 중복되는 게 있다면, 빈 이름으로 조회하자")
    void findBeamByName(){
        MemberRepository bean = ac.getBean("no1",MemberRepository.class);
        org.assertj.core.api.Assertions.assertThat(bean).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회")
    void findAllBeanByType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        org.assertj.core.api.Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }


    @Configuration
    static class SameBeanConfig {
        @Bean("no1")
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean("no2")
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
