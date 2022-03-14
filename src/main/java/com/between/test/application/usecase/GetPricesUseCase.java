package com.between.test.application.usecase;

import com.between.test.application.port.in.PricesQuery;
import com.between.test.application.port.out.PricesRepository;
import com.between.test.domain.PriceQueryByDate;
import com.between.test.domain.ValidRate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GetPricesUseCase implements PricesQuery {

    private final PricesRepository pricesRepository;

    public GetPricesUseCase(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Override
    public PriceQueryByDate execute(ValidRate validRate)  {
        log.info("Comienza ejecución caso de uso para consultar tarifa por fecha, producto y cadena");
        return pricesRepository.getValidRate(validRate);
    }
}