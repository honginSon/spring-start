package hello.hello_spring_2;

import hello.hello_spring_2.repository.JdbcMemberRepository;
import hello.hello_spring_2.repository.JdbcTemplateMemberRepository;
import hello.hello_spring_2.repository.MemberRepository;
import hello.hello_spring_2.repository.MemoryMemberRepository;
import hello.hello_spring_2.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
