package com.jxsj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan("com.jxsj.pojo")
@EnableEurekaClient
@EnableDiscoveryClient
public class ResumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeApplication.class,args);
    }
}
