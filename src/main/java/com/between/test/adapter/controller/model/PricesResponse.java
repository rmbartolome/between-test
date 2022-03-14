package com.between.test.adapter.controller.model;

import com.between.test.domain.PriceQueryByDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PricesResponse {

    @JsonProperty("tarifa_id")
    private Integer id;
    @JsonProperty("identificador_cadena")
    private Integer brandId;
    @JsonProperty("fecha_inicio")
    private String dateStartApplication;
    @JsonProperty("fecha_fin")
    private String dateEndApplication;
    @JsonProperty("producto_id")
    private Integer productId;
    @JsonProperty("precio_final")
    private Double price;

    public PriceQueryByDate toDomain(){
        return PriceQueryByDate.builder()
                .id(this.id)
                .brand(this.brandId)
                .dateStartApplication(this.dateStartApplication)
                .dateEndApplication(this.dateEndApplication)
                .productId(this.productId)
                .price(this.price)
                .build();
    }

    public static PricesResponse of(PriceQueryByDate priceQueryByDate){
        return PricesResponse.builder()
                .id(priceQueryByDate.getId())
                .brandId(priceQueryByDate.getBrand())
                .productId(priceQueryByDate.getProductId())
                .price(priceQueryByDate.getPrice())
                .dateStartApplication(priceQueryByDate.getDateStartApplication())
                .dateEndApplication(priceQueryByDate.getDateEndApplication())
                .build();
    }
}
