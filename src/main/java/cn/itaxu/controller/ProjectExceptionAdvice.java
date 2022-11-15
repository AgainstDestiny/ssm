package cn.itaxu.controller;

import cn.itaxu.exception.BusinessException;
import cn.itaxu.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description: cn.itaxu.controller
 * @author: Axu
 * @date:2022/11/14 10:03
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        // 记录日志
        // 发送消息给运维
        // 发送消息给开发人员,ex对象发送给开发人员
        return new Result(ex.getCode(),"null","系统异常");
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){
        return new Result(ex.getCode(),"null","业务异常");
    }


    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex){
        // 记录日志
        // 发送消息给运维
        // 发送消息给开发人员,ex对象发送给开发人员
        return new Result(Code.SYSTEM_UNKNOW_ERR,"null","系统繁忙,请稍后再试!");
    }
}
