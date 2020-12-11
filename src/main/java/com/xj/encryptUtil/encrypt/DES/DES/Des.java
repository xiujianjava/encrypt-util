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
 * @ClassName Des
 * @Description Des加解密工具
 * @Autohr xj
 * @Date 2020/12/11 2:29 下午
 * @Version 1.0
 */
public class Des {
    private static Logger logger = LoggerFactory.getLogger(Des.class);
    private static final String ALGORITHM = "DES";
    private static final String CIPHER_ALGORITHM_NOPADDING = "DES/CBC/NoPadding";

    public static byte[] encryption(byte[] key, byte[] src) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = null;
        try {
            cipher = getDesCipher(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(src);
        } catch (InvalidKeySpecException e) {
            throw e;
        } catch (NoSuchAlgorithmException e) {
            throw e;
        } catch (NoSuchPaddingException e) {
            throw e;
        } catch (InvalidKeyException e) {
            throw e;
        } catch (BadPaddingException e) {
            throw e;
        } catch (IllegalBlockSizeException e) {
            throw e;
        }
    }

    public byte[] decryption(byte[] key, byte[] src) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = null;
        try {
            cipher = getDesCipher(Cipher.DECRYPT_MODE, key);
            return cipher.doFinal(src);
        } catch (InvalidKeySpecException e) {
            throw e;
        } catch (NoSuchAlgorithmException e) {
            throw e;
        } catch (NoSuchPaddingException e) {
            throw e;
        } catch (InvalidKeyException e) {
            throw e;
        } catch (BadPaddingException e) {
            throw e;
        } catch (IllegalBlockSizeException e) {
            throw e;
        }
    }

    private static Cipher getDesCipher(int type, byte[] key) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        SecureRandom secureRandom = new SecureRandom();
        try {
            DESKeySpec desKeySpec = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DesConst.ALGORITHM_DES);
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            Cipher cipher = Cipher.getInstance(DesConst.CIPHER_ALGORITHM_DES);
            cipher.init(type, secretKey, secureRandom);
            return cipher;
        } catch (InvalidKeyException e) {
            throw e;
        } catch (NoSuchPaddingException e) {
            throw e;
        } catch (NoSuchAlgorithmException e) {
            throw e;
        } catch (InvalidKeySpecException e) {
            throw e;
        }
    }


    public static void main(String[] args) {
        try {
            Des.encryption(new byte[8], new byte[2]);
        } catch (Exception e) {

        }
    }
}
