package com.between.test.adapter.jdbc;

import com.between.test.adapter.controller.model.PricesResponse;
import com.between.test.application.port.out.PricesRepository;
import com.between.test.domain.PriceQueryByDate;
import com.between.test.domain.ValidRate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class PricesAdapter implements PricesRepository {

    private PricesJpaRepository pricesJpaRepository;

    public PricesAdapter(PricesJpaRepository pricesJpaRepository) {
        this.pricesJpaRepository = pricesJpaRepository;
    }

    @Override
    public PriceQueryByDate getValidRate(ValidRate validRate) {
        var dateTime = LocalDateTime.parse(validRate.getDateApplication());
        return PriceQueryByDate.builder()
                .id(1)
                .dateEndApplication("hola")
                .productId(34545)
                .price(100.00)
                .brand(1)
                .build();
        /*
        var result = pricesJpaRepository.getValidRate(dateTime,validRate.getProductId(),validRate.getBrandId());
        return PricesResponse.builder()
                .id(result.getId())
                .brandId(result.getBrand().getId())
                .dateStartApplication(result.getStart_date().toString())
                .dateEndApplication(result.getEnd_date().toString())
                .price(result.getPrice())
                .productId(result.getProduct_id())
                .build().toDomain();

         */
    }
}
