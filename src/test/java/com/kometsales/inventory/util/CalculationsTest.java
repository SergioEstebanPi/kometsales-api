package com.kometsales.inventory.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CalculationsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getFinalFreight() {

    }

    @Test
    void getPrice() {
    }

    @Test
    void getCode() {

        String[] tests = {"Roses",
                "Red Roses 23cm",
                "IL Hydrangea Blue",
                "Black Gira%sol 17Inch",
                "&White pom 3Inch"};

        for (String test: tests) {
            String result = Calculations.getCode(test);
            System.out.println(result);
        }
    }
}