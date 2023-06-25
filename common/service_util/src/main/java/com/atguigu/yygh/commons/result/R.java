package com.atguigu.yygh.commons.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wldz
 * @version 1.0.0
 * @description TODO
 * @date 23-6-25 20:53
 */

@Data
@ApiModel(description = "统一返回结果类")
public class R {

    @ApiModelProperty(name = "flag",value = "返回结果标识")
    private Boolean flag;
    @ApiModelProperty(name = "code",value = "返回结果状态码")
    private Integer code;
    @ApiModelProperty(name = "message",value = "返回结果描述信息")
    private String message;
    @ApiModelProperty(name = "data",value = "返回结果数据信息")
    private Map<String, Object> data;

    //构造私有化
    private R(){}

    public static R suc(){
        R r = new R();
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setFlag(ResultCodeEnum.SUCCESS.getFlag());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    public static R fail(){
        R r = new R();
        r.setCode(ResultCodeEnum.FAILURE.getCode());
        r.setFlag(ResultCodeEnum.FAILURE.getFlag());
        r.setMessage(ResultCodeEnum.FAILURE.getMessage());
        return r;
    }

    public static R exc_err(){
        R r = new R();
        r.setCode(ResultCodeEnum.EXC_ERR.getCode());
        r.setFlag(ResultCodeEnum.EXC_ERR.getFlag());
        r.setMessage(ResultCodeEnum.EXC_ERR.getMessage());
        return r;
    }

    public R flag(Boolean flag){
        this.setFlag(flag);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R data(Map<String,Object> map){
        this.setData(map);
        return this;
    }

    public R data(String str, Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put(str, obj);
        return data(map);
    }
}

