package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
// 순수 자바로 테스트 작성
public class MemberApp {

  public static void main(String[] args) { //psvm
    MemberService memberService = new MemberServiceImpl();
    Member member = new Member(1L, "memberA", Grade.VIP); //ctrl + art + v
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    System.out.println("new member = " + member.getName());
    System.out.println("findMember = " + findMember.getName()); //soutv
    // 눈으로 직접 검증해야함...
  }
}