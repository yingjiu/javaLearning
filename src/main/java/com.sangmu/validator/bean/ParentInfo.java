/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.sangmu.validator.bean;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author wb-lcw229616
 * @version $Id: ParentInfo.java, v 0.1 2018��04��11�� 12:49 wb-lcw229616 Exp $
 */
public class ParentInfo {
    @NotBlank(message="�������Ʋ���Ϊ��")
    private String fatherName;

    @NotBlank(message="ĸ�����Ʋ���Ϊ��")
    private String motherName;

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }
}