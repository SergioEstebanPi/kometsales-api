package com.kometsales.inventory.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCompanyItemDTO {
    private String productName;
    private String basePrice;
    private BigDecimal finalFreight;
}
