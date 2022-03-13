package com.between.test.application.exception;

import com.between.test.config.ErrorCode;
import com.between.test.config.exception.GenericException;

public class BadRequestRestClientException extends GenericException {

    public BadRequestRestClientException(ErrorCode errorCode){
        super(errorCode);
    }

}
