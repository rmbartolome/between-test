package com.between.test.adapter.jdbc;

import com.between.test.adapter.controller.model.PricesResponse;
import com.between.test.application.exception.JDBCGenericException;
import com.between.test.application.port.out.PricesRepository;
import com.between.test.config.ErrorCode;
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

        var resultList = pricesJpaRepository.findValidRate(dateTime,validRate.getProductId(),validRate.getBrandId());

        if(!resultList.isEmpty()){
            var result = resultList.get(0);
            return PricesResponse.builder()
                    .id(result.getId())
                    .brandId(result.getBrand().getId())
                    .dateStartApplication(result.getStartDate().toString())
                    .dateEndApplication(result.getEndDate().toString())
                    .price(result.getPriceRate())
                    .productId(result.getProductId())
                    .build().toDomain();
        } else {
            log.error("Error inesperado");
            throw new JDBCGenericException(ErrorCode.DATABASE_INTERNAL_ERROR);
        }
    }
}
