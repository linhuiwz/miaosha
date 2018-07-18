package com.imooc.miaosha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceBContorller {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/serviceb")
    public String serviceb() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return restTemplate.getForObject("http://localhost:8083/servicec", String.class);
    }

}
