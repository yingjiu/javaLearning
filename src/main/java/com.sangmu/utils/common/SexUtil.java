package com.sangmu.utils.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 判断性别工具类
 * @author qiulin.ql
 * @version $Id: SexUtil.java, v 0.1 2015年7月30日 下午3:57:50 qiulin.ql Exp $
 */
public class SexUtil {

    /** 日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(SexUtil.class);

    /**
     * 根据身份证号码区分性别,根据身份证倒数第二位识别
     * @param certiNo 身份证号码
     * @return 返回m/f标识男性/女性，如果没有规则返回N
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
