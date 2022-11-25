package hello.spring.Repository;

import hello.spring.Domain.Member;
import hello.spring.Service.Member_Service;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMember_RepositoryTest {

    Member_Service member_service;
    MemoryMember_Repository memoryMember_repository = new MemoryMember_Repository();

    @BeforeEach
    public void BeforeEach()
    {
        memoryMember_repository = new MemoryMember_Repository();
        Member_Service member_service = new Member_Service();
    }
//    각 테스트 단위마다 실행
    @AfterEach
    public void AfterEach()
    {
        memoryMember_repository.ClearStore();
    }

    @Test
    void save()
    {
        Member member = new Member();
        member.setName("spring");

        memoryMember_repository.save(member);
        Member result = memoryMember_repository.findById(member.getId()).get();
//        Optional 에서 id를 꺼낼려면 get()을 사용한다.
//        System.out.println("result = " + (result == member));
//
//        Assertions.assertEquals(result,member);
//        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
        
        assertThat(member).isEqualTo(result);
    }

    @Test
    void finyById()
    {

    }

    @Test
    void findByName()
    {
        Member member1 = new Member();
        member1.setName("spring1");
        memoryMember_repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memoryMember_repository.save(member2);

        Member result = memoryMember_repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    void findAll()
    {
        Member member1 = new Member();
        member1.setName("spring1");
        memoryMember_repository.save(member1);

        Member member2 = new Member();
        member1.setName("spring2");
        memoryMember_repository.save(member2);

        List<Member> result = memoryMember_repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
