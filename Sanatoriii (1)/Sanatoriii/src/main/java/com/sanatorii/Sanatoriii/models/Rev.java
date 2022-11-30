package com.sanatorii.Sanatoriii.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rev {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id2;

    private String shortt, full_rev;

    public Long getId2() {
        return id2;
    }

    public void setId2(Long id2) {
        this.id2 = id2;
    }

    public String getShortt() {
        return shortt;
    }

    public void setShortt(String shortt) {
        this.shortt = shortt;
    }

    public String getFull_rev() {
        return full_rev;
    }

    public void setFull_rev(String full_rev) {
        this.full_rev = full_rev;
    }

    public Rev() {
    }

    public Rev(String shortt, String full_rev) {
        this.shortt = shortt;
        this.full_rev = full_rev;
    }
}
