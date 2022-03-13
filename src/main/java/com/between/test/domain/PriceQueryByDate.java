package com.between.test.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PriceQueryByDate {

    Integer id;
    Integer brand;
    String dateStartApplication;
    String dateEndApplication;
    Integer productId;
    Double price;
}
