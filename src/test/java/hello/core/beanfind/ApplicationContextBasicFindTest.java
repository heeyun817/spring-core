package hello.core.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextBasicFindTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("빈 이름으로 조회")
  void findBeanByName(){
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    assertThat(memberService).isInstanceOf(MemberService.class);
  }

  @Test
  @DisplayName("이름 없이 타입으로만 조회")
  void findBeanByType(){
    MemberService memberService = ac.getBean(MemberService.class);
    assertThat(memberService).isInstanceOf(MemberService.class);
  }

  @Test
  @DisplayName("구체 타입으로 조회") //구현에 의존해서 좋은 코드는 아님
  void findBeanByName2(){
    MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class); //스프링 빈에 등록된 인스턴스 타입을 보고 결정하기 때문에 인터페이스 아니어도됨
    assertThat(memberService).isInstanceOf(MemberService.class);
  }

  @Test //실패테스트
  @DisplayName("빈 이름으로 조회X")
  void findBeanByNameX(){
//    MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> ac.getBean("xxxxx", MemberService.class));
  }

}
