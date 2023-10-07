package com.kometsales.inventory.service;

import com.kometsales.inventory.dto.*;
import com.kometsales.inventory.entity.*;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class InventoryServiceImplTest {

    @Mock
    private JPAStreamer jpaStreamer;

    @InjectMocks
    private InventoryServiceImpl inventoryService;


    @BeforeEach
    void setUp() {
    }

    @Test
    void getProductsByCompanyId() {
        // given - precondition or setup
        Stream<InventoryEntity> inventoryEntities = Stream.of(
                InventoryEntity.builder()
                        .companyEntity(CompanyEntity.builder().id(1).name("company test").build())
                        .basePrice(1.3)
                        .pack(1)
                        .cubesPerCarrier(15.2)
                        .boxTypeEntity(BoxTypeEntity.builder()
                                .code("test")
                                .width(13.9)
                                .height(15.5)
                                .length(10.8)
                                .build())
                        .productEntity(ProductEntity.builder().name("Product 1").freshCutValue(15.0).build())
                        .build());

        given(jpaStreamer.stream(InventoryEntity.class))
                .willReturn(inventoryEntities);

        // when -  action or the behaviour that we are going test
        ProductCompanyDTO productCompanyDTO = inventoryService.getProductsByCompanyId(1);
        List<ProductCompanyItemDTO> list = productCompanyDTO.getProducts();

        // then - verify the output
        assertThat(productCompanyDTO).isNotNull();
        assertThat(list.size()).isNotZero();
        assertThat(list.get(0).getFinalFreight()).isEqualTo(3.07);
    }

    @Test
    void getProductsByCustomerId() {
        // given - precondition or setup
        Stream<InventoryEntity> inventoryEntities = Stream.of(
                InventoryEntity.builder()
                        .companyEntity(CompanyEntity.builder().id(1).name("company test").build())
                        .basePrice(1.3).build());
        given(jpaStreamer.stream(InventoryEntity.class))
                .willReturn(inventoryEntities);

        Stream<CustomerEntity> customerEntity = Stream.of(
                CustomerEntity.builder().id(1).name("customer 1").markdown(5).build());
        given(jpaStreamer.stream(CustomerEntity.class))
                .willReturn(customerEntity);

        // when -  action or the behaviour that we are going test
        ProductCustomerDTO productCustomerDTO = inventoryService.getProductsByCustomerId(1);
        List<ProductCustomerItemDTO> list = productCustomerDTO.getProducts();

        // then - verify the output
        assertThat(productCustomerDTO).isNotNull();
        assertThat(list.size()).isNotZero();
        assertThat(list.get(0).getPrice()).isEqualTo(1.24);
    }

    @Test
    void getProductCodesByCompanyId() {
        // given - precondition or setup
        Stream<InventoryEntity> inventoryEntities = Stream.of(
                InventoryEntity.builder()
                        .companyEntity(CompanyEntity.builder().id(1).name("company test").build())
                        .productEntity(ProductEntity.builder()
                                .name("Red Roses 23cm").build())
                        .build());
        given(jpaStreamer.stream(InventoryEntity.class))
                .willReturn(inventoryEntities);

        // when -  action or the behaviour that we are going test
        ProductCodeDTO productCodeDTO = inventoryService.getProductCodesByCompanyId(1);
        List<ProductCodeItemDTO> list = productCodeDTO.getProducts();

        // then - verify the output
        assertThat(productCodeDTO).isNotNull();
        assertThat(list.size()).isNotZero();
        assertThat(list.get(0).getProductCode()).isEqualTo("R1d-R3s-22m");
    }
}