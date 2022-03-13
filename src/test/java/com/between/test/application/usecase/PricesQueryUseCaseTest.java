package com.between.test.application.usecase;

import com.between.test.application.port.out.PricesRepository;
import com.between.test.faker.PricesFaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PricesQueryUseCaseTest {

    @Mock
    private PricesRepository pricesRepository;

    @InjectMocks
    private GetPricesUseCase useCase;

    @DisplayName("Execute test when ok should return data")
    @Test
    void executeWhenOk_shouldReturnOkData() throws Exception {
        var request = PricesFaker.fakeValidRate1();

        Mockito.when(pricesRepository.getValidRate(request)).thenReturn(PricesFaker.fakePriceResponse());

        var result = useCase.execute(request);

        assertThat(result).isNotNull();
    }
}
