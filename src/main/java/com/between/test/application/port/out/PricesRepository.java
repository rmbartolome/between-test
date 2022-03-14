package com.between.test.application.port.out;

import com.between.test.domain.PriceQueryByDate;
import com.between.test.domain.ValidRate;

public interface PricesRepository {
    PriceQueryByDate getValidRate(ValidRate validRate);
}