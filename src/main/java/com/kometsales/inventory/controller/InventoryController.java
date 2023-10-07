package com.kometsales.inventory.controller;

import com.kometsales.inventory.dto.ProductCodeDTO;
import com.kometsales.inventory.dto.ProductCompanyDTO;
import com.kometsales.inventory.dto.ProductCustomerDTO;
import com.kometsales.inventory.service.InventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class InventoryController {

    @Autowired
    private InventoryServiceImpl inventoryServiceImpl;

    @GetMapping("/company/{companyId}")
    public ProductCompanyDTO getProductsByCompanyId(@PathVariable("companyId") Integer companyId){
        System.out.print(companyId);
        return inventoryServiceImpl.getProductsByCompanyId(companyId);
    }

    @GetMapping("/customer/{customerId}")
    public ProductCustomerDTO getProductsByCustomerId(@PathVariable("customerId") Integer customerId){
        System.out.print(customerId);
        return inventoryServiceImpl.getProductsByCustomerId(customerId);
    }

    @GetMapping("/codes/{companyId}")
    public ProductCodeDTO getProductCodesByCompanyId(@PathVariable("companyId") Integer companyId){
        System.out.print(companyId);
        return inventoryServiceImpl.getProductCodesByCompanyId(companyId);
    }
}
