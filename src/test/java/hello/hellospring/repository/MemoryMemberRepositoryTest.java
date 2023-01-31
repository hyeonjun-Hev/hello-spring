package hello.hellospring.repository;

import hello.hellospring.domain.Member;
//import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/*
* test 메서드들의 실행 순서가 고려되지 않는다. 각 test가 독립적으로 작동하게 해야한다.
* */

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result =  repository.findById(member.getId()).get();//Optional에서는 get()으로 꺼낸다. 하지만, 그닥 좋은 방법은 아님
//        System.out.println("result = "+(result==member));
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);//member가 result와 같아? 라는 테스트
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);


    }
}
