package com.adhess.org.supplier.portal.model;


import android.os.Parcelable;

import com.adhess.org.supplier.portal.model.intermediary.EPFTET;

import java.io.Serializable;

import lombok.Data;


public class P2p_invoice implements Serializable {
    private EPFTET root;

    public EPFTET getRoot() {
        return root;
    }

    public void setRoot(EPFTET root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "P2p_invoice{" +
                "root=" + root.toString() +
                '}';
    }
}

