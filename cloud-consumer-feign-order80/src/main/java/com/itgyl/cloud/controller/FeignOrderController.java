package com.itgyl.cloud.controller;

import com.itgyl.cloud.apis.PayFeignApi;
import com.itgyl.cloud.resp.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignOrderController {

    @Resource
    private PayFeignApi payFeignApi; // 将feign接口引入，并开启相关注解，即可完成远程调用

    @GetMapping("/feign/pay/get/{id}")
    public Result getPayInfo(@PathVariable("id") Long id) {
        return payFeignApi.getPayInfo(id);
    }

    @GetMapping("/feign/pay/get/info")
    public String getPayInfoByConsul() {
        return payFeignApi.getInfoByConsul();
    }
}
