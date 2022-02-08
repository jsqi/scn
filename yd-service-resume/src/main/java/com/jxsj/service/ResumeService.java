package com.jxsj.service;

import com.jxsj.pojo.Resume;

public interface ResumeService {

    /**
     * 根据用户Id 查询默认的简历
     * @param userId
     * @return
     */
    Resume findDefaultResumeByUserId(Long userId);
}
