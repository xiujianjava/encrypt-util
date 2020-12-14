package com.xj.encryptUtil.encrypt.DES.TripleDES;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @ClassName TripleDES
 * @Description TODO
 * @Autohr xj
 * @Date 2020/12/11 5:22 下午
 */
public class TripleDES {
    private static Logger logger = LoggerFactory.getLogger(TripleDES.class);

    public static byte[] encrypt(byte[] key, byte[] src) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = getTripleDES(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(src);
    }

    public static byte[] decrypt(byte[] key, byte[] src) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = getTripleDES(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(src);
    }

    private static Cipher getTripleDES(int type, byte[] key) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException {
        DESKeySpec desKeySpec = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(TripleDESConst.ALGORITHM_TRIPLE_DES);
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        Cipher cipher = Cipher.getInstance(TripleDESConst.CIPHER_ALGORITHM_TRIPLE_DES);
        cipher.init(type, secretKey);
        return cipher;

    }
}
