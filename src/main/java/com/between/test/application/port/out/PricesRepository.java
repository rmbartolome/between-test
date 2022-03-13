package com.between.test.application.port.out;

import com.between.test.domain.PriceQueryByDate;
import com.between.test.domain.ValidRate;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository {
    PriceQueryByDate getValidRate(ValidRate validRate);
}