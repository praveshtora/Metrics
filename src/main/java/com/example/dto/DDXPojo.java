package com.example.dto;

/**
 * Created by torap on 07/11/16.
 */
public class DDXPojo {
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

    public DDXPojo(int headcount, int productivity) {

        this.headcount = headcount;
        this.productivity = productivity;
    }
}
