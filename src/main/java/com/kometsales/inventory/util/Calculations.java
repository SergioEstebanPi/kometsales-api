package com.kometsales.inventory.util;

import com.kometsales.inventory.entity.CustomerEntity;
import com.kometsales.inventory.entity.InventoryEntity;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculations {

    public static final String DECIMAL_PATTERN = "#.##";
    public static DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_PATTERN);

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
        return Double.parseDouble(decimalFormat.format(finalFreight));
    }

    public static double getPrice(InventoryEntity inventoryEntity, CustomerEntity customerEntity){
        double basePrice = inventoryEntity.getBasePrice();
        double markdown = customerEntity.getMarkdown();
        double price = basePrice - (basePrice * (markdown / 100));
        return Double.parseDouble(decimalFormat.format(price));
    }

    public static String getCode(String productName){
        String productCode = "";
        String space = " ";
        String[] words = productName.split(space);
        productCode = Arrays.stream(words)
                    .map(w -> getWordCode(w) + space)
                    .collect(Collectors.joining());
        return productCode.replace(space, "-")
                .substring(0, productCode.length() - 1);
    }

    private static String getWordCode(String word){
        String wordCode = "";
        wordCode += word.substring(0, 1);
        int length = word.length();
        String inner = word.substring(1, length - 1);
        switch (length) {
            case 2:
                wordCode += '0';
                break;
            case 3:
                wordCode += '1';
                break;
            default:
                wordCode += inner.chars()
                        .mapToObj(c -> (char) c)
                        .distinct()
                        .count();
                break;
        }
        Pattern regex = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = regex.matcher(inner);
        while(m.find()) {
            wordCode += word.charAt(m.start());
        }
        wordCode += word.substring(length - 1, length);
        return wordCode;
    }
}
