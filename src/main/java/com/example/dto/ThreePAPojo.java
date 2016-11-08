package com.example.dto;


public class ThreePAPojo {

    private int headcount;
    private int productivity;

    public int getHeadcount() {
        return headcount;
    }

    public void setHeadcount(int headcount) {
        this.headcount = headcount;
    }

    public int getProductivity() {
        return productivity;
    }

    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }

    public ThreePAPojo(int headcount, int productivity) {

        this.headcount = headcount;
        this.productivity = productivity;
    }
}
