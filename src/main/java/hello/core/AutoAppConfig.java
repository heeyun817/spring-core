package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( //@어노테이션이 붙은 클래스를 찾아서 자동으로 스프링 빈으로 등록해줌
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //뺄 어노테이션을 지정 -> 기존 예제 코드를 제외하기 위해
)
public class AutoAppConfig {

//  @Bean(name = "memoryMemberRepository") //수동 빈 등록 vs 자동 빈 등록 -> 수동 빈 등록이 우선권(수동 빈이 자동 빈을 오버라이딩)
//  MemberRepository memberRepository(){
//    return new MemoryMemberRepository();
//  }
}
