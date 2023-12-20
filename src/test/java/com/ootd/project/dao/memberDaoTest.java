package com.ootd.project.dao;

import com.ootd.project.domain.member.LoginInfo;
import com.ootd.project.domain.member.Member;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class memberDaoTest {

    @Autowired
    MemberDao memberDao;

    @Test
    public void registerMember() {
    // given - 회원가입 하는 상황
    // when - member 테이블에 추가하려는 아이디가 존재하지 않으면 회원이 추가 됨
    // then - insert 성공 시 return 1
        Member member = new Member("soop1", "123", "heu");
        if(memberDao.validMember(member.getMemberId()) != 1) {
            Assertions.assertEquals(1, memberDao.registerMember(member));
        }
        System.out.println("이미 존재하는 아이디입니다.");
    }

    @Test
    public void loginMember() {
        LoginInfo loginInfo = new LoginInfo("admin", "123123");
        System.out.println(memberDao.loginMember(loginInfo));
    }
}