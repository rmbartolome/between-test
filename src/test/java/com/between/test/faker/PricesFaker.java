package com.between.test.faker;

import com.between.test.adapter.controller.model.PricesResponse;
import com.between.test.adapter.controller.model.ResponseRest;
import com.between.test.domain.PriceQueryByDate;
import com.between.test.domain.ValidRate;

import java.util.HashMap;

public class PricesFaker {

    /*
     Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)

-        Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)

-        Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)

-        Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)

-        Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)


     */
    public static ValidRate fakeValidRate1(){
        return ValidRate.builder()
                .productId(35455)
                .brandId(1)
                .dateApplication("2020-06-14 10:00:00.000")
                .build();
    }

    public static ValidRate fakeValidRate2(){
        return ValidRate.builder()
                .productId(35455)
                .brandId(1)
                .dateApplication("2020-06-14 16:00:00.000")
                .build();
    }

    public static ValidRate fakeValidRate3(){
        return ValidRate.builder()
                .productId(35455)
                .brandId(1)
                .dateApplication("2020-06-21 00:00:00.000")
                .build();
    }

    public static ValidRate fakeValidRate4(){
        return ValidRate.builder()
                .productId(35455)
                .brandId(1)
                .dateApplication("2020-06-15 10:00:00.000")
                .build();
    }

    public static ValidRate fakeValidRate5(){
        return ValidRate.builder()
                .productId(35455)
                .brandId(1)
                .dateApplication("2020-06-16 21:00:00.000")
                .build();
    }

    public static PriceQueryByDate fakePriceResponse() {
        return PriceQueryByDate.builder()
                .brand(1)
                .dateStartApplication("2020-06-14 00:00:00.000")
                .dateEndApplication("2020-06-14 00:00:00.000")
                .id(1)
                .price(50.00)
                .productId(35455)
                .build();
    }

    public static ResponseRest<PricesResponse> fakePriceTransaction() {
        return ResponseRest
                .<PricesResponse>builder()
                .data(PricesResponse.of(fakePriceResponse()))
                .id("")
                .status(200)
                .resource("/api/v1.0/between/prices")
                .metadata(new HashMap<>())
                .build();
    }
}
