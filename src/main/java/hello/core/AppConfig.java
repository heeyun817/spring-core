package hello.core;

import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

public class AppConfig { //애플리케이션 전체를 설정하고 구성한다

  // 생성자 주입
  public MemberService memberService(){
    return new MemberServiceImpl(new MemoryMemberRepository());
  }

  public OrderService orderService(){
    return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
  }

}
