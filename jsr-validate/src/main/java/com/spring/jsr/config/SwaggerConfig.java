package com.spring.jsr.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.v3.oas.annotations.Operation;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: xingle
 * @Description:
 * @Date: 2022/5/27 3:33 下午
 */
@Configuration
@EnableOpenApi
@EnableKnife4j
public class SwaggerConfig {

    @Bean
    @SneakyThrows
    public Docket createRestapi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(Operation.class))
                .paths(PathSelectors.any())
                .build()
//                .globalRequestParameters(getGlobalRequestParameters())
                .globalResponses(HttpMethod.GET, getGlobalResponseMessage())
                .globalResponses(HttpMethod.POST, getGlobalResponseMessage());
    }

    /**
     * 生成接口信息，包括标题、联系人等
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("xxxxx项目接口文档")
                .description("项目，模块，")
                .contact(new Contact("xingle", "https://www.choupangxia.com/", "chenzx8@asiainfo.com"))
                .version("1.0")
                .build();
    }

    /**
     * 封装全局通用参数
     */
    private List<RequestParameter> getGlobalRequestParameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder()
//                .name("access_token")
//                .description("token")
                .required(true)
                .in(ParameterType.QUERY)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .required(false)
                .build());
        return parameters;
    }

    /**
     * 封装通用响应信息
     */
    private List<Response> getGlobalResponseMessage() {
        List<Response> responseList = new ArrayList<>();
        responseList.add(new ResponseBuilder().code("404").description("未找到资源").build());
        responseList.add(new ResponseBuilder().code("403").description("无权限").build());
        return responseList;
    }

}
