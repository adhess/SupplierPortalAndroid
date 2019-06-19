package com.adhess.org.supplier.portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;

public class order {
    private int TRANSMITTED;
    private int CLOSED;


    public int getTRANSMITTED() {
        return TRANSMITTED;
    }

    public void setTRANSMITTED(int TRANSMITTED) {
        this.TRANSMITTED = TRANSMITTED;
    }

    public int getCLOSED() {
        return CLOSED;
    }

    public void setCLOSED(int CLOSED) {
        this.CLOSED = CLOSED;
    }

    public order(int TRANSMITTED, int CLOSED) {
        this.TRANSMITTED = TRANSMITTED;
        this.CLOSED = CLOSED;
    }
}
