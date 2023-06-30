package com.jsp.studentboot.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
public class ApplicationConfig {

  @Bean
  public Docket getDocket() {
	  
	  Contact contact=new Contact("charan", "", "charan@gmail.com");
	  List<VendorExtension> extensions=new ArrayList<VendorExtension>();
	  ApiInfo apiInfo= new ApiInfo("Student-management-system",
			  "this is a rest API built on spring boot",
			  "It is used to manage the student details ",
			  "1.0Final", contact, "", "", extensions);
	  return new Docket(DocumentationType.SWAGGER_2).select()
			     .apis(RequestHandlerSelectors.
					  basePackage("com.jsp.studentboot") ).build()
               .apiInfo(apiInfo).useDefaultResponseMessages(false);   
}
}

/**  example 
@Bean
 public Student getStudent() {
  return Student();
}  

*EndPoints @postmapping("this called end point");
*
*Docket will recognize the endpoints
*
*base package also take care Dockets base package means leaving the main package all base package
*
 **/