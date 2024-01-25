package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest { //jUnit5부터는 public 설정 안 해도 됨

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("모든 빈 출력하기")
  void findAllBean(){
    String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //bean 정의된 이름을 다 등록
    for (String beanDefinitionName : beanDefinitionNames) { //iter
      Object bean = ac.getBean(beanDefinitionName); //빈 이름으로 빈 객체(인스턴스)를 조회한다.
      System.out.println("name = " + beanDefinitionName + "object = " + bean);
    }
  }

  @Test
  @DisplayName("애플리케이션 빈 출력하기")
  void findApplicationBean(){
    String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 스프링에 등록된 모든 빈 이름을 조회한다
    for (String beanDefinitionName : beanDefinitionNames) { //iter
      BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);// bean하나하나에 대한 메타데이터 정보 꺼내옴

      //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈 (내가 application 개발하기위해 등록한 빈)
      //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
      if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) { // 스프링이 내부에서 사용하는 빈은 getRole() 로 구분할 수 있다.
        Object bean = ac.getBean(beanDefinitionName); //빈 이름으로 빈 객체(인스턴스)를 조회한다.
        System.out.println("name = " + beanDefinitionName + "object = " + bean);
      }
    }
  }
}
