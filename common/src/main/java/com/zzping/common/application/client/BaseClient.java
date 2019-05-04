package com.zzping.common.application.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "base")
public interface BaseClient {
    @PostMapping("/test/testFign")
    public String testFeign(@RequestBody String str);
}
