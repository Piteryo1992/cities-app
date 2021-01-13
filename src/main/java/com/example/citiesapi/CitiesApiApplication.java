package com.example.citiesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.EntityManager;
import java.lang.reflect.Type;
import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class CitiesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CitiesApiApplication.class, args);
    }

    @Bean
	public Docket get() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/cities/**"))
				.apis(RequestHandlerSelectors.basePackage("com.example.citiesapi"))
				.build().apiInfo(createApiInfo());
	}

	private ApiInfo createApiInfo() {
		return new ApiInfo(
				"Cities App",
				"Cities Application API",
				"1.0.0",
				"http://google,com",
				new Contact("Pjoter", "http://google.com", "piotr@gmail.com"),
				"My own licence",
				"http://google.com",
				Collections.emptyList()
		);
	}
}