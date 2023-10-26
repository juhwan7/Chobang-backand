package com.chobang.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig  {

    @Bean
    public Docket api(TypeResolver typeResolver) {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.chobang.controller"))
                .paths(PathSelectors.any())
                .build();
//                .consumes(Collections.singleton(MediaType.MULTIPART_FORM_DATA_VALUE))
//                .produces(Collections.singleton(MediaType.APPLICATION_JSON_VALUE));
//                .ignoredParameterTypes(CustomUserDetail.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger")
                .description("초방 API")
                .version("0.1")
                .build();
    }

}
