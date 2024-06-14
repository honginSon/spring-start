package hello.hello_spring_2;

import hello.hello_spring_2.repository.MemberRepository;
import hello.hello_spring_2.repository.MemoryMemberRepository;
import hello.hello_spring_2.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
