package com.atguigu.yygh.commons.result;


import lombok.Getter;

/**
 * @author Wldz
 * @version 1.0.0
 * @description TODO
 * @date 23-6-25 20:41
 */
public enum ResultCodeEnum {

    SUCCESS(20000,true,"成功"),
    FAILURE(30000,false,"失败"),
    EXC_ERR(40000,false,"异常或错误");

    @Getter
    private Integer code;
    @Getter
    private Boolean flag;
    @Getter
    private String message;


    ResultCodeEnum(Integer code, Boolean flag, String message) {
        this.code = code;
        this.flag = flag;
        this.message = message;
    }
}

