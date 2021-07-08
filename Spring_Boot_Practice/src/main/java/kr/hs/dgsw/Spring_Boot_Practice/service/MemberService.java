package kr.hs.dgsw.Spring_Boot_Practice.service;

import kr.hs.dgsw.Spring_Boot_Practice.domain.Member;
import kr.hs.dgsw.Spring_Boot_Practice.repository.MemberRepository;
import kr.hs.dgsw.Spring_Boot_Practice.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        // 회원가입
        // 같은 이름의 중복 회원 X

        validateDuplicateMember(member);        // 중복 회원 검증



        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())       //반환 형이 Optional 임
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

        // ifPresent 메서드 : 이미 값이 있는지를 체크해줌
        // Optional 자료형이기에 가능함
    }

    // 전체 회원 조회회
   public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
