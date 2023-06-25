package com.atguigu.yygh.commons.exchandler.exc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wldz
 * @version 1.0.0
 * @description TODO 自定义判空异常
 * @date 23-6-26 19:47
 */
@ApiModel(description = "自定义判空异常")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NullValueException extends RuntimeException{

    @ApiModelProperty(name = "code",value = "异常状态码")
    private Integer code;
    @ApiModelProperty(name = "msg",value = "异常状态信息")
    private String msg;


}

