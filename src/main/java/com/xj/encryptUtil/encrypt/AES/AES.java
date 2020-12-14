package com.xj.encryptUtil.encrypt.AES;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

/**
 * @ClassName AES
 * @Description TODO
 * @Autohr xj
 * @Date 2020/12/14 9:51 上午
 */
public class AES {

    private static Logger logger = LoggerFactory.getLogger(AES.class);

    /**
     * AES解密(明文数据转码字符集默认UT-8)
     *
     * @param key String aes密钥（Base64加密）
     * @param src String 待解密数据（Base64加密）
     * @return String 解密后字符串
     * @throws UnsupportedEncodingException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     * @Date 2020/12/14 11:02 上午
     * @author: xj
     */
    public static String decrypt(String key, String src) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        return decrypt(key, src, AesConst.CHARSET);
    }

    /**
     * AES解密
     *
     * @param key String aes密钥（Base64加密）
     * @param src String 待解密数据（Base64加密）
     * @param charSet 明文数据转码字符集
     * @return String 解密后字符串
     * @throws UnsupportedEncodingException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     * @Date 2020/12/14 11:02 上午
     * @author: xj
     */
    public static String decrypt(String key, String src, String charSet) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] keyByte = Base64.getDecoder().decode(key);
        byte[] srcByte = Base64.getDecoder().decode(src);
        byte[] result = decrypt(keyByte, srcByte);
        return new String(result, charSet);
    }

    /**
     * AES 加密（默认data转码字符集为UTF-8）
     *
     * @param key String aes密钥（Base64加密）
     * @param src String 待加密数据 明文字符串
     * @return String 加密后字符串（Base64加密过）
     * @throws UnsupportedEncodingException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     * @Date 2020/12/14 11:04 上午
     * @author: xj
     */
    public static String encrypt(String key, String src) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        return encrypt(key, src, AesConst.CHARSET);
    }

    /**
     * AES 加密
     *
     * @param key String aes密钥（Base64加密）
     * @param src String 待加密数据 明文字符串
     * @param charSet String data转码字符集
     * @return String 加密后字符串（Base64加密过）
     * @throws UnsupportedEncodingException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     * @Date 2020/12/14 11:05 上午
     * @author: xj
     */
    public static String encrypt(String key, String src, String charSet) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] keyByte = Base64.getDecoder().decode(key);
        byte[] srcByte = src.getBytes(charSet);
        byte[] result = encrypt(keyByte, srcByte);
        return Base64.getEncoder().encodeToString(result);
    }

    /**
     * AES 加密
     *
     * @param key byte[] 密钥
     * @param src byte[] 待加密数据
     * @return byte[] 加密数据
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @Date 2020/12/14 11:07 上午
     * @author: xj
     */
    public static byte[] encrypt(byte[] key, byte[] src) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = getDesCipher(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(src);

    }

    /**
     * AES 解密
     *
     * @param key byte[] 密钥
     * @param src byte[] 待加密数据
     * @return byte[] 解密数据
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @Date 2020/12/14 11:10 上午
     * @author: xj
     */
    public static byte[] decrypt(byte[] key, byte[] src) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = getDesCipher(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(src);
    }

    private static Cipher getDesCipher(int type, byte[] key) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        SecretKey secretKey = new SecretKeySpec(key, AesConst.ALGORITHM_AES);
        Cipher cipher = Cipher.getInstance(AesConst.CIPHER_ALGORITHM_AES);
        cipher.init(type, secretKey);
        return cipher;
    }

}
