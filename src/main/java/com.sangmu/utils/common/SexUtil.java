package com.sangmu.utils.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * �ж��Ա𹤾���
 * @author qiulin.ql
 * @version $Id: SexUtil.java, v 0.1 2015��7��30�� ����3:57:50 qiulin.ql Exp $
 */
public class SexUtil {

    /** ��־ */
    private static final Logger LOGGER = LoggerFactory.getLogger(SexUtil.class);

    /**
     * �������֤���������Ա�,�������֤�����ڶ�λʶ��
     * @param certiNo ���֤����
     * @return ����m/f��ʶ����/Ů�ԣ����û�й��򷵻�N
     */
    public static String divisonByCertiNo(String certiNo) {
        String sex = "N";

        try {
            if (StringUtil.isNotEmpty(certiNo)
                && (certiNo.length() == 15 || certiNo.length() == 18)) {
                String lastValue = certiNo.substring(certiNo.length() - 2, certiNo.length() - 1);
                sex = Integer.parseInt(lastValue) % 2 == 0 ? "f" : "m";
            }
        } catch (Exception e) {

        }
        return sex;
    }

}
