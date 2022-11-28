package hello.spring.Controller;

import hello.spring.DTO.Member_Form;
import hello.spring.Domain.Member;
import hello.spring.Service.Member_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Member_Controller {

    private final Member_Service member_service;

    // 안정성이 높은 방식
    @Autowired
    public Member_Controller(Member_Service member_service) {
        this.member_service = member_service;
    }

    //모든 컨트롤러에서 사용하는 서비스 객체가 같게하기 위해서 스프링 컨테니어에 서비스 객체를 등록
    //@Autowired 사용하는데 생성자에 이 어노테이션이 있으면 인자로 받은 값을
    //스프링 컨테이너에 있는 Member_Service에 연결을 시켜준다

    //한번만 생성되어 하나의 회원 서비스 인스턴스를 각각의 컨트롤러들이 공유하는 것이 좋다


    @GetMapping("/member/new")
    public String Create_Form()
    {
        return "Member/Create_Member_Form";
    }

    @PostMapping("member/new")
    public String Create(Member_Form form)
    {
        Member member = new Member();
        member.setName(form.getName());

        member_service.Join(member);

        System.out.println(member.getId());
        System.out.println(member.getName());
        return "redirect:/";
    }

    @GetMapping("/member")
    public String List(Model model)
    {
        List<Member> member_list = member_service.Find_MemberList();
        model.addAttribute("member_list",member_list);

        return "Member/Member_List";
    }

}
