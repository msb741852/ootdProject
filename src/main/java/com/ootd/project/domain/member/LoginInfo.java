package com.ootd.project.domain.member;

public class LoginInfo {
    private String memberId;
    private String memberPw;

    public LoginInfo() {
    }

    public LoginInfo(String memberId, String memberPw) {
        this.memberId = memberId;
        this.memberPw = memberPw;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "memberId='" + memberId + '\'' +
                ", memberPw='" + memberPw + '\'' +
                '}';
    }
}
