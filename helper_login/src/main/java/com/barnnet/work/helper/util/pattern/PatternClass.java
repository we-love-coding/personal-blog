package com.barnnet.work.helper.util.pattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author barnnet
 * @date 2019/10/1
 */
public class PatternClass {
    private static Pattern PHONE_PATTERN = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
    private static Pattern EMAIL_PATTERN = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
    public static Pattern getPhonePattern(){
        return PHONE_PATTERN;
    }

    public static Pattern getEmailPattern(){
        return EMAIL_PATTERN;
    }
}
