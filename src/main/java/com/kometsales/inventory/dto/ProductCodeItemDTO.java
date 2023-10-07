package com.kometsales.inventory.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCodeItemDTO {
    private String productName;
    private String productCode;
}
