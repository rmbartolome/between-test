package com.between.test.adapter.controller;

import com.between.test.adapter.controller.exception.NotFoundRestClientException;
import com.between.test.adapter.controller.model.PricesResponse;
import com.between.test.adapter.controller.model.ResponseRest;
import com.between.test.adapter.controller.model.ValidRateRequest;
import com.between.test.application.port.in.PricesQuery;
import com.between.test.config.ErrorCode;
import com.between.test.config.TestConfig;
import com.between.test.domain.ValidRate;
import com.between.test.faker.PricesFaker;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Prices Controller Adapter Test")
@WebMvcTest(PricesControllerAdapter.class)
@Import(TestConfig.class)
class PricesControllerAdapterTest {

    private static final String UTF_8 = "utf-8";
    private static final String URL_BASE="/api/v1.0/between";
    private static final String URL_QUERY = URL_BASE.concat("/prices");

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private MsRequestProcessor msRequestProcessor;

    @MockBean
    private PricesQuery pricesQuery;

    @Autowired
    public MockMvc mvc;

    @Test
    @DisplayName("When correct request generate should return ok")
    void whenCorrectRequest_ThenReturnOk() throws Exception {

        var request = ValidRateRequest.of(PricesFaker.fakeValidRate1());
        var response = PricesFaker.fakePriceTransaction();

        when(pricesQuery.execute(any(ValidRate.class)))
                .thenReturn(PricesFaker.fakePriceResponse());

        Mockito.<ResponseRest<PricesResponse>>
                when(msRequestProcessor.processRequest(any(), any()))
                .thenReturn(response);

        mvc.perform(get(URL_QUERY)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request))
                .characterEncoding(UTF_8)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(response)));
    }

    @Test
    @DisplayName("When generate transaction is called but transaction error then return create error")
    void WhenGenerateTransactionIsCalledButTransactionExceptionThenReturnNotFound() throws Exception {

        var request = ValidRateRequest.of(PricesFaker.fakeValidRate1());

        when(pricesQuery.execute(any(ValidRate.class)))
                .thenThrow(new NotFoundRestClientException(ErrorCode.REST_CLIENT_EMPTY));

        mvc.perform(get(URL_QUERY)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request))
                .characterEncoding(UTF_8)
        )
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}