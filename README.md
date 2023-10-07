KometSales API
==========================

# What is it?

The purpose of this API is to managed the inventory store in `MySQL Database` for KometSales using three endpoints:
the first one calculates the `finalFreigth` value based on a company ID,
the second one calculates the `price` value using the customer ID as input,
and the third one generates a `productCode` using the productName field of the products available in the inventory
for a given parameter company ID as input.

# How to run it?

If you have gradle installed and under linux/mac:

    gradle runJar

If gradle is not installed, but still under linux/mac

    gradlew runJar

And for windows without gradle

    gradlew.bat runJar

After the server is running, go to

```
http://localhost:8080/products/company/1
http://localhost:8080/products/company/2
http://localhost:8080/products/company/3


http://localhost:8080/products/customer/1
http://localhost:8080/products/customer/2
http://localhost:8080/products/customer/3

http://localhost:8080/products/codes/1
http://localhost:8080/products/codes/2
http://localhost:8080/products/codes/3

user: NA
password: NA
```

## Responses

<img width="456" alt="image" src="https://github.com/SergioEstebanPi/kometsales-api/assets/17394456/873c9bc0-aadb-4602-bd48-18d8568990bd">

<img width="456" alt="image" src="https://github.com/SergioEstebanPi/kometsales-api/assets/17394456/3b812fb0-e472-46ac-ad50-bb99cf357198">

<img width="456" alt="image" src="https://github.com/SergioEstebanPi/kometsales-api/assets/17394456/58cda0bf-8a92-4872-94d7-4912297757ab">


## Model Entidad Relación

![kometsales_ERdiagram](https://github.com/SergioEstebanPi/kometsales-api/assets/17394456/45df37ac-2aaf-453a-8ea8-f5dcb4898c9c)


## Table showing the finalFreight results

<img width="279" alt="image" src="https://github.com/SergioEstebanPi/kometsales-api/assets/17394456/c1184747-efca-4720-abfb-aaf0680abec0">


The backend is done with 
- Spring Boot 0.5.0.M5
- Spring 4.0.0.M3
- Hibernate 4.2.1 
- Spring MVC, Spring Data JPA, Spring security and so on.

There is embedded tomcat and embedded, in-memory hsql inside.
