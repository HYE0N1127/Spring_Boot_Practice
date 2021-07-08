package kr.hs.dgsw.Spring_Boot_Practice.repository;

import kr.hs.dgsw.Spring_Boot_Practice.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class MemoryMemberRepositoryTest {
    // Spring은 코드의 순서대로 코드가 실행되지 않고 직접 순서를 설정함
    // 그렇기에 끝날때 마다 저장된 객체들을 삭제하는 메서드를 Call Back 해주어야됨

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach      // 끝날때마다 동작하는 메서드
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("HyeonBin");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);    // member 라는 기댓값과 result라는 실제 값이 다르다면 오류 산출, 같다면 아무 문제 없음.
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
