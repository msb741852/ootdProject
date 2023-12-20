package com.ootd.project.domain.past;

public class PastUpdateItem {
    private int pastIdx;
    private int topIdx;
    private int bottomIdx;
    private int outerIdx;
    private String pastFeedback;

    public int getPastIdx() {
        return pastIdx;
    }

    public void setPastIdx(int pastIdx) {
        this.pastIdx = pastIdx;
    }

    public int getTopIdx() {
        return topIdx;
    }

    public void setTopIdx(int topIdx) {
        this.topIdx = topIdx;
    }

    public int getBottomIdx() {
        return bottomIdx;
    }

    public void setBottomIdx(int bottomIdx) {
        this.bottomIdx = bottomIdx;
    }

    public int getOuterIdx() {
        return outerIdx;
    }

    public void setOuterIdx(int outerIdx) {
        this.outerIdx = outerIdx;
    }

    public String getPastFeedback() {
        return pastFeedback;
    }

    public void setPastFeedback(String pastFeedback) {
        this.pastFeedback = pastFeedback;
    }

    @Override
    public String toString() {
        return "PastUpdateItem{" +
                "pastIdx=" + pastIdx +
                ", topIdx=" + topIdx +
                ", bottomIdx=" + bottomIdx +
                ", outerIdx=" + outerIdx +
                ", pastFeedback='" + pastFeedback + '\'' +
                '}';
    }
}
