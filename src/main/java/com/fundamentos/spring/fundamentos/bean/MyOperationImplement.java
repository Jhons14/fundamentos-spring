package com.fundamentos.spring.fundamentos.bean;

import lombok.extern.slf4j.Slf4j;
@Slf4j

public class MyOperationImplement implements  MyOperation{

    @Override
    public int sum(int number) {
        log.info("Entrando en la operacion");
        return number+1;
    }
}
