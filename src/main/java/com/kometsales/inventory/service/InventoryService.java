package com.kometsales.inventory.service;

import com.kometsales.inventory.dto.ProductCodeDTO;
import com.kometsales.inventory.dto.ProductCompanyDTO;
import com.kometsales.inventory.dto.ProductCustomerDTO;

public interface InventoryService {

    ProductCompanyDTO getProductsByCompanyId(int companyId);

    ProductCustomerDTO getProductsByCustomerId(int customerId);

    ProductCodeDTO getProductCodesByCompanyId(int CompanyId);
}
