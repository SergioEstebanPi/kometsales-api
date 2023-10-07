package com.kometsales.inventory.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductCodeDTO {
    private List<ProductCompanyItemDTO> productCompanyItemDTOList;
}
