package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    // 지금 이 형태는 MemberService의 MemoryMemberRepository와 다르다. 테스트 java 파일과 MemberService 파일의 객체가 다르기 때문, 이 부분은 DI로 해결해야 합니다.

    @BeforeEach //test code 시작 전에 실행
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
        //memberRepository를 service에 외부에서 넣어준다.
        // Q. test코드는 실행시 포함이 안된다고 했는데 그럼 실제 구동시 repository는 누가 넣어주는 걸까?
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore(); // 꼭 초기화 해줘야된다.
    }

    @Test
    void 회원가입() {//한글로 작성해도 된다. test 입장
        //given -> 뭔가가 주어졌을때
        Member member = new Member();
        member.setName("spring");
        //when -> 이걸 실행 했을때
        Long saveId = memberService.join(member);
        //then -> 결과가 이게 나와야해
        Member findMember = memberService.findOne(saveId).get();
        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
        // 저장이 되는 부분만 있음
    }
    @Test
    public void  중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*try {
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            org.assertj.core.api.Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 입니다.1234");
        }*/


        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}