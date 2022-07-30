package com.fundamentos.spring.fundamentos;

import com.fundamentos.spring.fundamentos.bean.MyBean;
import com.fundamentos.spring.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.spring.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.spring.fundamentos.component.ComponentDependency;
import com.fundamentos.spring.fundamentos.entity.User;
import com.fundamentos.spring.fundamentos.pojo.UserPojo;
import com.fundamentos.spring.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	@Autowired //CON LA ANOTACION AUTOWIRED SE PUEDE INYECTAR SIN NECESIDAD DE DECLARAR EN EL CONSTRUCTOR
	private MyBean myBean;

	private ComponentDependency componentDependency;
	private MyBeanWithDependency myBeanWithDependency;

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	@Autowired
	private MyBeanWithProperties myBeanWithProperties;

	@Autowired
	private UserPojo userPojo;

	@Autowired
	private User user;
	@Autowired
	UserRepository userRepository;

	public FundamentosApplication (@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBeanWithDependency myBeanWithDependency){
		this.componentDependency = componentDependency;
		this.myBeanWithDependency = myBeanWithDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		ejemplosAnteriores();
		saveUsersInDatabase();
	}

	private void saveUsersInDatabase(){

		User user1 = new User("Jhon","jhon@domain.com", LocalDate.of(2000,7,14));
		User user2 = new User("user2","user2@domain.com", LocalDate.of(2010,12,7));
		User user3 = new User("user3","user3@domain.com", LocalDate.of(2007,2,1));
		User user4 = new User("user4","user4@domain.com", LocalDate.of(2004,10,24));
		User user5 = new User("user5","user5@domain.com", LocalDate.of(2001,8,10));
		List<User> users = Arrays.asList(user1,user2,user3,user4,user5);
		users.stream().forEach(userRepository::save);
	}

	private void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		LOGGER.debug("Imprimiendo User Pojo");
		System.out.println(userPojo.toString());

		try {
			int value = 10/0;
			System.out.println(value);
		}
		catch (Exception e){
			LOGGER.error("Esto es un error al dividir por zero "+ e.getMessage());
		}
	}
}
