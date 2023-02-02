package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //이 어노테이션이 붙은 파일의 package만 모든 스프링 컨테이너에 적재된다.
// 타 package는 @componentScan 이 붙어야 하는것으로 보인다.
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
