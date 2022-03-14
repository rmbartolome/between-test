package com.between.test.faker;

import com.between.test.adapter.controller.model.PricesResponse;
import com.between.test.adapter.controller.model.ResponseRest;
import com.between.test.domain.PriceQueryByDate;
import com.between.test.domain.ValidRate;

import java.util.HashMap;

public class PricesFaker {

    public static ValidRate fakeValidRate1(){
        return ValidRate.builder()
                .productId(35455)
                .brandId(1)
                .dateApplication("2020-06-14T10:00")
                .build();
    }

    public static ValidRate fakeValidRate2(){
        return ValidRate.builder()
                .productId(35455)
                .brandId(1)
                .dateApplication("2020-06-14T16:00")
                .build();
    }

    public static ValidRate fakeValidRate3(){
        return ValidRate.builder()
                .productId(35455)
                .brandId(1)
                .dateApplication("2020-06-14T21:00")
                .build();
    }

    public static ValidRate fakeValidRate4(){
        return ValidRate.builder()
                .productId(35455)
                .brandId(1)
                .dateApplication("2020-06-15T10:00")
                .build();
    }

    public static ValidRate fakeValidRate5(){
        return ValidRate.builder()
                .productId(35455)
                .brandId(1)
                .dateApplication("2020-06-16T21:00")
                .build();
    }

    public static ValidRate fakeValidRate6(){
        return ValidRate.builder()
                .productId(35455)
                .brandId(2)
                .dateApplication("2020-06-16T21:00")
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
