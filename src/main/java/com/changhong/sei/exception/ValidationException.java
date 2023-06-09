package com.changhong.sei.exception;

/**
 * <strong>实现功能:</strong>.
 * <p>业务逻辑校验异常，此类异常不会进行常规的logger.error记录，
 * 一般只在前端显示提示用户</p>
 *
 * @author 马超(Vision.Mac)
 * @version 1.0.1 2017/2/8 10:20
 */
public class ValidationException extends BaseRuntimeException {

    private static final long serialVersionUID = -1613416718940821955L;

    public ValidationException(String errorCode, String message) {
        super(errorCode, message);
    }

    public ValidationException(String message) {
        super(message);
    }
}
