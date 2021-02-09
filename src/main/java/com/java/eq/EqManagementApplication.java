package com.java.eq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@MapperScan(basePackages = "com.java.eq.mapper")
public class EqManagementApplication {

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(EqManagementApplication.class)
        .web(WebApplicationType.NONE).run(args);
    }
}