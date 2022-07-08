package com.fundamentos.spring.fundamentos.bean;



public class MyBeanImplement implements MyBean{

    @Override
    public void print() {
        System.out.println("Hola mundo desde la implementacion de mi bean propio");
    }
}
