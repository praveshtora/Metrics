package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by palsulea on 11/5/2016.
 */
@Entity
public class ICAP {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int headCount;
    @Column
    private int portofolios;
    @Column
    private int scoreCard;

    public int getHeadCount() {
        return headCount;
    }

    public void setHeadCount(int headCount) {
        this.headCount = headCount;
    }

    public int getPortofolios() {
        return portofolios;
    }

    public void setPortofolios(int portofolios) {
        this.portofolios = portofolios;
    }

    public int getScoreCard() {
        return scoreCard;
    }

    public void setScoreCard(int scoreCard) {
        this.scoreCard = scoreCard;
    }
}
