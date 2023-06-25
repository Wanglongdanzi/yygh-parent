package com.atguigu.yygh.commons.result;


import lombok.Getter;

/**
 * @author Wldz
 * @version 1.0.0
 * @description TODO
 * @date 23-6-25 20:41
 */
public enum ResultCodeEnum {

    SUCCESS(20000,true),
    FAILURE(40000,false);

    @Getter
    private Integer code;
    @Getter
    private Boolean flag;

    ResultCodeEnum(Integer code, Boolean flag) {
        this.code = code;
        this.flag = flag;
    }


}

