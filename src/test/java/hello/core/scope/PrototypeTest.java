package hello.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import hello.core.scope.SingletonTest.SingletonBean;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class PrototypeTest {

  @Test
  void prototypeBeanFind(){
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
    System.out.println("find prototypeBean1");
    PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
    System.out.println("find prototypeBean2");
    PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
    System.out.println("prototypeBean1 = " + prototypeBean1);
    System.out.println("prototypeBean2 = " + prototypeBean2);
    assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

    // 만약 닫아주고 싶으면 수동으로 직접 호출
//    prototypeBean1.destory();
//    prototypeBean2.destory();
    ac.close();
  }

  @Scope("prototype")
  @Component
  static class PrototypeBean{
    @PostConstruct
    public void init(){
      System.out.println("PrototypeBean.init");
    }

    @PreDestroy
    public void destory(){
      System.out.println("PrototypeBean.destory");
    }
  }
}
