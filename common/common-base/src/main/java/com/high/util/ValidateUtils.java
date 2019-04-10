package com.high.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: HarlanW
 * @Date: 2019/4/4 0004
 * @Version: 1.0
 */
public final class ValidateUtils {


    private static Pattern phonePattern = Pattern.compile(PatternRegex.PHONE_REGEX);

    private ValidateUtils() {
    }

    /**
     * 校验手机号码
     * @param phone
     * @return
     */
    public static boolean validatePhone(String phone){
        Matcher matcher = getPattern(PatternRegex.PHONE_REGEX).matcher(phone);
        return matcher.matches();
    }

    /**
     * 校验电子邮件
     * @param email
     * @return
     */
    public static boolean validateEmail(String email){
        Matcher matcher = getPattern(PatternRegex.EMAIL_REGEX).matcher(email);
        return matcher.matches();
    }

    private interface PatternRegex{
        /**
         * 手机号码校验规则
         */
        String PHONE_REGEX = "(13\\d|14[5|7]|15\\d|18\\d)\\d{8}";
        /**
         * 电子邮件地址校验规则
         */
        String EMAIL_REGEX = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    }

    /**
     *
     * @param regex
     * @return
     */
    private static Pattern getPattern(String regex){
        return Pattern.compile(regex);
    }

}
