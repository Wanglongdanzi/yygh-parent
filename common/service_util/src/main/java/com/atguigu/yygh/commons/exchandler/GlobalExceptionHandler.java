package com.atguigu.yygh.commons.exchandler;

import com.atguigu.yygh.commons.exchandler.exc.NullValueException;
import com.atguigu.yygh.commons.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Wldz
 * @version 1.0.0
 * @description TODO 统一异常处理类
 * @date 23-6-26 19:20
 */
//@RestControllerAdvice等同于@ControllerAdvice + @ResponseBody
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R handler(ArithmeticException e){
        e.printStackTrace();
        return R.exc_err().message("算术异常");
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public R handler(NullPointerException e){
        e.printStackTrace();
        return R.exc_err().message("空指针异常");
    }

    /**
     * @description: 通用异常,异常采用深度排序原则
     * @author: Wldz
     * @param: [e]
     * @return: com.atguigu.yygh.commons.result.R
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R handler(Exception e){
        e.printStackTrace();
        return R.exc_err();
    }

    /**
     * @description: 自定义空值异常,用于捕获特定情况信息
     * @author: Wldz
     * @param: [e]
     * @return: com.atguigu.yygh.commons.result.R
     **/
    @ExceptionHandler(NullValueException.class)
    @ResponseBody
    public R handler(NullValueException e){
        e.printStackTrace();
//        log.debug("测试DEBUG级别日志输出");
//        log.info("测试INFO级别日志输出");
//        log.warn("测试WARN级别日志输出");
//        log.error("测试ERROR级别日志输出");
        log.error(e.getMsg());
        return R.exc_err().message(e.getMsg()).code(e.getCode());
    }
}

