package com.ootd.project.dao;

import com.ootd.project.domain.member.CookieInfo;
import com.ootd.project.domain.member.LoginInfo;
import com.ootd.project.domain.member.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

    @Autowired
    SqlSession session;

    String namespace="com.ootd.project.dao.memberMapper.";

    public int registerMember(Member member) {
        return session.insert(namespace + "registerMember", member);
    }
    public int validMember(String memberId) {
        return session.selectOne(namespace + "validMember", memberId);
    }
    public CookieInfo loginMember(LoginInfo loginInfo) {
        return session.selectOne(namespace + "loginMember", loginInfo);
    }

}
