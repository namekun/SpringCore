package hello.core.discount;

import hello.core.member.enums.Grade;
import hello.core.member.model.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private final double discountRate = 0.1;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return (int) (price*discountRate);
        } else {
            return 0;
        }
    }
}
