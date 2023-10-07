package com.kometsales.inventory.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCustomerItemDTO {
    private String productName;
    private String companyName;
    private BigDecimal price;
}
