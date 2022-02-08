package com.jxsj.feign;

import com.jxsj.fallback.ResumeFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "yd-service-resume",fallback = ResumeFallback.class,path = "/resume")
// @RequestMapping("/resume")
public interface ResumeFeignClient {

    @GetMapping("/openstate/{userId}")
    Integer findDefaultResumeState(@PathVariable Long userId);
}
