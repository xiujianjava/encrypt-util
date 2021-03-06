package com.xj.encryptUtil.encrypt.DES.DES;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * @ClassName DES
 * @Description DES加解密工具
 * @Autohr xj
 * @Date 2020/12/11 2:29 下午
 */
public class DES {
    private static Logger logger = LoggerFactory.getLogger(DES.class);

    public static byte[] encrypt(byte[] key, byte[] src) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = getDesCipher(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(src);

    }

    public static byte[] decrypt(byte[] key, byte[] src) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = getDesCipher(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(src);
    }

    private static Cipher getDesCipher(int type, byte[] key) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        SecureRandom secureRandom = new SecureRandom();
        DESKeySpec desKeySpec = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DesConst.ALGORITHM_DES);
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        Cipher cipher = Cipher.getInstance(DesConst.CIPHER_ALGORITHM_DES);
        cipher.init(type, secretKey, secureRandom);
        return cipher;
    }
}
