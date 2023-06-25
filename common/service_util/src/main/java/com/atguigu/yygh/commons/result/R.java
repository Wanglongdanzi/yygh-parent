package com.atguigu.yygh.commons.result;

import lombok.Data;

import java.util.Map;

/**
 * @author Wldz
 * @version 1.0.0
 * @description TODO
 * @date 23-6-25 20:53
 */
@Data
public class R {

    private Boolean flag;

    private Integer code;

    private String message;

    private Map<String, Object> data;

    //构造私有化
    private R(){}

    public static R ok(){
        R r = new R();
        r.setCode(20000);
        r.setFlag(true);
        r.setMessage("成功");
        return r;
    }

    public static R err(){
        R r = new R();
        r.setCode(40000);
        r.setFlag(false);
        r.setMessage("失败");
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

}

