package com.itgyl.cloud.controller;

import com.itgyl.cloud.entities.Pay;
import com.itgyl.cloud.entities.*;
import com.itgyl.cloud.resp.Result;
import com.itgyl.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {

    @Resource PayService payService;

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public Result<Integer> addPay(@RequestBody Pay pay){
        return Result.success(payService.add(pay));
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public Result<Integer> deletePay(@PathVariable("id") Integer id) {
        return Result.success(payService.delete(id));
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public Result<Integer> updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        return Result.success(payService.update(pay));
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public Result<Pay> getById(@PathVariable("id") Integer id){
        return Result.success(payService.getById(id));
    }

    //全部查询
    @GetMapping(value = "/pay/getall")
    @Operation(summary = "全部查询",description = "查询所有支付流水方法")
    public Result<List<Pay>> getAll() {
        return Result.success(payService.getAll());
    }

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    public String getInfoByConsul(@Value("${itgyl.info}") String itgyl) {
        return "itgyl: "+itgyl+"\t"+"port: "+port;
    }

}
