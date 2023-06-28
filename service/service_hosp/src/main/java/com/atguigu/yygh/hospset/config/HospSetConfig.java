package com.atguigu.yygh.hospset.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Wldz
 * @version 1.0.0
 * @description TODO
 * @date 23-6-25 20:11
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.atguigu.yygh.hospset.mapper")
@ComponentScan("com.atguigu.yygh")
public class HospSetConfig {

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }


}

