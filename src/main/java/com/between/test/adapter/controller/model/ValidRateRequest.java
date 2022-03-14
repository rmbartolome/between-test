package com.between.test.adapter.controller.model;

import com.between.test.domain.ValidRate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ValidRateRequest {

    @PastOrPresent
    @JsonProperty("fecha")
    private LocalDateTime dateApplication;

    @Min(1)
    @JsonProperty("producto")
    private Integer productId;

    @Min(1)
    @JsonProperty("cadena")
    private Integer brandId;

    public ValidRate toDomain(){
        return ValidRate.builder()
                .brandId(this.brandId)
                .productId(this.productId)
                .dateApplication(dateApplication.toString())
                .build();
    }

    public static ValidRateRequest of(ValidRate validRate){
        return ValidRateRequest.builder()
                .brandId(validRate.getBrandId())
                .productId(validRate.getProductId())
                .dateApplication(LocalDateTime.parse(validRate.getDateApplication()))
                .build();
    }
}