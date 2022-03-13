package com.between.test.adapter.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class ResponseRest<T> {

    String id;
    Integer status;
    String resource;
    T data;
    Map<String, String> metadata;
}
