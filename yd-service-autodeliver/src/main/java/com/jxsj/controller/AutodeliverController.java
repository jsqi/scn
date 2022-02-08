package com.jxsj.controller;

import com.jxsj.feign.ResumeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/autodeliver")
public class AutodeliverController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private ResumeFeignClient resumeFeignClient;


    @GetMapping("/checkState/{userId}")
    public Integer findResumeOpenState(@PathVariable Long userId){
//        Integer forObject = restTemplate.getForObject("http://localhost:8080/resume/openstate/" + userId, Integer.class);

        // 从注册中心获取实例列表
//        List<ServiceInstance> instances = discoveryClient.getInstances("yd-service-resume");
//        // 获取一个实例
//        ServiceInstance serviceInstance = instances.get(0);
//        String host = serviceInstance.getHost();
//        int port = serviceInstance.getPort();
//        String url = "http://"+host+":"+port+"/resume/openstate/"+userId;
//        Integer forObject = restTemplate.getForObject(url, Integer.class);
        Integer forObject = restTemplate.getForObject("http://yd-service-resume/resume/openstate/" + userId, Integer.class);
        System.out.println("======>>>调⽤简历微服务，获取到⽤户" +  userId + "的默认简历当前状态为：" + forObject);
        return forObject;
    }

    /**
     * 提供者模拟处理超时，调⽤⽅法添加Hystrix控制
     * @param userId
     * @return
     * 使⽤@HystrixCommand注解进⾏熔断控制
     */
//    @HystrixCommand(threadPoolKey = "findResumeOpenStateTimeout",threadPoolProperties = {
//            @HystrixProperty(name = "coreSize",value = "1"),
//            @HystrixProperty(name = "maxQueueSize",value = "20")},
//            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")}
//    )
    @GetMapping("/checkStateTimeout/{userId}")
    public Integer findResumeOpenStateTimeout(@PathVariable Long userId) {
        // 使⽤ribbon不需要我们⾃⼰获取服务实例然后选择⼀个那么去访问了（⾃⼰的负载均衡）
        String url = "http://lagou-service-resume/resume/openstate/" + userId; // 指定服务名
        Integer forObject = restTemplate.getForObject(url,
                Integer.class);
        return forObject;
    }

    @GetMapping("/checkStateFeign/{userId}")
    public Integer findResumeOpenStateFeign(@PathVariable Long userId) {
        return resumeFeignClient.findDefaultResumeState(userId);
    }
}
