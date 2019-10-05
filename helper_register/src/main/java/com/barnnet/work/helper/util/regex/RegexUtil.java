package com.barnnet.work.helper.util.regex;



import com.barnnet.work.helper.util.pattern.PatternClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author barnnet
 * @date 2019/10/1
 */
public class RegexUtil {
    /*private static Pattern */
    public static boolean isPhone(String phone){
        Pattern phonePattern = PatternClass.getPhonePattern();
        Matcher matcher = phonePattern.matcher(phone);
        return matcher.matches();
    }

    public static boolean isEmail(String email){
        Pattern emailPattern = PatternClass.getEmailPattern();
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }
}
