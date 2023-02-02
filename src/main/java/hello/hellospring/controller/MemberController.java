package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired // memberService를 spring container에서 가져와서 넣어주는 어노테이션  >> DI 생성자 주입 방식
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
//    DI setter 주입 방식
//    @Autowired //생성은 생성대로 되고, set도 해줌. -> 단점 public으로 열려있어야 하기 때문에, 중간에 바뀌게 되면 문제가 생긴다.
//    //Application 조립할때만 바꾸지, 다 세팅 된 상태에서는 바뀔일이 없다.
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//        memberService.setMemberRepository(); // 이렇게 되면 모든 개발자가 접근이 가능해진다. 재호출 되어 변경 안되게 작성해야한다.
//    }

//    @Autowired private  MemberService memberService; -> DI 필드 주입 방식 ; 선호하지 않음. Reason >> 픽스되기 때문에 굳이 쓰진 않음
}
//이 상태면 Spring 프로젝트가 실행 될떄
//Spring container 에 Controller 어노테이션이 붙은 class 들은 객체가 자동 생성된다.
