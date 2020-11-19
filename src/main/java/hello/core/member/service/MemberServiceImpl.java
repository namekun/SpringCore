package hello.core.member.service;

import hello.core.OrderApp;
import hello.core.member.model.Member;
import hello.core.member.repository.MemberRepository;

/**
 * 인터페이스에 대한 구현체가 한개만 있을때에는 Impl이라고 이름을 쓴다.
 */
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // for test
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
