package com.kometsales.inventory.service;

import com.kometsales.inventory.dto.*;
import com.kometsales.inventory.entity.CustomerEntity;
import com.kometsales.inventory.entity.InventoryEntity;
import com.kometsales.inventory.repository.*;
import com.kometsales.inventory.util.Calculations;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private BoxTypeRepository boxTypeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private JPAStreamer jpaStreamer;

    public ProductCompanyDTO getProductsByCompanyId(int companyId){
        ProductCompanyDTO productCompanyDTO = ProductCompanyDTO.builder().build();
        productCompanyDTO.setCompanyId(companyId);

        List<ProductCompanyItemDTO> productCompanyItemDTOList = jpaStreamer.stream(InventoryEntity.class)
                .filter(inventoryEntity -> inventoryEntity.getCompanyEntity().getId() == companyId)
                .map(inventoryEntity -> ProductCompanyItemDTO.builder()
                        .productName(inventoryEntity.getProductEntity().getName())
                        .basePrice(String.valueOf(inventoryEntity.getBasePrice()))
                        .finalFreight(Calculations.getFinalFreight(inventoryEntity))
                        .build())
                .toList();
        productCompanyDTO.setProductCompanyItemDTOList(productCompanyItemDTOList);
        return productCompanyDTO;
    }

    public ProductCustomerDTO getProductsByCustomerId(int customerId){
        ProductCustomerDTO productCustomerDTO = ProductCustomerDTO.builder().build();

        List<ProductCustomerItemDTO> products = new ArrayList<>();
        products = jpaStreamer.stream(InventoryEntity.class)
                .map(inventoryEntity -> ProductCustomerItemDTO.builder()
                        .productName(inventoryEntity.getProductEntity().getName())
                        .companyName(inventoryEntity.getCompanyEntity().getName())
                        .price(Calculations.getPrice(inventoryEntity,
                                jpaStreamer.stream(CustomerEntity.class)
                                .filter(customerEntity -> customerEntity.getId() == customerId)
                                .findFirst().get()))
                        .build())
                .toList();
        productCustomerDTO.setProductCustomerItemDTOList(products);
        return productCustomerDTO;
    }

    public ProductCodeDTO getProductCodesByCompanyId(int companyId){
        ProductCodeDTO productCodeDTO = ProductCodeDTO.builder().build();

        List<ProductCodeItemDTO> products = new ArrayList<>();
        jpaStreamer.stream(InventoryEntity.class)
                .map(inventoryEntity -> ProductCodeItemDTO.builder()
                        .productName(inventoryEntity.getProductEntity().getName())
                        .productCode(Calculations.getCode(inventoryEntity.getProductEntity().getName()))
                        .build())
                .toList();

        productCodeDTO.setProductCodeItemDTOList(products);
        return productCodeDTO;
    }

}
