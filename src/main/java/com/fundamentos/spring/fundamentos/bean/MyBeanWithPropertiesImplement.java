package com.fundamentos.spring.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties{

    private String nombre;
    private String apellido;

    private Log LOGGER = LogFactory.getLog(MyBeanWithPropertiesImplement.class);

    public MyBeanWithPropertiesImplement(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        LOGGER.debug("Entramos en el metodo function de bean con dependencia");
        return nombre + "-" + apellido;
    }
}
