package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 순수 자바로 테스트 작성
public class MemberApp {

  public static void main(String[] args) { //psvm
//    AppConfig appConfig = new AppConfig();
//    MemberService memberService = appConfig.memberService();

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // AppConfig에 있는 환경 설정 정보를 스프링 컨테이너에 넣고 다 관리함
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//memberService메서드 이름을 찾음(타입은 MemberService인거)

    Member member = new Member(1L, "memberA", Grade.VIP); //ctrl + art + v
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    System.out.println("new member = " + member.getName());
    System.out.println("findMember = " + findMember.getName()); //soutv
    // 눈으로 직접 검증해야함...
  }
}
