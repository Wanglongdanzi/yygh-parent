package com.atguigu.yygh.hospset.config;

import org.mybatis.spring.annotation.MapperScan;
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
public class HospSetConfig {
}

