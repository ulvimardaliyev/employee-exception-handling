package com.employee.exception.handling.config;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .produces(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.employee.exception.handling.controller"))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(
                        new ApiInfo(
                                "Swagger Config",
                                "employee-employer exception handling in spring book exception handler",
                                "0.0.1",
                                "terms/url",
                                new Contact(
                                        "Ulvi",
                                        "https://github.com/ulvimardaliyev/employee-exception-handling.git",
                                        "merdeliyev@inbox.ru"
                                ),
                                "open license",
                                "license/url",
                                Collections.emptyList()));
    }
}
