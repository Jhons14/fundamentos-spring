package com.fundamentos.spring.fundamentos;

import com.fundamentos.spring.fundamentos.bean.MyBean;
import com.fundamentos.spring.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.spring.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	@Autowired //CON LA ANOTACION AUTOWIRED SE PUEDE INYECTAR SIN NECESIDAD DE DECLARAR EN EL CONSTRUCTOR
	private MyBean myBean;

	private ComponentDependency componentDependency;
	private MyBeanWithDependency myBeanWithDependency;

	public FundamentosApplication (@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBeanWithDependency myBeanWithDependency){
		this.componentDependency = componentDependency;
		this.myBeanWithDependency = myBeanWithDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
	}
}
