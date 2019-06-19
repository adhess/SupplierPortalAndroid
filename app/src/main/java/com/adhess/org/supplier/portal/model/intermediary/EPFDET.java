package com.adhess.org.supplier.portal.model.intermediary;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

public class EPFDET implements Serializable {
    private BigInteger serepftet;
    private String mvtlib;
    private BigInteger facqte;
    private BigInteger devtvaliq;
    private BigInteger devbruliq;
    private BigInteger lignum;
    private BigInteger uniprx1;
    private BigInteger uniprx;


    public BigInteger getSerepftet() {
        return serepftet;
    }

    public void setSerepftet(BigInteger serepftet) {
        this.serepftet = serepftet;
    }

    public String getMvtlib() {
        return mvtlib;
    }

    public void setMvtlib(String mvtlib) {
        this.mvtlib = mvtlib;
    }

    public BigInteger getFacqte() {
        return facqte;
    }

    public void setFacqte(BigInteger facqte) {
        this.facqte = facqte;
    }

    public BigInteger getDevtvaliq() {
        return devtvaliq;
    }

    public void setDevtvaliq(BigInteger devtvaliq) {
        this.devtvaliq = devtvaliq;
    }

    public BigInteger getDevbruliq() {
        return devbruliq;
    }

    public void setDevbruliq(BigInteger devbruliq) {
        this.devbruliq = devbruliq;
    }

    public BigInteger getLignum() {
        return lignum;
    }

    public void setLignum(BigInteger lignum) {
        this.lignum = lignum;
    }

    public BigInteger getUniprx1() {
        return uniprx1;
    }

    public void setUniprx1(BigInteger uniprx1) {
        this.uniprx1 = uniprx1;
    }

    public BigInteger getUniprx() {
        return uniprx;
    }

    public void setUniprx(BigInteger uniprx) {
        this.uniprx = uniprx;
    }

    @Override
    public String toString() {
        return "EPFDET{" +
                "serepftet=" + serepftet +
                ", mvtlib='" + mvtlib + '\'' +
                ", facqte=" + facqte +
                ", devtvaliq=" + devtvaliq +
                ", devbruliq=" + devbruliq +
                ", lignum=" + lignum +
                ", uniprx1=" + uniprx1 +
                ", uniprx=" + uniprx +
                '}';
    }
}
