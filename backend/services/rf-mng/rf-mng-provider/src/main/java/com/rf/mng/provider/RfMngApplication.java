package com.rf.mng.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 社保缴费管理后台应用。
 */
@EnableDubbo
@SpringBootApplication
public class RfMngApplication {

    /**
     * 应用入口。
     *
     * @param args 启动参数
     */
    public static void main(String[] args) {
        SpringApplication.run(RfMngApplication.class, args);
    }
}
