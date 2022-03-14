package com.between.test.config;

public enum ErrorCode {

    INTERNAL_ERROR(100, "Error interno del servidor"),
    DATABASE_INTERNAL_ERROR(101, "Timeout de cliente rest"),
    REST_CLIENT_EMPTY(102, "El cliente rest no devolvio nada"),
    BAD_REQUEST(103, "Bad request");

    private final int value;
    private final String reasonPhrase;

    ErrorCode(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value() {
        return this.value;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }
}
