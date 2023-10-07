KometSales API
==========================

#What is it?

The purpose of this API is to managed the inventory for KometSales using three endpoints:
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


## Table showing the finalFreight results

<img width="279" alt="image" src="https://github.com/SergioEstebanPi/kometsales-api/assets/17394456/c1184747-efca-4720-abfb-aaf0680abec0">


The backend is done with 
- Spring Boot 0.5.0.M5
- Spring 4.0.0.M3
- Hibernate 4.2.1 
- Spring MVC, Spring Data JPA, Spring security and so on.

There is embedded tomcat and embedded, in-memory hsql inside.

There is a standard set of libs, like guava, joda-time and so on.

Backend is done with Java 7 and Groovy (you can safely mix both as long as you keep your sources in src/main/groovy folder), without any xml. Tests are written in groovy using Spock framework and one with Spring MVC (had to test if my view resolver is working, and that's only possible with spring Dispatcher/Front Controller).

Frontend is using old version of AngularJS, but it's just so you can fire it up and see it works. I used the
templating from scotch.io <http://scotch.io> but changed it out a bit. 

A nice tutorial is here: http://scotch.io/tutorials/javascript/single-page-apps-with-angularjs-routing-and-templating
