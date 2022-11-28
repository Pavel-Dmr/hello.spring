//package hello.spring;
//
//import hello.spring.Domain.Member;
//import hello.spring.Repository.Member_Repository;
//import hello.spring.Repository.MemoryMember_Repository;
//import hello.spring.Service.Member_Service;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//import java.util.Optional;
//
//@Configuration
//public class Spring_Config {
//
//    //자바 코드로 스프링 컨터이너에 스프링 빈을 등록하는 방법
//    //직접 설정 파일을 등록하여 스프링 컨터이너에 스프링 빈을 등록하는 방법
//    @Bean
//    public Member_Service member_service()
//    {
//        return new Member_Service();
//    }
//
//    @Bean
//    public Member_Repository member_repository()
//    {
//        return new MemoryMember_Repository();
//    }
//
//}
