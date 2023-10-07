package com.kometsales.inventory.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductCompanyDTO {
    private int companyId;
    private List<ProductCompanyItemDTO> products;
}
