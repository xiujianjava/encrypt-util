package com.xj.encryptUtil.encrypt.MD;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName MD5
 * @Description TODO
 * @Autohr xj
 * @Date 2020/12/15 9:52 上午
 */
public class MD5 extends DigestUtils {


    /**
     * MD5摘要
     *
     * @param src 待摘要数据
     * @return
     * @throws NoSuchAlgorithmException
     */
    @Deprecated
    public static String MD5(byte[] src) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(MDConst.ALGORITHM_TRIPLE_MD5);
        byte[] ciphertext = messageDigest.digest(src);
        return Hex.encodeHexString(ciphertext).toUpperCase();
    }



}
