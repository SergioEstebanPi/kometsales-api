package com.kometsales.inventory.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCompanyItemDTO {
    private String productName;
    private String basePrice;
    private double finalFreight;
}
