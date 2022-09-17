/**
 * 
 */
package com.meli.challenge;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final String DEFAULT_INCLUDE_PATTERN = "/coupon/.*";
	
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	      .apiInfo(apiInfo())
	      .securityContexts(Arrays.asList(securityContext()))
	      .securitySchemes(Arrays.asList(apiKey()))
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.meli.challenge.controller"))
	      .paths(PathSelectors.any())
	      .build();
	}
	
	private ApiKey apiKey() { 
	    ApiKey apiKey = new ApiKey("JWT", "Authorization", "Header");
		return apiKey; 
	}

	private SecurityContext securityContext() { 
	    return SecurityContext.builder().securityReferences(defaultAuth()).operationSelector(
	    	    oc -> oc.requestMappingPattern().matches(DEFAULT_INCLUDE_PATTERN)).build(); 
	} 

	private List<SecurityReference> defaultAuth() { 
	    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything"); 
	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1]; 
	    authorizationScopes[0] = authorizationScope; 
	    return Arrays.asList(new SecurityReference("JWT", authorizationScopes)); 
	}
	


	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Coupon Challenge",
	      "Api Cupón de compra.",
	      "1.0",
	      null,
	      new Contact("German Biagioli",null, "german.biagioli@gmail.com"),
	      null,
	      null,
	      Collections.emptyList());
	}

   
}