package com.ootd.project.domain.past;

import java.sql.Date;

public class Past {
    private int pastIdx;
    private int memberIdx;
    private int outerIdx;
    private int bottomIdx;
    private int topIdx;
    private int pastLowTemp;
    private int pastHighTemp;
    private String pastFeedback;
    private Date pastDate;

    public int getPastIdx() {
        return pastIdx;
    }

    public void setPastIdx(int pastIdx) {
        this.pastIdx = pastIdx;
    }

    public int getMemberIdx() {
        return memberIdx;
    }

    public void setMemberIdx(int memberIdx) {
        this.memberIdx = memberIdx;
    }

    public int getOuterIdx() {
        return outerIdx;
    }

    public void setOuterIdx(int outerIdx) {
        this.outerIdx = outerIdx;
    }

    public int getBottomIdx() {
        return bottomIdx;
    }

    public void setBottomIdx(int bottomIdx) {
        this.bottomIdx = bottomIdx;
    }

    public int getTopIdx() {
        return topIdx;
    }

    public void setTopIdx(int topIdx) {
        this.topIdx = topIdx;
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

    public String getPastFeedback() {
        return pastFeedback;
    }

    public void setPastFeedback(String pastFeedback) {
        this.pastFeedback = pastFeedback;
    }

    public Date getPastDate() {
        return pastDate;
    }

    public void setPastDate(Date pastDate) {
        this.pastDate = pastDate;
    }

    @Override
    public String toString() {
        return "Past{" +
                "pastIdx=" + pastIdx +
                ", memberIdx=" + memberIdx +
                ", outerIdx=" + outerIdx +
                ", bottomIdx=" + bottomIdx +
                ", topIdx=" + topIdx +
                ", pastLowTemp=" + pastLowTemp +
                ", pastHighTemp=" + pastHighTemp +
                ", pastFeedback='" + pastFeedback + '\'' +
                ", pastDate=" + pastDate +
                '}';
    }
}
