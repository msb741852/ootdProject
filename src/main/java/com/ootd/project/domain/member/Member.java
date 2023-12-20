package com.ootd.project.domain.member;

public class Member {
    private int memberIdx;
    private String memberId;
    private String memberPw;
    private String memberNickname;

    public Member() {
    }

    public Member(String memberId, String memberPw, String memberNickname) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberNickname = memberNickname;
    }

    public int getMemberIdx() {
        return memberIdx;
    }

    public void setMemberIdx(int memberIdx) {
        this.memberIdx = memberIdx;
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

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberIdx=" + memberIdx +
                ", memberId='" + memberId + '\'' +
                ", memberPw='" + memberPw + '\'' +
                ", memberNickname='" + memberNickname + '\'' +
                '}';
    }
}
