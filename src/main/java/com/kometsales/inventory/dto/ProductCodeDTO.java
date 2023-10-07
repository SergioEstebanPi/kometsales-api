package com.kometsales.inventory.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductCodeDTO {
    private List<ProductCodeItemDTO> productCodeItemDTOList;
}
