/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.sangmu.validator.bean;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author wb-lcw229616
 * @version $Id: ParentInfo.java, v 0.1 2018年04月11日 12:49 wb-lcw229616 Exp $
 */
public class ParentInfo {
    @NotBlank(message="父亲名称不能为空")
    private String fatherName;

    @NotBlank(message="母亲名称不能为空")
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