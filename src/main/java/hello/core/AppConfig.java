package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { //애플리케이션 전체를 설정하고 구성한다

  //@Bean memberService -> new MemoryMemberRepository()
  //@Bean orderService -> new MemoryMemberRepository()

  //call AppConfig.memberService
  //call AppConfig.memberRepository
  //call AppConfig.orderService

  @Bean //스프링 컨테이너에 등록된다
  public MemberService memberService(){
    System.out.println("call AppConfig.memberService"); //soutm
    return new MemberServiceImpl(memberRepository()); //ctrl + art + m
  }

  @Bean
  public MemberRepository memberRepository() {
    System.out.println("call AppConfig.memberRepository");
    return new MemoryMemberRepository();
  }
//  if (memoryMemberRepository가 이미 스프링 컨테이너에 등록되어 있으면?) {
//    return 스프링 컨테이너에서 찾아서 반환;
//  } else { //스프링 컨테이너에 없으면
//    기존 로직을 호출해서 MemoryMemberRepository를 생성하고 스프링 컨테이너에 등록
//    return 반환
//  }


  @Bean
  public OrderService orderService(){
    System.out.println("call AppConfig.orderService");
    return new OrderServiceImpl(memberRepository(), discountPolicy());
//    return null;
  }

  @Bean
  public DiscountPolicy discountPolicy(){
//    return new FixDiscountPolicy();
    return new RateDiscountPolicy();
  }

}
