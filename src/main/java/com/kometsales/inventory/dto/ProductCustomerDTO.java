package com.kometsales.inventory.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductCustomerDTO {
    private List<ProductCustomerItemDTO> productCustomerItemDTOList;
}
