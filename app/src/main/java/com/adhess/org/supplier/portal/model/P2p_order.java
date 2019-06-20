package com.adhess.org.supplier.portal.model;

import com.adhess.org.supplier.portal.model.intermediary.EPCTET;

import java.io.Serializable;


public class P2p_order implements Serializable {
    private EPCTET root = new EPCTET();

    public EPCTET getRoot() {
        return root;
    }

    public void setRoot(EPCTET root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "P2p_order{" +
                "root=" + root.toString() +
                '}';
    }
}
