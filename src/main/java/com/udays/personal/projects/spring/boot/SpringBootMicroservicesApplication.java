package com.udays.personal.projects.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservicesApplication.class, args);
	}

	@Bean
	public Docket apis(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("public-apis")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.udays.personal.projects.spring.boot.services"))
				.build();
	}

}
