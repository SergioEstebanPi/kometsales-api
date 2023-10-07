package com.kometsales.inventory.util;

import com.kometsales.inventory.entity.CustomerEntity;
import com.kometsales.inventory.entity.InventoryEntity;

public class Calculations {

    public static double getFinalFreight(InventoryEntity inventoryEntity){
        double width = inventoryEntity.getBoxTypeEntity().getWidth();
        double height = inventoryEntity.getBoxTypeEntity().getHeight();
        double length = inventoryEntity.getBoxTypeEntity().getLength();

        double cubesPerCarrier = inventoryEntity.getCubesPerCarrier();
        int pack = inventoryEntity.getPack();
        double freshCutValue = inventoryEntity.getProductEntity().getFreshCutValue();

        double cubesPerBox = (width * height * length) / 1728;
        double outboundFreight = (cubesPerCarrier * cubesPerBox) / pack;
        double finalFreight = outboundFreight * (freshCutValue / 100);
        return finalFreight;
    }

    public static double getPrice(InventoryEntity inventoryEntity, CustomerEntity customerEntity){
        double basePrice = inventoryEntity.getBasePrice();
        double markdown = customerEntity.getMarkdown();
        double price = basePrice - (basePrice * (markdown / 100));
        return price;
    }
}
