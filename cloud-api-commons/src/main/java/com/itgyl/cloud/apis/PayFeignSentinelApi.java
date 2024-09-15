package com.itgyl.cloud.apis;

import com.itgyl.cloud.apis.impl.PayFeignSentinelApiFallBack;
import com.itgyl.cloud.resp.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PayFeignSentinelApiFallBack.class)
public interface PayFeignSentinelApi
{
    @GetMapping("/pay/nacos/get/{orderNo}")
    public Result getPayByOrderNo(@PathVariable("orderNo") String orderNo);
}