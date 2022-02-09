package com.jxsj.controller;

import com.jxsj.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume")
@RefreshScope
public class ResumeController {
    @Value("${server.port}")
    private Integer port;
    @Value("${test.name}")
    private String name;

    @Autowired
    private ResumeService resumeService;

    @GetMapping("/openstate/{userId}")
    public Integer findDefaultResumeState(@PathVariable Long userId) {
        System.out.println(name);
        return port;
        // return resumeService.findDefaultResumeByUserId(userId).getIsOpenResume();
    }
}
