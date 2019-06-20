package com.adhess.org.supplier.portal.model.intermediary;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;


public class EPCDET implements Serializable {
        private BigInteger sercoa;
        private String artlib;
        private BigInteger cmdqte;
        private BigInteger devbrumnt;
        private BigInteger devtvamnt;
        private BigInteger lignum;
        private String conlib1;
        private String conlib2;
        private String conlib3;
        private String conlib4;
        private BigInteger serepctet;

        public BigInteger getSercoa() {
                return sercoa;
        }

        public void setSercoa(BigInteger sercoa) {
                this.sercoa = sercoa;
        }

        public String getArtlib() {
                return artlib;
        }

        public void setArtlib(String artlib) {
                this.artlib = artlib;
        }

        public BigInteger getCmdqte() {
                return cmdqte;
        }

        public void setCmdqte(BigInteger cmdqte) {
                this.cmdqte = cmdqte;
        }

        public BigInteger getDevbrumnt() {
                return devbrumnt;
        }

        public void setDevbrumnt(BigInteger devbrumnt) {
                this.devbrumnt = devbrumnt;
        }

        public BigInteger getDevtvamnt() {
                return devtvamnt;
        }

        public void setDevtvamnt(BigInteger devtvamnt) {
                this.devtvamnt = devtvamnt;
        }

        public BigInteger getLignum() {
                return lignum;
        }

        public void setLignum(BigInteger lignum) {
                this.lignum = lignum;
        }

        public String getConlib1() {
                return conlib1;
        }

        public void setConlib1(String conlib1) {
                this.conlib1 = conlib1;
        }

        public String getConlib2() {
                return conlib2;
        }

        public void setConlib2(String conlib2) {
                this.conlib2 = conlib2;
        }

        public String getConlib3() {
                return conlib3;
        }

        public void setConlib3(String conlib3) {
                this.conlib3 = conlib3;
        }

        public String getConlib4() {
                return conlib4;
        }

        public void setConlib4(String conlib4) {
                this.conlib4 = conlib4;
        }

        public BigInteger getSerepctet() {
                return serepctet;
        }

        public void setSerepctet(BigInteger serepctet) {
                this.serepctet = serepctet;
        }


        @Override
        public String toString() {
                return "EPCDET{" +
                        "sercoa=" + sercoa +
                        ", artlib='" + artlib + '\'' +
                        ", cmdqte=" + cmdqte +
                        ", devbrumnt=" + devbrumnt +
                        ", devtvamnt=" + devtvamnt +
                        ", lignum=" + lignum +
                        ", conlib1='" + conlib1 + '\'' +
                        ", conlib2='" + conlib2 + '\'' +
                        ", conlib3='" + conlib3 + '\'' +
                        ", conlib4='" + conlib4 + '\'' +
                        ", serepctet=" + serepctet +
                        '}';
        }
}
