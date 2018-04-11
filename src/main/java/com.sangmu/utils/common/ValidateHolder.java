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
 *  У����- Ӧ��JSR-303�淶 ��������ν���У��
 * @author qiulin.ql
 * @version $Id: ValidateHolder.java, v 0.1 2015-1-17 ����3:01:16 qiulin.ql Exp $
 */
public class ValidateHolder {

    /**
     *  Ӧ��JSR-303�淶��֤�������׳���Ч������쳣(�����֤�����Ϣ)
     * @param object ��Ҫ��֤�Ķ���
     * @param sceneStr ��������
     * @param groups ��Ҫ��֤������Ϣ
     * @throws BizException
     */
    public static <T> void validate(T object, String sceneStr, Class<?>... groups)
                                                                                  throws BizException {
        // >>. �жϲ���Ϊ��
        if (null == object) {
            throw new BizException(ResultCodeEnum.PARAMETER_IS_NULL, new StringBuilder(sceneStr)
                .append(",���Ϊ�գ�У��ʧ��").toString());
        }

        // >>.ʹ��javax Validation
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<T>> validateResult = validator.validate(object,
            groups == null ? new Class[] {} : groups);

        // >>.������ز�Ϊ������ڴ���
        if (null != validateResult && !validateResult.isEmpty()) {
            String errorMsg = validatePropertyDetailAndErrorMsg(validateResult);
            throw new BizException(ResultCodeEnum.PARAMETER_IS_ILLEGAL, new StringBuilder(sceneStr)
                .append(",���У��ʧ��:").append(errorMsg).toString());
        }
    }

    /**
     *  ��֤������ϸ���ҰѴ�����Ϣ���ظ����÷�(���صĴ�����Ϣ�д�����֤Bean���ֶ�����)
     * @param vals ��ش���ļ�����Ϣ
     * @return ������Ϣ
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
