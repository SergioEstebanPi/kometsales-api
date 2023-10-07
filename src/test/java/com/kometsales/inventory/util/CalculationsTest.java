package com.kometsales.inventory.util;

import com.kometsales.inventory.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculationsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getFinalFreight() {
        InventoryEntity inventoryEntity = InventoryEntity.builder()
                .productEntity(ProductEntity.builder().freshCutValue(10.2).name("test").build())
                .companyEntity(CompanyEntity.builder().id(1).build())
                .basePrice(1.3)
                .boxTypeEntity(BoxTypeEntity.builder()
                        .width(10.5)
                        .height(12.5)
                        .length(15.3)
                        .build())
                .cubesPerCarrier(12.5)
                .pack(1)
                .build();

        double result = Calculations.getFinalFreight(inventoryEntity);
        assertThat(result).isEqualTo(1.48);
    }

    @Test
    void getFinalFreightError() {
        InventoryEntity inventoryEntity = InventoryEntity.builder()
                .productEntity(ProductEntity.builder().freshCutValue(10.2).name("test").build())
                .companyEntity(CompanyEntity.builder().id(1).build())
                .basePrice(1.3)
                .boxTypeEntity(BoxTypeEntity.builder()
                        .width(10.5)
                        .height(12.5)
                        .length(15.3)
                        .build())
                .cubesPerCarrier(12.5)
                .pack(0)
                .build();

        Exception exception = assertThrows(NumberFormatException.class,
                () -> Calculations.getFinalFreight(inventoryEntity));

        String expectedMessage = "Division por cero no admitida";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void getPrice() {
        InventoryEntity inventoryEntity = InventoryEntity.builder()
                .productEntity(ProductEntity.builder()
                        .name("test")
                        .build())
                .basePrice(1.3)
                .build();
        CustomerEntity customerEntity = CustomerEntity.builder()
                .id(1)
                .markdown(5)
                .build();

        double result = Calculations.getPrice(inventoryEntity, customerEntity);
        assertThat(result).isEqualTo(1.24);
    }

    @Test
    void getCode() {
        Map<String, String> tests = new HashMap<>();
        tests.put("Roses", "R3s");
        tests.put("Red Roses 23cm", "R1d-R3s-22m");
        tests.put("IL Hydrangea Blue", "I0L-H7a-B2e");
        tests.put("Black Gira%sol 17Inch", "B3k-G6%l-14h");
        tests.put("&White pom 3Inch", "&4e-p1m-33h");

        for (Map.Entry<String, String> test: tests.entrySet()) {
            String result = Calculations.getCode(test.getKey());
            assertThat(result).isEqualTo(test.getValue());
        }
    }
}