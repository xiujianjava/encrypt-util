package com.xj.encryptUtil.encrypt.AES;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @ClassName AESUtil
 * @Description TODO
 * @Autohr xj
 * @Date 2020/12/14 9:51 上午
 * @Version 1.0
 */
public class AESUtil {
    private static Logger logger = LoggerFactory.getLogger(AESUtil.class);

    public static String createKeyBase64(int keyLen) throws NoSuchAlgorithmException {
        String keyStr = Base64.getEncoder().encodeToString(createKey(keyLen).getEncoded());
        return keyStr;
    }

    public static Key createKey(int keyLen) throws NoSuchAlgorithmException {
        try {
            // 生成key
            //构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keyGenerator = KeyGenerator.getInstance(AesConst.ALGORITHM_AES);
            //生成一个128位的随机源,根据传入的字节数组
            keyGenerator.init(keyLen);
            //产生原始对称密钥
            SecretKey secretKey = keyGenerator.generateKey();
            //获得原始对称密钥的字节数组
            byte[] keyBytes = secretKey.getEncoded();
            // key转换,根据字节数组生成AES密钥
            Key key = new SecretKeySpec(keyBytes, AesConst.ALGORITHM_AES);
            return key;
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }
    }

}
