package hello.spring.Service;

import hello.spring.Domain.Member;
import hello.spring.Repository.MemoryMember_Repository;
import hello.spring.Repository.MemoryMember_RepositoryTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class Member_Service_Test {

    Member_Service member_service = new Member_Service();
    MemoryMember_Repository memoryMember_repository = new MemoryMember_Repository();


    @AfterEach
    public void AfterEach()
    {
        memoryMember_repository.ClearStore();
    }

    @Test
    void 회원가입()
    {
        //given 어떤상황이 주어지고
        Member member = new Member();
        member.setName("spring");

        //when 이걸 실행했을때
        Long save_id = member_service.Join(member);

        //then 결과가 이게 나와야함
        Member find_member = member_service.Find_One(save_id).get();
        assertThat(member.getName()).isEqualTo(find_member.getName());
    }

    @Test
    public void 중복회원_예외()
    {
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

//        When
        member_service.Join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,() -> member_service.Join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

        // then


    }
    @Test
    void Find_Member_List()
    {

    }
}
