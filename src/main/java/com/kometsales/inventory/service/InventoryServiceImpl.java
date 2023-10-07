package com.kometsales.inventory.service;

import com.kometsales.inventory.dto.*;
import com.kometsales.inventory.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public ProductCompanyDTO getProductsByCompanyId(int companyId){
        ProductCompanyDTO productCompanyDTO = new ProductCompanyDTO();
        productCompanyDTO.setCompanyId(companyId);

        List<ProductCompanyItemDTO> productCompanyItemDTOList = inventoryRepository.findAll()
                .stream()
                .filter(inventoryEntity -> inventoryEntity.getCompanyEntity().getId() == companyId)
                .map(inventoryEntity -> {
                    String name = inventoryEntity.getProductEntity().getName();
                    double finalFreight = 0.0;
                    String basePrice = "";
                    ProductCompanyItemDTO productCompanyItemDTO = new ProductCompanyItemDTO();
                    productCompanyItemDTO.setProductName(name);
                    productCompanyItemDTO.setBasePrice(basePrice);
                    productCompanyItemDTO.setFinalFreight(finalFreight);
                    return productCompanyItemDTO;
                })
                .toList();
        productCompanyDTO.setProductCompanyItemDTOList(productCompanyItemDTOList);
        return productCompanyDTO;
    }

    public ProductCustomerDTO getProductsByCustomerId(int customerId){
        ProductCustomerDTO productCustomerDTO = new ProductCustomerDTO();
        return productCustomerDTO;
    }

    public ProductCodeDTO getProductCodesByCompanyId(int companyId){
        ProductCodeDTO productCodeDTO = new ProductCodeDTO();
        return productCodeDTO;
    }

}
