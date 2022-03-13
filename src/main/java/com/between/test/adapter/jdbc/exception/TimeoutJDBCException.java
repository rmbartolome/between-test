package com.between.test.adapter.jdbc.exception;

import com.between.test.config.ErrorCode;
import com.between.test.config.exception.GenericException;

public final class TimeoutJDBCException extends GenericException {

    public TimeoutJDBCException(ErrorCode errorCode) {
        super(errorCode);
    }

}
