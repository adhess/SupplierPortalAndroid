package com.adhess.org.supplier.portal.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

import lombok.Data;


public class Content<T> implements Serializable {

    List<T> content;

    protected Content() {
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.valueOf(content);
    }
}
