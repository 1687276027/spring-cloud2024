package com.itgyl.cloud.service;

import com.itgyl.cloud.entities.Pay;

import java.util.List;


public interface PayService {

    int add(Pay pay);

    Integer delete(Integer id);

    int update(Pay pay);

    Pay getById(Integer id);

    List<Pay> getAll();
}
