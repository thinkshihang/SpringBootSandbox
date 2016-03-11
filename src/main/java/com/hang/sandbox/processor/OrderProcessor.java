package com.hang.sandbox.processor;

import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {

    public void processOrder() {
        throw new ArithmeticException();
    }
}
