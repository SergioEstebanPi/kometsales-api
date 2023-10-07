package com.kometsales.inventory.service;

import com.kometsales.inventory.dto.*;
import com.kometsales.inventory.entity.CustomerEntity;
import com.kometsales.inventory.entity.InventoryEntity;
import com.kometsales.inventory.util.Calculations;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private JPAStreamer jpaStreamer;

    public ProductCompanyDTO getProductsByCompanyId(int companyId){
        List<ProductCompanyItemDTO> productCompanyItemDTOList = jpaStreamer.stream(InventoryEntity.class)
                .filter(inventoryEntity -> inventoryEntity.getCompanyEntity().getId() == companyId)
                .map(inventoryEntity -> ProductCompanyItemDTO.builder()
                        .productName(inventoryEntity.getProductEntity().getName())
                        .basePrice(String.valueOf(inventoryEntity.getBasePrice()))
                        .finalFreight(Calculations.getFinalFreight(inventoryEntity))
                        .build())
                .toList();
        return ProductCompanyDTO.builder()
                .companyId(companyId)
                .products(productCompanyItemDTOList)
                .build();
    }

    public ProductCustomerDTO getProductsByCustomerId(int customerId){
        List<ProductCustomerItemDTO> products = jpaStreamer.stream(InventoryEntity.class)
                .map(inventoryEntity -> ProductCustomerItemDTO.builder()
                        .productName(inventoryEntity.getProductEntity().getName())
                        .companyName(inventoryEntity.getCompanyEntity().getName())
                        .price(Calculations.getPrice(inventoryEntity,
                                jpaStreamer.stream(CustomerEntity.class)
                                .filter(customerEntity -> customerEntity.getId() == customerId)
                                .findFirst().get()))
                        .build())
                .toList();
        return ProductCustomerDTO.builder()
                .products(products)
                .build();
    }

    public ProductCodeDTO getProductCodesByCompanyId(int companyId){
        List<ProductCodeItemDTO> products = jpaStreamer.stream(InventoryEntity.class)
                .filter(inventoryEntity -> inventoryEntity.getCompanyEntity().getId() == companyId)
                .map(inventoryEntity -> ProductCodeItemDTO.builder()
                        .productName(inventoryEntity.getProductEntity().getName())
                        .productCode(Calculations.getCode(inventoryEntity.getProductEntity().getName()))
                        .build())
                .toList();
        return ProductCodeDTO.builder()
                .products(products)
                .build();
    }

}
