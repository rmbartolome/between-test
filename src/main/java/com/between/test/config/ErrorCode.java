package com.between.test.config;

public enum ErrorCode {

    INTERNAL_ERROR(100, "Error interno del servidor"),
    REST_CLIENT_TIMEOUT(101, "Timeout de cliente rest"),
    REST_CLIENT_EMPTY(102, "El cliente rest no devolvio nada"),
    BAD_REQUEST(103, "Bad request"),
    DECRYPT_PROCESS_FAILED(104, "Ocurrio un Error al intentar desencriptar"),
    WEB_CLIENT_GENERIC(105, "Error del Web Client");

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
