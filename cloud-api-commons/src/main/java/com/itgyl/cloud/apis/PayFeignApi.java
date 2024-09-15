package com.itgyl.cloud.apis;

import com.itgyl.cloud.entities.Pay;
import com.itgyl.cloud.resp.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(value = "cloud-payment-service")
@FeignClient(value = "cloud-gateway")
public interface PayFeignApi {

    @GetMapping("/pay/get/{id}") // 远程调用微服务接口，即将要调用接口的url写入，feign会进行远程调用
    public Result getPayInfo(@PathVariable("id") Long id);

    @GetMapping("/pay/get/info")
    public String getInfoByConsul();

    @GetMapping(value = "/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/gateway/get/{id}")
    public Result<Pay> getGatewayId(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/gateway/info")
    public Result<String> getGatewayInfo();
}
