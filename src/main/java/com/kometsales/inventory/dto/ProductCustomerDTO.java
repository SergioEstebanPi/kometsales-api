package com.kometsales.inventory.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductCustomerDTO {
    private List<ProductCustomerItemDTO> productCustomerItemDTOList;
}
