package com.jhklab.hellospring;

import com.jhklab.hellospring.repository.JdbcMemberRepository;
import com.jhklab.hellospring.repository.JdbcTemplateMemberRepository;
import com.jhklab.hellospring.repository.JpaMemberRepository;
import com.jhklab.hellospring.repository.MemberRepository;
import com.jhklab.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }

    //    private DataSource dataSource;
//    private EntityManager em;

//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }
}
