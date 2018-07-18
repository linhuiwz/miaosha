package com.imooc.miaosha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceCContorller {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/servicec")
    public String servicec() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Now, we reach the terminal call: servicec !";

    }

}
