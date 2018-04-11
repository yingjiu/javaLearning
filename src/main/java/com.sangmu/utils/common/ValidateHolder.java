/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.sangmu.utils.common;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.sangmu.utils.exception.BizException;
import com.sangmu.utils.exception.ResultCodeEnum;

/**
 *  校验器- 应用JSR-303规范 对请求入参进行校验
 * @author qiulin.ql
 * @version $Id: ValidateHolder.java, v 0.1 2015-1-17 下午3:01:16 qiulin.ql Exp $
 */
public class ValidateHolder {

    /**
     *  应用JSR-303规范验证参数，抛出无效的入参异常(存放验证结果信息)
     * @param object 需要验证的对象
     * @param sceneStr 场景描述
     * @param groups 需要验证的组信息
     * @throws BizException
     */
    public static <T> void validate(T object, String sceneStr, Class<?>... groups)
                                                                                  throws BizException {
        // >>. 判断不能为空
        if (null == object) {
            throw new BizException(ResultCodeEnum.PARAMETER_IS_NULL, new StringBuilder(sceneStr)
                .append(",入参为空，校验失败").toString());
        }

        // >>.使用javax Validation
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<T>> validateResult = validator.validate(object,
            groups == null ? new Class[] {} : groups);

        // >>.如果返回不为空则存在错误
        if (null != validateResult && !validateResult.isEmpty()) {
            String errorMsg = validatePropertyDetailAndErrorMsg(validateResult);
            throw new BizException(ResultCodeEnum.PARAMETER_IS_ILLEGAL, new StringBuilder(sceneStr)
                .append(",入参校验失败:").append(errorMsg).toString());
        }
    }

    /**
     *  验证对象明细并且把错误信息返回给调用方(返回的错误信息中存在验证Bean的字段名称)
     * @param vals 相关错误的集合信息
     * @return 错误信息
     */
    private static String validatePropertyDetailAndErrorMsg(Set<?> vals) {
        StringBuilder result = new StringBuilder();
        for (Object violation : vals) {
            if (!(violation instanceof ConstraintViolation)) {
                continue;
            }
            result.append(((ConstraintViolation<?>) violation).getPropertyPath().toString());
            result.append(":");
            result.append(((ConstraintViolation<?>) violation).getMessage());
            result.append(",");
        }
        return "[" + result.substring(0, result.length() - 1) + "]";
    }

}
