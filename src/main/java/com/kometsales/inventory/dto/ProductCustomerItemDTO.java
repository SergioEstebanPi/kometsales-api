package com.kometsales.inventory.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCustomerItemDTO {
    private String productName;
    private String companyName;
    private double price;
}
