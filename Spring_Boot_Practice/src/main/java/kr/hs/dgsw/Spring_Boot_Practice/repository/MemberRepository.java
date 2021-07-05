package kr.hs.dgsw.Spring_Boot_Practice.repository;

import kr.hs.dgsw.Spring_Boot_Practice.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
