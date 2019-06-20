package com.adhess.org.supplier.portal.model.intermediary;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class EPCTET implements Serializable {
    private String devcod;
    private String credat;
    private String dealivdat;
    private Double devbrumnt;
    private Double devtvamnt;
    private String status;
    private BigInteger epcnum;
    private String explivdat;
    private BigInteger serepctet;
    private BigInteger global_REVERSAL_ID;
    private BigInteger sercpttie;
    private String epmadrlib;
    private String[] partial_REVERSAL_DATE;
    private List<EPCDET> epcdet;

    public String getDevcod() {
        return devcod;
    }

    public void setDevcod(String devcod) {
        this.devcod = devcod;
    }

    public String getCredat() {
        return credat;
    }

    public void setCredat(String credat) {
        this.credat = credat;
    }

    public String getDealivdat() {
        return dealivdat;
    }

    public void setDealivdat(String dealivdat) {
        this.dealivdat = dealivdat;
    }

    public Double getDevbrumnt() {
        return devbrumnt;
    }

    public void setDevbrumnt(Double devbrumnt) {
        this.devbrumnt = devbrumnt;
    }

    public Double getDevtvamnt() {
        return devtvamnt;
    }

    public void setDevtvamnt(Double devtvamnt) {
        this.devtvamnt = devtvamnt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getEpcnum() {
        return epcnum;
    }

    public void setEpcnum(BigInteger epcnum) {
        this.epcnum = epcnum;
    }

    public String getExplivdat() {
        return explivdat;
    }

    public void setExplivdat(String explivdat) {
        this.explivdat = explivdat;
    }

    public BigInteger getSerepctet() {
        return serepctet;
    }

    public void setSerepctet(BigInteger serepctet) {
        this.serepctet = serepctet;
    }

    public BigInteger getGlobal_REVERSAL_ID() {
        return global_REVERSAL_ID;
    }

    public void setGlobal_REVERSAL_ID(BigInteger global_REVERSAL_ID) {
        this.global_REVERSAL_ID = global_REVERSAL_ID;
    }

    public BigInteger getSercpttie() {
        return sercpttie;
    }

    public void setSercpttie(BigInteger sercpttie) {
        this.sercpttie = sercpttie;
    }

    public String getEpmadrlib() {
        return epmadrlib;
    }

    public void setEpmadrlib(String epmadrlib) {
        this.epmadrlib = epmadrlib;
    }

    public String[] getPartial_REVERSAL_DATE() {
        return partial_REVERSAL_DATE;
    }

    public void setPartial_REVERSAL_DATE(String[] partial_REVERSAL_DATE) {
        this.partial_REVERSAL_DATE = partial_REVERSAL_DATE;
    }

    public List<EPCDET> getEpcdet() {
        return epcdet;
    }

    public void setEpcdet(List<EPCDET> epcdet) {
        this.epcdet = epcdet;
    }


    @Override
    public String toString() {
        return "EPCTET{" +
                "devcod='" + devcod + '\'' +
                ", credat='" + credat + '\'' +
                ", dealivdat='" + dealivdat + '\'' +
                ", devbrumnt=" + devbrumnt +
                ", devtvamnt=" + devtvamnt +
                ", status='" + status + '\'' +
                ", epcnum=" + epcnum +
                ", explivdat='" + explivdat + '\'' +
                ", serepctet=" + serepctet +
                ", global_REVERSAL_ID=" + global_REVERSAL_ID +
                ", sercpttie=" + sercpttie +
                ", epmadrlib='" + epmadrlib + '\'' +
                ", partial_REVERSAL_DATE=" + Arrays.toString(partial_REVERSAL_DATE) +
                ", epcdet=" + epcdet +
                '}';
    }
}
