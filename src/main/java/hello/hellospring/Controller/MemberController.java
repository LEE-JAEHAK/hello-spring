package hello.hellospring.Controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

//    @Autowired
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }

    @GetMapping(value = "/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "/new")
    public String create(String name) {
        Member member = new Member();
        member.setName(name);
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping(value = "")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
