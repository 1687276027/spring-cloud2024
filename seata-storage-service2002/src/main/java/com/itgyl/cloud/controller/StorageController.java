package com.itgyl.cloud.controller;

import com.itgyl.cloud.resp.Result;
import com.itgyl.cloud.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController
{
    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/storage/decrease")
    public Result decrease(Long productId, Integer count) {

        storageService.decrease(productId, count);
        return Result.success("扣减库存成功!");
    }
}