package com.xj.encryptUtil.util;

/**
 * @ClassName CodeUtl
 * @Description TODO
 * @Autohr xj
 * @Date 2020/12/11 5:06 下午
 * @Version 1.0
 */
public class CodeUtl {
    public static String byteArray2HexStr(byte[] b) {
        StringBuffer hexStr = new StringBuffer();
        String stmp = "";
        for (int i = 0; i < b.length; i++) {
            stmp = Integer.toHexString(b[i] & 0XFF);
            hexStr.append(stmp.length() == 1 ? "0" + stmp : stmp);
        }
        return hexStr.toString().toUpperCase();
    }
}
