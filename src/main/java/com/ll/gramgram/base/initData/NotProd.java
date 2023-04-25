package com.ll.gramgram.base.initData;

import com.ll.gramgram.boundedContext.instaMember.service.InstaMemberService;
import com.ll.gramgram.boundedContext.likeablePerson.service.LikeablePersonService;
import com.ll.gramgram.boundedContext.member.entity.Member;
import com.ll.gramgram.boundedContext.member.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev", "test"})
public class NotProd {
    @Bean
    CommandLineRunner initData(
            MemberService memberService,
            InstaMemberService instaMemberService,
            LikeablePersonService likeablePersonService
    ) {
        return args -> {
            Member memberAdmin = memberService.join("admin", "1234").getData();
            Member memberUser1 = memberService.join("user1", "1234").getData();
            Member memberUser2 = memberService.join("user2", "1234").getData();
            Member memberUser3 = memberService.join("user3", "1234").getData();
            Member memberUser4 = memberService.join("user4", "1234").getData();

            Member memberUser5ByKakao = memberService.whenSocialLogin("KAKAO", "KAKAO__2741065164").getData();
            Member memberUser6ByGoogle = memberService.whenSocialLogin("GOOGLE", "GOOGLE__108807467778601732233").getData();
            Member memberUser7ByNaver = memberService.whenSocialLogin("NAVER", "NAVER__Stwu9hvf1kOSnCSigg_Xudq0xAkzKt2Zky_pJWb2b1k").getData();

            instaMemberService.connect(memberUser2, "insta_user2", "M");
            instaMemberService.connect(memberUser3, "insta_user3", "W");
            instaMemberService.connect(memberUser4, "insta_user4", "M");
//
//            likeablePersonService.like(memberUser3, "insta_user4", 1);
//            likeablePersonService.like(memberUser3, "insta_user109", 2);
//            likeablePersonService.like(memberUser3, "insta_user108", 2);
//            likeablePersonService.like(memberUser3, "insta_user107", 2);
//            likeablePersonService.like(memberUser3, "insta_user106", 2);
//            likeablePersonService.like(memberUser3, "insta_user105", 2);
//            likeablePersonService.like(memberUser3, "insta_user104", 2);
//            likeablePersonService.like(memberUser3, "insta_user103",  2);
//            likeablePersonService.like(memberUser3, "insta_user102", 2);
//            likeablePersonService.like(memberUser3, "insta_user101", 2);

        };
    }
}
