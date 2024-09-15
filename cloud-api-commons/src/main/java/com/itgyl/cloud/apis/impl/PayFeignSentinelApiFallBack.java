package com.itgyl.cloud.apis.impl;

import com.itgyl.cloud.apis.PayFeignSentinelApi;
import com.itgyl.cloud.resp.Result;
import com.itgyl.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi
{
    @Override
    public Result getPayByOrderNo(String orderNo)
    {
        return Result.fail(ReturnCodeEnum.RC500.getCode(),"对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}