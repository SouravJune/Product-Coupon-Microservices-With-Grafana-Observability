package com.ms.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cloud-bus")
@RefreshScope
public class SpringCloudBusController {

    @Value("${com.ms.spring-cloud.prop}")
    private String prop;

    @GetMapping("/prop")
    public String getProperties(){
        return this.prop;
    }
}
