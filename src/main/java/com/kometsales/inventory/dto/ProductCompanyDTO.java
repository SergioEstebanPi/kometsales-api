package com.kometsales.inventory.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductCompanyDTO {
    private int companyId;
    private List<ProductCompanyItemDTO> productCompanyItemDTOList;
}
