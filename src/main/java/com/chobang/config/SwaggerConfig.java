package com.chobang.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@SuppressWarnings("unchecked")	// 무점검 경고 제거
public class SwaggerConfig {

    @Bean
    public Docket api(TypeResolver typeResolver) {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.chobang.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalResponseMessage(RequestMethod.GET, getCustomizedResponseMessages())
                .globalResponseMessage(RequestMethod.POST, getCustomizedResponseMessages())
                .globalResponseMessage(RequestMethod.DELETE, getCustomizedResponseMessages())
                .globalResponseMessage(RequestMethod.PUT, getCustomizedResponseMessages())
                .globalResponseMessage(RequestMethod.PATCH, getCustomizedResponseMessages());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger")
                .description("초방 API")
                .version("0.1")
                .build();
    }

    private List<ResponseMessage> getCustomizedResponseMessages() {
        List<ResponseMessage> responseMessages = new ArrayList<>();
        responseMessages.add(new ResponseMessageBuilder().code(200).message("성공").build());
        responseMessages.add(new ResponseMessageBuilder().code(204).message("데이터 미존재").build());
        responseMessages.add(new ResponseMessageBuilder().code(400).message("입력값 오류").build());
        responseMessages.add(new ResponseMessageBuilder().code(401).message("미 로그인").build());
        responseMessages.add(new ResponseMessageBuilder().code(403).message("권한없음").build());
        responseMessages.add(new ResponseMessageBuilder().code(412).message("처리중 오류").build());
        responseMessages.add(new ResponseMessageBuilder().code(500).message("서버에러").build());
        return responseMessages;
    }
}
