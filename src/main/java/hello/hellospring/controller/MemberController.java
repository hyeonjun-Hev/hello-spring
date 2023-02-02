package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired // memberService를 spring container에서 가져와서 넣어주는 어노테이션
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
//이 상태면 Spring 프로젝트가 실행 될떄
//Spring container 에 Controller 어노테이션이 붙은 class 들은 객체가 자동 생성된다.
