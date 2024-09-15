package com.itgyl.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.itgyl.cloud.entities.Pay;
import com.itgyl.cloud.resp.Result;
import com.itgyl.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayGateWayController
{
    @Resource
    PayService payService;

    @GetMapping(value = "/pay/gateway/get/{id}")
    public Result<Pay> getById(@PathVariable("id") Integer id)
    {
        Pay pay = payService.getById(id);
        return Result.success(pay);
    }

    @GetMapping(value = "/pay/gateway/info")
    public Result<String> getGatewayInfo()
    {
        return Result.success("gateway info test："+ IdUtil.simpleUUID());
    }
}