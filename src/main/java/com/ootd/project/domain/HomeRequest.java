package com.ootd.project.domain;

public class HomeRequest {
    private int memberIdx;
    private int pastLowTemp;
    private int pastHighTemp;

    public int getMemberIdx() {
        return memberIdx;
    }

    public void setMemberIdx(int memberIdx) {
        this.memberIdx = memberIdx;
    }

    public int getPastLowTemp() {
        return pastLowTemp;
    }

    public void setPastLowTemp(int pastLowTemp) {
        this.pastLowTemp = pastLowTemp;
    }

    public int getPastHighTemp() {
        return pastHighTemp;
    }

    public void setPastHighTemp(int pastHighTemp) {
        this.pastHighTemp = pastHighTemp;
    }

    @Override
    public String toString() {
        return "HomeRequset{" +
            "memberIdx=" + memberIdx +
            ", pastLowTemp=" + pastLowTemp +
            ", pastHighTemp=" + pastHighTemp +
            '}';
    }
}
