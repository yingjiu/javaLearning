/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.sangmu.validator;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.sangmu.validator.ValidateGroups.GroupV1;
import com.sangmu.validator.bean.ParentInfo;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author wb-lcw229616
 * @version $Id: ValidatorBean.java, v 0.1 2018��04��11�� 11:26 wb-lcw229616 Exp $
 * �������Ե�У����
 */
public class ValidatorBean {
    @NotEmpty(message = "ҵ��code����Ϊ��", groups = { GroupV1.class })
    @Length(min=5,max = 256, message = "ҵ��code���Ϊ256���ַ�", groups = { GroupV1.class })
    private String            code;

    @Money(message="����ʽ����ȷ", groups = { GroupV1.class })
    private Double money;

    @NotNull(message="��ĸ��Ϣ����Ϊ��")
    @Valid
    private ParentInfo parentInfo;

    @NotNull(message="��ĸ��Ϣ����Ϊ��")
    @Valid
    private List<ParentInfo> parentInfos;

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code </tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>money</tt>.
     *
     * @return property value of money
     */
    public Double getMoney() {
        return money;
    }

    /**
     * Setter method for property <tt>money </tt>.
     *
     * @param money value to be assigned to property money
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * Getter method for property <tt>parentInfo</tt>.
     *
     * @return property value of parentInfo
     */
    public ParentInfo getParentInfo() {
        return parentInfo;
    }

    /**
     * Setter method for property <tt>parentInfo </tt>.
     *
     * @param parentInfo value to be assigned to property parentInfo
     */
    public void setParentInfo(ParentInfo parentInfo) {
        this.parentInfo = parentInfo;
    }

    /**
     * Getter method for property <tt>parentInfos</tt>.
     *
     * @return property value of parentInfos
     */
    public List<ParentInfo> getParentInfos() {
        return parentInfos;
    }

    /**
     * Setter method for property <tt>parentInfos </tt>.
     *
     * @param parentInfos value to be assigned to property parentInfos
     */
    public void setParentInfos(List<ParentInfo> parentInfos) {
        this.parentInfos = parentInfos;
    }
}