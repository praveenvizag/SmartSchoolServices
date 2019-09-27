package com.smartschool.services.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

	@Bean
	public Docket smartSchoolAPI() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.smartschool")).build().apiInfo(getMetaInfo());
	}

	private ApiInfo getMetaInfo() {

		return new ApiInfo("Smart School Services", "Spring Boot Smart School Services with Mongo DB", "1.0",
				"Terms Of Service", "praveen.konchada@gmail.com", "copyrights@2019",
				"http://localhost:8081/swagger-ui.html");
	}

}
