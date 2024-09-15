package com.itgyl.cloud.resp;

import lombok.Data;

@Data
public class Result<T> {
    private String code;
    private String message;
    private T data;
    private Long creatTime;

    public Result() {
        creatTime = System.currentTimeMillis();
    }

    public static <T> Result<T> success(T data) {
        Result<T> resultData = new Result<>();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        resultData.setData(data);
        return resultData;
    }

    public static <T> Result<T> fail(String code, String message) {
        Result<T> resultData = new Result<>();
        resultData.setCode(code);
        resultData.setMessage(message);
        return resultData;
    }
}
