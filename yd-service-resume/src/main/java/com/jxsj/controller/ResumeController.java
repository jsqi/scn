package com.jxsj.controller;

import com.jxsj.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume")
public class ResumeController {
    @Value("${server.port}")
    private Integer port;

    @Autowired
    private ResumeService resumeService;

    @GetMapping("/openstate/{userId}")
    public Integer findDefaultResumeState(@PathVariable Long userId) {
        return port;
        // return resumeService.findDefaultResumeByUserId(userId).getIsOpenResume();
    }
}
