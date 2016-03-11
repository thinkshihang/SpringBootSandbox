package com.hang.sandbox.exceptions;

import org.apache.commons.logging.Log;

public class OrderIsInvalidException extends RuntimeException {

    private Log logger;

    public OrderIsInvalidException(Log logger) {
        super();
        this.logger = logger;
    }

    public Log getLogger() {
        return logger;
    }

    public void setLogger(Log logger) {
        this.logger = logger;
    }
}
