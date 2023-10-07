package com.kometsales.inventory.dto;

import lombok.Data;

@Data
public class ProductCompanyItemDTO {
    private String productName;
    private String basePrice;
    private double finalFreight;
}
