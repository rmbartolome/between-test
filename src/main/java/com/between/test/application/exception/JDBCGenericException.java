package com.between.test.application.exception;

import com.between.test.config.ErrorCode;
import com.between.test.config.exception.GenericException;

public final class JDBCGenericException extends GenericException {

    public JDBCGenericException(ErrorCode errorCode) {
        super(errorCode);
    }
}
