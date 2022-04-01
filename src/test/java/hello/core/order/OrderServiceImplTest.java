package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemberRepository repository = new MemoryMemberRepository();
        MemberServiceImpl memberService = new MemberServiceImpl(repository);
        memberService.join(new Member(1L, "hi", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(repository, new FixDiscountPolicy());
        orderService.createOrder(1L, "memeberA", 5000);
    }

}