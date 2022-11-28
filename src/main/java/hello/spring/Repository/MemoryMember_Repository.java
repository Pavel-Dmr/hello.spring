package hello.spring.Repository;

import hello.spring.Domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMember_Repository implements Member_Repository {


    private static Map<Long,Member> store = new HashMap<>();

    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
//    같은 name을 가지고 있는 객체를 찾으면 반환.없으면 null 반환
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void ClearStore()
    {
        store.clear();
    }
}
