package com.adhess.org.supplier.portal.model;


public class InfoChart {

    private order order;
    private invoice invoice;

    public com.adhess.org.supplier.portal.model.order getOrder() {
        return order;
    }

    public void setOrder(com.adhess.org.supplier.portal.model.order order) {
        this.order = order;
    }

    public com.adhess.org.supplier.portal.model.invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(com.adhess.org.supplier.portal.model.invoice invoice) {
        this.invoice = invoice;
    }

    public InfoChart(com.adhess.org.supplier.portal.model.order order, com.adhess.org.supplier.portal.model.invoice invoice) {
        this.order = order;
        this.invoice = invoice;
    }
}


