package com.ootd.project.domain.member;

public class CookieInfo {
    private Integer memberIdx;
    private String memberNickname;

    public Integer getMemberIdx() {
        return memberIdx;
    }

    public void setMemberIdx(Integer memberIdx) {
        this.memberIdx = memberIdx;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    @Override
    public String toString() {
        return "CookieInfo{" +
                "memberIdx=" + memberIdx +
                ", memberNickname='" + memberNickname + '\'' +
                '}';
    }
}
