package com.between.test.adapter.controller.model;

import com.between.test.domain.ValidRate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ValidRateRequest {

    @JsonProperty("fecha")
    private String dateApplication;
    @JsonProperty("producto")
    private Integer productId;
    @JsonProperty("cadena")
    private Integer brandId;

    public ValidRate toDomain(){
        return ValidRate.builder()
                .brandId(this.brandId)
                .productId(this.productId)
                .dateApplication(dateApplication)
                .build();
    }

    public static ValidRateRequest of(ValidRate validRate){
        return ValidRateRequest.builder()
                .brandId(validRate.getBrandId())
                .productId(validRate.getProductId())
                .dateApplication(validRate.getDateApplication())
                .build();
    }
}