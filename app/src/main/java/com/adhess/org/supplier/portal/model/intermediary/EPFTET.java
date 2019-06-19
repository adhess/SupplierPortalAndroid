package com.adhess.org.supplier.portal.model.intermediary;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;


public class EPFTET implements Serializable {
    private String docref;
    private String recdat;
    private String echdat;
    private BigInteger devtvamnt;
    private BigInteger devnetmnt;
    private BigInteger devBruMnt;
    private String devcod;
    private BigInteger escprc;
    private String communication;
    private String ndcflg;
    private BigInteger serepftet;
    private BigInteger serecatet;
    private BigInteger sercpttie;
    private String status;
    private List<EPFDET> epfdet;


    @Override
    public String toString() {
        return "EPFTET{" +
                "docref='" + docref + '\'' +
                ", recdat='" + recdat + '\'' +
                ", echdat='" + echdat + '\'' +
                ", devtvamnt=" + devtvamnt +
                ", devnetmnt=" + devnetmnt +
                ", devBruMnt=" + devBruMnt +
                ", devcod='" + devcod + '\'' +
                ", escprc=" + escprc +
                ", communication='" + communication + '\'' +
                ", ndcflg='" + ndcflg + '\'' +
                ", serepftet=" + serepftet +
                ", serecatet=" + serecatet +
                ", sercpttie=" + sercpttie +
                ", status='" + status + '\'' +
                ", epfdet=" + epfdet +
                '}';
    }

    public EPFTET() {
    }

    public String getDocref() {
        return docref;
    }

    public void setDocref(String docref) {
        this.docref = docref;
    }

    public String getRecdat() {
        return recdat;
    }

    public void setRecdat(String recdat) {
        this.recdat = recdat;
    }

    public String getEchdat() {
        return echdat;
    }

    public void setEchdat(String echdat) {
        this.echdat = echdat;
    }

    public BigInteger getDevtvamnt() {
        return devtvamnt;
    }

    public void setDevtvamnt(BigInteger devtvamnt) {
        this.devtvamnt = devtvamnt;
    }

    public BigInteger getDevnetmnt() {
        return devnetmnt;
    }

    public void setDevnetmnt(BigInteger devnetmnt) {
        this.devnetmnt = devnetmnt;
    }

    public BigInteger getDevBruMnt() {
        return devBruMnt;
    }

    public void setDevBruMnt(BigInteger devBruMnt) {
        this.devBruMnt = devBruMnt;
    }

    public String getDevcod() {
        return devcod;
    }

    public void setDevcod(String devcod) {
        this.devcod = devcod;
    }

    public BigInteger getEscprc() {
        return escprc;
    }

    public void setEscprc(BigInteger escprc) {
        this.escprc = escprc;
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

    public String getNdcflg() {
        return ndcflg;
    }

    public void setNdcflg(String ndcflg) {
        this.ndcflg = ndcflg;
    }

    public BigInteger getSerepftet() {
        return serepftet;
    }

    public void setSerepftet(BigInteger serepftet) {
        this.serepftet = serepftet;
    }

    public BigInteger getSerecatet() {
        return serecatet;
    }

    public void setSerecatet(BigInteger serecatet) {
        this.serecatet = serecatet;
    }

    public BigInteger getSercpttie() {
        return sercpttie;
    }

    public void setSercpttie(BigInteger sercpttie) {
        this.sercpttie = sercpttie;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<EPFDET> getEpfdet() {
        return epfdet;
    }

    public void setEpfdet(List<EPFDET> epfdet) {
        this.epfdet = epfdet;
    }
}