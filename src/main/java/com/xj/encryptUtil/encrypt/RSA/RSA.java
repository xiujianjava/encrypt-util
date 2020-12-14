package com.xj.encryptUtil.encrypt.RSA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

/**
 * @ClassName RSA
 * @Description TODO
 * @Autohr xj
 * @Date 2020/12/14 11:21 上午
 */
public class RSA {
    private static Logger log = LoggerFactory.getLogger(RSA.class);

    /**
     * RSA 加密
     *
     * @param publicKey PublicKey 公钥对象
     * @param src byte[] 待加密数据
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws IOException
     * @Date 2020/12/14 6:04 下午
     * @author: xj
     */
    public static byte[] encrypt(PublicKey publicKey, byte[] src) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(RSAConst.ALGORITHM);
        RSAPublicKeySpec rsaPublicKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
        int keyLength = rsaPublicKeySpec.getModulus().toString(2).length();

        int keyByteSize = keyLength / 8;
        int encryptBlockSize = keyByteSize - RSAConst.RESERVESIZE;
        int nBlock = src.length / encryptBlockSize;
        if ((src.length % encryptBlockSize) != 0) {
            nBlock += 1;
        }
        ByteArrayOutputStream outbuf = null;
        try {
            Cipher cipher = Cipher.getInstance(RSAConst.CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            outbuf = new ByteArrayOutputStream(nBlock * keyByteSize);

            for (int offset = 0; offset < src.length; offset += encryptBlockSize) {
                int inputLen = src.length - offset;
                if (inputLen > encryptBlockSize) {
                    inputLen = encryptBlockSize;
                }
                byte[] encryptedBlock = cipher.doFinal(src, offset, inputLen);
                outbuf.write(encryptedBlock);
            }
            outbuf.flush();
            return outbuf.toByteArray();
        } finally {
            try {
                if (outbuf != null) {
                    outbuf.close();
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * RSA解密
     *
     * @param privateKey PrivateKey 私钥对象
     * @param src byte[] 待解密数据
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws IOException
     * @throws InvalidKeySpecException
     * @Date 2020/12/14 6:04 下午
     * @author: xj
     */
    public static byte[] decrypt(PrivateKey privateKey, byte[] src) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(RSAConst.ALGORITHM);
        RSAPrivateKeySpec rsaPrivateKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);
        int keyLength = rsaPrivateKeySpec.getModulus().toString(2).length();

        int keyByteSize = keyLength / 8;
        int blockSize = keyByteSize - RSAConst.RESERVESIZE;
        int nBlock = src.length / keyByteSize;
        ByteArrayOutputStream outbuf = null;
        try {
            Cipher cipher = Cipher.getInstance(RSAConst.CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            outbuf = new ByteArrayOutputStream(nBlock * blockSize);
            for (int offset = 0; offset < src.length; offset += keyByteSize) {
                int inputLen = src.length - offset;
                if (inputLen > keyByteSize) {
                    inputLen = keyByteSize;
                }
                byte[] decryptedBlock = cipher.doFinal(src, offset, inputLen);
                outbuf.write(decryptedBlock);
            }
            outbuf.flush();
            return outbuf.toByteArray();
        } finally {
            try {
                if (outbuf != null) {
                    outbuf.close();
                }
            } catch (Exception e) {
            }
        }
    }

}
