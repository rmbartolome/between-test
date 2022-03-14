package com.between.test.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ValidRate {

    String dateApplication;
    Integer productId;
    Integer brandId;
}
