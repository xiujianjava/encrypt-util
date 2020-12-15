package com.xj.encryptUtil.encrypt.SHA;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName SHA
 * @Description SHA摘要算法 由apache-commons-codec提供 不再造轮子
 * @Autohr xj
 * @Date 2020/12/15 9:40 上午
 */
public class SHA extends DigestUtils {
    @Deprecated
    public static byte[] SHA1(byte[] src) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA"); // 此处的sha代表sha1
        byte[] cipherBytes = messageDigest.digest(src);
        return cipherBytes;
    }

}
