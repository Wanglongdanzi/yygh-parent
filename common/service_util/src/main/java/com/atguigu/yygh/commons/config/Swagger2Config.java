package com.atguigu.yygh.commons.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Wldz
 * @version 1.0.0
 * @description TODO
 * @date 23-6-26 18:19
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * @description: Docket(备忘录)相当于一个组group,
     * @author: Wldz
     * @param: []
     * @return: springfox.documentation.spring.web.plugins.Docket
     **/
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                //不加paths时显示所有的controller,包括springboot自带的BasicErrorController
                //.paths(Predicates.and(PathSelectors.regex("/api/.*")))
                //ApiInfoBuilder.build()实例化apiInfo
                .build();
    }
    @Bean
    public Docket adminApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .apiInfo(adminApiInfo())
                .select()
                //只显示admin路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();
    }


    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("前台网站-API文档")
                .description("本文档描述了前台网站微服务接口定义")
                .version("1.0")
                .contact(new Contact("wldz", "https://github.com/Wanglongdanzi/yygh-parent.git", "3234141970@qq.com"))
                .build();
    }
    private ApiInfo adminApiInfo(){
        return new ApiInfoBuilder()
                .title("后台管理系统-API文档")
                .description("本文档描述了后台管理系统微服务接口定义")
                .version("1.0")
                .contact(new Contact("wldz", "https://github.com/Wanglongdanzi/yygh-parent.git", "3234141970@qq.com"))
                .build();
    }
}

