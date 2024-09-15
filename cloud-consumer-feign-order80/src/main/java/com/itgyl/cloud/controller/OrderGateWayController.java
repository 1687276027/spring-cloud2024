package com.itgyl.cloud.controller;

import com.itgyl.cloud.apis.PayFeignApi;
import com.itgyl.cloud.resp.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderGateWayController {

    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping("/consumer/gateway/get/{id}")
    public Result getById(@PathVariable("id") Integer id) {
        return payFeignApi.getGatewayId(id);
    }

    @GetMapping(value = "/consumer/gateway/info")
    public Result<String> getGatewayInfo() {
        return payFeignApi.getGatewayInfo();
    }
}
