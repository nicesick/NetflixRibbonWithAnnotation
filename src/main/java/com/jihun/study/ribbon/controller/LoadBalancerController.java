package com.jihun.study.ribbon.controller;

import com.jihun.study.ribbon.ribbon.config.RibbonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
@RestController
@RibbonClient(name = "sample-client", configuration = RibbonConfig.class)
public class LoadBalancerController {
    private RestTemplate restTemplate;

    @Autowired
    public LoadBalancerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("loadBalancer")
    public String getLoadBalancer() {
        return restTemplate.getForObject("http://sample-client", String.class);
    }
}
