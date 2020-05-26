package com.aote.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author aote
 * @Date 2020-05-26 21:36
 * @Version 1.0
 * @Description 返回前端的通用实体
 **/
@Data
@AllArgsConstructor // 全参
@NoArgsConstructor // 空参
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }

}
