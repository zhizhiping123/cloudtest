package com.zzping.common;

import com.netflix.discovery.converters.Auto;
import com.netflix.loadbalancer.IRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class BaseController {
    @Value("${name}")
    private String name;
    @Autowired
    private Environment env;
    @PostMapping("/testFign")
    public String testFeign(@RequestHeader Map map,@RequestBody String str){

        return name;
    }
    @PostMapping("/testFign1")
    public String testFeign1(@RequestHeader Map map,@RequestBody String str){

        return env.getProperty("name");
    }
}
