package com.ootd.project.domain.clothes;

public class ClothDel {
    private int idx;
    private String clothType;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getClothType() {
        return clothType;
    }

    public void setClothType(String clothType) {
        this.clothType = clothType;
    }

    @Override
    public String toString() {
        return "ClothDel{" +
                "idx=" + idx +
                ", clothType='" + clothType + '\'' +
                '}';
    }
}
