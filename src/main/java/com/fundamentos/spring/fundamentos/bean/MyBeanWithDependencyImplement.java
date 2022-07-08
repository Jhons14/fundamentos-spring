package com.fundamentos.spring.fundamentos.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{
    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int number = 5;
        System.out.println(myOperation.sum(number));
        System.out.println("Hola desde mi bean con dependencia");
    }
}
