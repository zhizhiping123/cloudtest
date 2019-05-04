package com.zzping.common.application;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.zzping.common.CommonResponse;
import com.zzping.common.JwtCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Controller
@RequestMapping("/common")
@EnableMongoRepositories
@EnableFeignClients
@ComponentScan(basePackages = "com.zzping")
public class CommonApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CommonApplication.class);
        String[] definitionNames = run.getBeanDefinitionNames();
        for(String bean : definitionNames){
            System.out.println(bean);
          //  BasicDBObject
        }
    }

    public CommonResponse response(){
        CommonResponse response = new CommonResponse();
        return response;
    }

    @Bean
    @ConfigurationProperties(prefix = "jwt.config")
    public JwtCreator jwtCreator(){
        JwtCreator jwtCreator = new JwtCreator();
        return jwtCreator;
    }

    @Bean
    public RestTemplate restTemplate(JwtCreator jwtCreator){
       String id = jwtCreator.getId();
       return new RestTemplate();
    }
    @RequestMapping("test1")
    @ResponseBody
    public String test(){
        return "123";
    }
}
