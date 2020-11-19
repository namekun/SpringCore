package hello.core.discount;

import hello.core.member.enums.Grade;
import hello.core.member.model.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10% 할인이 적용되어야한다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int disCountRate = rateDiscountPolicy.discount(member , 10000);
        //then
        assertThat(disCountRate).isEqualTo(1000);
    }

    @Test
    @DisplayName("vip가 아니면 할인이 되면 안된다.")
    void vip_x(){
        //given
        Member member = new Member(1L, "memberBasic", Grade.BASIC);
        //when
        int disCountRate = rateDiscountPolicy.discount(member , 10000);
        //then
        assertThat(disCountRate).isNotEqualTo(1000);
    }
}