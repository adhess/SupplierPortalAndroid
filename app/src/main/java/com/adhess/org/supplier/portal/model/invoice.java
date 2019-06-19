package com.adhess.org.supplier.portal.model;




public class invoice {
    private int ONGOING;
    private int ACCOUNTED;
    private int REFUSED;
    private int BLOCKED;

    public int getONGOING() {
        return ONGOING;
    }

    public void setONGOING(int ONGOING) {
        this.ONGOING = ONGOING;
    }

    public int getACCOUNTED() {
        return ACCOUNTED;
    }

    public void setACCOUNTED(int ACCOUNTED) {
        this.ACCOUNTED = ACCOUNTED;
    }

    public int getREFUSED() {
        return REFUSED;
    }

    public void setREFUSED(int REFUSED) {
        this.REFUSED = REFUSED;
    }

    public int getBLOCKED() {
        return BLOCKED;
    }

    public void setBLOCKED(int BLOCKED) {
        this.BLOCKED = BLOCKED;
    }

    public invoice(int ONGOING, int ACCOUNTED, int REFUSED, int BLOCKED) {
        this.ONGOING = ONGOING;
        this.ACCOUNTED = ACCOUNTED;
        this.REFUSED = REFUSED;
        this.BLOCKED = BLOCKED;
    }
}
