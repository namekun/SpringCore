package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.enums.Grade;
import hello.core.member.model.Member;
import hello.core.member.service.MemberService;
import hello.core.order.model.Order;
import hello.core.order.service.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach // test 실행전에 setting. 마치 init 과 같다.
    public void setServices(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        String memberName = "member a";
        Grade memberGrade = Grade.VIP;
        Member member = new Member(memberId, memberName, memberGrade);
        memberService.join(member);

        String itemName = "item A";
        int itemPrice = 10000;
        Order order = orderService.createOrder(memberId, itemName, itemPrice);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
