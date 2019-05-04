package com.zzping.common.controller;
import com.zzping.common.application.client.BaseClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 33709
 */
@RestController
@CrossOrigin //允许跨域
@RequestMapping("/test")
public class CommonController {
    /**
     * @param
     * @return
     */
    @Autowired
    private BaseClient baseClient;
    @RequestMapping("/commomTest")
    public String commonTest(@RequestHeader Map map, @RequestBody String str){
       // System.out.println(map);
        System.out.println(str);
        String s = baseClient.testFeign(str);
        return s;
    }

}
