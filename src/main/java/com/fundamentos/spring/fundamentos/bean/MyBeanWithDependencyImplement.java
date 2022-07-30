package com.fundamentos.spring.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private MyOperation myOperation;
    private final Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Hemos ingresado al metodo printWithDependency");
        int number = 5;
        LOGGER.debug("El numero a operar es: "+ number);
        System.out.println(myOperation.sum(number));
        System.out.println("Hola desde mi bean con dependencia");
    }
}
