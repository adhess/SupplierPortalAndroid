package com.adhess.org.supplier.portal.model;

import lombok.Data;
import lombok.NoArgsConstructor;


public class P2p_supplier {
    private Root root;

    @Data @NoArgsConstructor
    public class Root {
        private Long SERCPTTIE;
        private Long SERSUP;
        private String SUPCOD;
        private String CREDAT;
        private String UPDDAT;
        private String SUPADR;
        private String SUPNOM;
        private String SUPTYP;
    }
}

