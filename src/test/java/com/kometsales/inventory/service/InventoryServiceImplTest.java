package com.kometsales.inventory.service;

import com.kometsales.inventory.dto.ProductCodeDTO;
import com.kometsales.inventory.dto.ProductCompanyDTO;
import com.kometsales.inventory.dto.ProductCompanyItemDTO;
import com.kometsales.inventory.dto.ProductCustomerDTO;
import com.kometsales.inventory.entity.InventoryEntity;
import com.kometsales.inventory.repository.*;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class InventoryServiceImplTest {

    @Mock
    private InventoryRepository inventoryRepository;

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
        List<InventoryEntity> inventoryEntities = new ArrayList<>();
        List<ProductCompanyItemDTO> productCompanyItemDTOList = new ArrayList<>();
        //given(jpaStreamer.stream(InventoryEntity.class)).willReturn(productCompanyItemDTOList);
        //given(inventoryRepository.findByCompanyId(1))
        //        .willReturn(inventoryEntities);

        System.out.println(inventoryRepository);
        System.out.println(inventoryService);

        // when -  action or the behaviour that we are going test
        ProductCompanyDTO productCompanyDTO = inventoryService.getProductsByCompanyId(1);

        List<ProductCompanyItemDTO> list = productCompanyDTO.getProductCompanyItemDTOList();

        System.out.println(productCompanyDTO);
        // then - verify the output
        assertThat(productCompanyDTO).isNotNull();
        assertThat(list.size()).isNotZero();
        assertThat(list.get(0).getFinalFreight()).isEqualTo(3.0701625000000003);
        assertThat(list.get(1).getFinalFreight()).isEqualTo(1.8783299999999998);
        assertThat(list.get(2).getFinalFreight()).isEqualTo(9.079706250000001);
        assertThat(list.get(4).getFinalFreight()).isEqualTo(19.126863);
    }

    @Test
    void getProductsByCustomerId() {
        // given - precondition or setup
        List<InventoryEntity> inventoryEntities = new ArrayList<>();
        //given(inventoryRepository.findByCustomerId(1))
        //        .willReturn(inventoryEntities);

        System.out.println(inventoryRepository);
        System.out.println(inventoryService);

        // when -  action or the behaviour that we are going test
        ProductCustomerDTO productCustomerDTO = inventoryService.getProductsByCustomerId(1);

        System.out.println(productCustomerDTO);
        // then - verify the output
        assertThat(productCustomerDTO).isNotNull();
    }

    @Test
    void getProductCodesByCompanyId() {
        // given - precondition or setup
        List<InventoryEntity> inventoryEntities = new ArrayList<>();
        //given(inventoryRepository.findByCompanyId(1))
        //        .willReturn(inventoryEntities);

        System.out.println(inventoryRepository);
        System.out.println(inventoryService);

        // when -  action or the behaviour that we are going test
        ProductCodeDTO productCodeDTO = inventoryService.getProductCodesByCompanyId(1);

        System.out.println(productCodeDTO);
        // then - verify the output
        assertThat(productCodeDTO).isNotNull();
    }
}