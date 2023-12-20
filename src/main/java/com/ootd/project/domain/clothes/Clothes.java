package com.ootd.project.domain.clothes;

public class Clothes {
    private int idx;
    private int memberIdx;
    private String clothName;
    private String clothType;

    public Clothes() {
    }

    public Clothes(String clothType) {
        this.clothType = clothType;
    }

    public Clothes(int memberIdx, String clothName) {
        this.memberIdx = memberIdx;
        this.clothName = clothName;
    }

    public Clothes(int memberIdx, String clothName, String clothType) {
        this.memberIdx = memberIdx;
        this.clothName = clothName;
        this.clothType = clothType;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getMemberIdx() {
        return memberIdx;
    }

    public void setMemberIdx(int memberIdx) {
        this.memberIdx = memberIdx;
    }

    public String getClothName() {
        return clothName;
    }

    public void setClothName(String clothName) {
        this.clothName = clothName;
    }

    public String getClothType() {
        return clothType;
    }

    public void setClothType(String clothType) {
        this.clothType = clothType;
    }

    @Override
    public String toString() {
        return "clothes{" +
                "idx=" + idx +
                ", memberIdx=" + memberIdx +
                ", clothName='" + clothName + '\'' +
                ", clothType='" + clothType + '\'' +
                '}';
    }
}
