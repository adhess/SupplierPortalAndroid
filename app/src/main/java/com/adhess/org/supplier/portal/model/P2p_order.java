package com.adhess.org.supplier.portal.model;

import com.adhess.org.supplier.portal.model.intermediary.EPCTET;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class P2p_order {
    private EPCTET root = new EPCTET();
}
