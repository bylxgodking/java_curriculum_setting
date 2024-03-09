package cn.edu.ccst.util;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LuoXinYu
 * @Date: 2024/03/09/16:37
 * @Description:判断字符串是否为空.
 */

public class StringUtil {
    public static Boolean hasLength(String str) {
        return str != null && !"".equals(str.trim());
    }
}

