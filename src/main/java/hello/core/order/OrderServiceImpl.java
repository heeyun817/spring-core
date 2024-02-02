package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

//  @Autowired // 필드 주입
  private MemberRepository memberRepository; //DIP만족
//  @Autowired
  private DiscountPolicy discountPolicy;

  //  @Autowired(required = false) //수정자 (@Autowired빼면 안들어옴)
//  public void setMemberRepository(MemberRepository memberRepository) {
//    this.memberRepository = memberRepository;
//  }
//  @Autowired //수정자 (@Autowired빼면 안들어옴)
//  public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//    this.discountPolicy = discountPolicy;
//  }
//
  @Autowired // 생성자가 딱 1개만 있으면 @Autowired를 생략해도 자동 주입 됨(스프링 빈에만 해당)
  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Autowired // 일반 메서드 주입
  public void init(MemberRepository memberRepository,DiscountPolicy discountPolicy){
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }  // 단일 책임 원칙을 잘 지킴

  // 테스트 용도
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
