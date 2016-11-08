package com.example.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Attrition {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int retentionRate;
    @Column
    private int attritionRate;


    public int getRetentionRate() {
        return retentionRate;
    }

    public void setRetentionRate(int retentionRate) {
        this.retentionRate = retentionRate;
    }

    public int getAttritionRate() {
        return attritionRate;
    }

    public void setAttritionRate(int attritionRate) {
        this.attritionRate = attritionRate;
    }
}
