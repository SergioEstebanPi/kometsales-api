package com.kometsales.inventory.service;

import com.kometsales.inventory.dto.ProductCodeDTO;
import com.kometsales.inventory.dto.ProductCompanyDTO;
import com.kometsales.inventory.dto.ProductCustomerDTO;
import com.kometsales.inventory.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public ProductCompanyDTO getProductsByCompanyId(int id){
        ProductCompanyDTO productCompanyDTO = new ProductCompanyDTO();
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
