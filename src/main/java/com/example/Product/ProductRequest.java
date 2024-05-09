package com.example.Product;

import lombok.Data;

public class ProductRequest {
    @Data
    public class SaveDTO {
        private String productName;
        private Integer productPrice;
        private Integer productQty;

    }
}
