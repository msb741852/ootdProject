package com.ootd.project.service;

import com.ootd.project.dao.MemberDao;
import com.ootd.project.domain.member.CookieInfo;
import com.ootd.project.domain.member.LoginInfo;
import com.ootd.project.domain.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberDao memberDao;

    public String registerMember(Member member) {
        if(memberDao.validMember(member.getMemberId()) != 1) {
            memberDao.registerMember(member);
            return "회원가입 완료";
        }
        return "이미 존재하는 아이디입니다.";
    }

    public CookieInfo loginMember(LoginInfo loginInfo) {
        return memberDao.loginMember(loginInfo);
    }
}
