package hello.spring.Repository;

import hello.spring.Domain.Member;

import java.util.List;
import java.util.Optional;

public interface Member_Repository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
