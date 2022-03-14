package com.between.test.application.port.in;

import com.between.test.domain.PriceQueryByDate;
import com.between.test.domain.ValidRate;

public interface PricesQuery {
    PriceQueryByDate execute (ValidRate validRate);
}