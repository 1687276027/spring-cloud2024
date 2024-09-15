package com.itgyl.cloud.controller;

import com.itgyl.cloud.apis.PayFeignApi;
import com.itgyl.cloud.resp.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    //public static final String Payment_URL = "http://localhost:8001"; // 硬编码写死
    public static final String Payment_URL = "http://cloud-payment-service"; // 硬编码写死

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/get/{id}")
    public Result get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(Payment_URL + "/pay/get/" + id, Result.class, id);
    }



}
