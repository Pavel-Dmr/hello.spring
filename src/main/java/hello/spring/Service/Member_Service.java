package hello.spring.Service;

import hello.spring.Domain.Member;
import hello.spring.Repository.Member_Repository;
import hello.spring.Repository.MemoryMember_Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Member_Service {

    // Service 만들기위한
    private final Member_Repository member_repository = new MemoryMember_Repository();

//    TODO 주 메소드
    public Long Join(Member member)
    {
//      같은 이름이 있는 중복회원 X

        boolean Option_01 = false;
        boolean Option_02 = true;

        if(Option_01)
        {
            Optional<Member> result = member_repository.findByName(member.getName());

            result.ifPresent(m -> { throw new IllegalStateException("이미 존재하는 회원입니다");});
        }

        if(Option_02)
        {
            Validate_DuplicateMember(member);
        }

        member_repository.save(member);
        return member.getId();
    }

//    전체회원 조회
    public List<Member> Find_MemberList()
    {
        return member_repository.findAll();
    }

//   TODO 모듈 메소드
    private void Validate_DuplicateMember(Member member) {

        member_repository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });

    }

    public Optional<Member> Find_One(Long member_id)
    {
        return member_repository.findById(member_id);
    }



}
