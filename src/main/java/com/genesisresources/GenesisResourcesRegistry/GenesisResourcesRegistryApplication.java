package com.genesisresources.GenesisResourcesRegistry;

import com.genesisresources.GenesisResourcesRegistry.dto.CreateUserDTO;
import com.genesisresources.GenesisResourcesRegistry.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class GenesisResourcesRegistryApplication {
	public static void main(String[] args) {
		SpringApplication.run(GenesisResourcesRegistryApplication.class,args);

//		ApplicationContext context =  SpringApplication.run(GenesisResourcesRegistryApplication.class, args);
//
//		UserService service = context.getBean(UserService.class);
//
//		CreateUserDTO user = new CreateUserDTO("john","motorkar","adada4");
//
//		service.createUser(user);


	}

}
