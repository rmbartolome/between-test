package com.between.test.adapter.controller;

import brave.Tracer;
import com.between.test.adapter.controller.model.ResponseRest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.function.Function;

public interface RequestProcessor {

    <T> ResponseRest<T> processRequest(EnrichedRequest request, Function<EnrichedRequest, ResponseRest<T>> operation);

    Map<String, String> buildMetadata(HttpServletRequest request, Tracer tracer);

    @Getter
    @RequiredArgsConstructor
    final class EnrichedRequest {
        private final String id;
        private final HttpServletRequest request;

        public static EnrichedRequest of(HttpServletRequest request) {
            return of("", request);
        }

        public static EnrichedRequest of(String id, HttpServletRequest request) {
            return new EnrichedRequest(id, request);
        }
    }
}
