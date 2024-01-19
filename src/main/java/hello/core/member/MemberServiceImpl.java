package hello.core.member;

public class MemberServiceImpl implements MemberService{

  private final MemberRepository memberRepository = new MemoryMemberRepository(); //할당하는 부분이 구현체에 의존 (DIP위반)

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
