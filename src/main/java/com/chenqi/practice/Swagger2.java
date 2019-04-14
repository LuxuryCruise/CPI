package com.chenqi.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2 {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                指定路径
                .apis(RequestHandlerSelectors.basePackage("com.chenqi.practice.modules"))
                .paths(PathSelectors.any())
                .build();
        
    }

    /*构建 api文档的详细信息函数*/
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试项目中的api")
                .contact(new Contact("chenqi","http://www.baidu.com",""))
                .version("1.0")
                .description("API描述")
                .build();

    }

}
