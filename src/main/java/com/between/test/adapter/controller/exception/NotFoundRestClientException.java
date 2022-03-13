package com.between.test.adapter.controller.exception;

import com.between.test.config.ErrorCode;
import com.between.test.config.exception.GenericException;

public final class NotFoundRestClientException extends GenericException {

    public NotFoundRestClientException(ErrorCode errorCode) {
        super(errorCode);
    }
}
