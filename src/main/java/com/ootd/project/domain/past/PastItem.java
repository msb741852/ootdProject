package com.ootd.project.domain.past;

import java.sql.Date;

public class PastItem {
    private int pastIdx;
    private int pastLowTemp;
    private int pastHighTemp;
    private String cloth_top;
    private String cloth_bottom;
    private String cloth_outer;
    private String pastFeedback;
    private Date pastDate;

    public int getPastIdx() {
        return pastIdx;
    }

    public void setPastIdx(int pastIdx) {
        this.pastIdx = pastIdx;
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

    public String getCloth_top() {
        return cloth_top;
    }

    public void setCloth_top(String cloth_top) {
        this.cloth_top = cloth_top;
    }

    public String getCloth_bottom() {
        return cloth_bottom;
    }

    public void setCloth_bottom(String cloth_bottom) {
        this.cloth_bottom = cloth_bottom;
    }

    public String getCloth_outer() {
        return cloth_outer;
    }

    public void setCloth_outer(String cloth_outer) {
        this.cloth_outer = cloth_outer;
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
        return "PastItem{" +
                "pastIdx=" + pastIdx +
                ", pastLowTemp=" + pastLowTemp +
                ", pastHighTemp=" + pastHighTemp +
                ", cloth_top='" + cloth_top + '\'' +
                ", cloth_bottom='" + cloth_bottom + '\'' +
                ", cloth_outer='" + cloth_outer + '\'' +
                ", pastFeedback='" + pastFeedback + '\'' +
                ", pastDate=" + pastDate +
                '}';
    }
}
