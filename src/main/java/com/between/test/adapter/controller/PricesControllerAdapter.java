package com.between.test.adapter.controller;

import brave.Tracer;
import com.between.test.adapter.controller.model.PricesResponse;
import com.between.test.adapter.controller.model.ResponseRest;
import com.between.test.adapter.controller.model.ValidRateRequest;
import com.between.test.application.port.in.PricesQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1.0/between")
@Slf4j
public class PricesControllerAdapter {

    private final MsRequestProcessor msRequestProcessor;
    private final Tracer tracer;
    private final PricesQuery pricesQuery;

    @GetMapping("/prices")
    public ResponseRest<PricesResponse> getValidRate(
            HttpServletRequest request,
            @Valid @RequestBody ValidRateRequest validRateRequest){
        log.info("Se invoca al servicio de consulta de tarifa de precio por producto y cadena a la fecha aplicable");

        var respond = pricesQuery.execute(validRateRequest.toDomain());

        log.info("Se realizó la consulta de la tarifa");

        return msRequestProcessor.processRequest(
                RequestProcessor.EnrichedRequest
                        .of(request),
                result -> ResponseRest.<PricesResponse>builder()
                        .id(result.getId())
                        .status(HttpStatus.OK.value())
                        .resource(result.getRequest().getRequestURI())
                        .data(PricesResponse.of(respond))
                        .metadata(msRequestProcessor.buildMetadata(
                                request, tracer
                        ))
                        .build()
        );
    }
}