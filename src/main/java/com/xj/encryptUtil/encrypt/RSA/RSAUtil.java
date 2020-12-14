package com.xj.encryptUtil.encrypt.RSA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @ClassName RSAKeyUtil
 * @Description TODO
 * @Autohr xj
 * @Date 2020/12/14 11:44 上午
 */
public class RSAUtil {
    private static Logger log = LoggerFactory.getLogger(RSAUtil.class);

    /**
     * 生成keyPair对象
     *
     * @param keySize 密钥长度
     * @return KeyPair
     * @throws NoSuchAlgorithmException
     * @Date 2020/12/14 6:06 下午
     * @author: xj
     */
    public static KeyPair createRSAkey(int keySize) throws NoSuchAlgorithmException {
        /** RSA算法要求有一个可信任的随机数源 */
        SecureRandom secureRandom = new SecureRandom();
        /** 为RSA算法创建一个KeyPairGenerator对象 */
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSAConst.ALGORITHM);
        /** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
        keyPairGenerator.initialize(keySize, secureRandom);
        /** 生成密匙对 */
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        return keyPair;
    }

    /**
     * 从KeyPair中提取私钥
     *
     * @param keyPair
     * @return
     * @Date 2020/12/14 6:07 下午
     * @author: xj
     */
    public static String getPrivateKey(KeyPair keyPair) {

        /** 得到私钥 */
        Key privateKey = keyPair.getPrivate();
        byte[] privateKeyBytes = privateKey.getEncoded();
        String privateKeyBase64 = new String(Base64.getEncoder().encode(privateKeyBytes));

        return privateKeyBase64;
    }

    /**
     * 从KeyPair中提取公钥
     *
     * @param keyPair
     * @return
     * @Date 2020/12/14 6:07 下午
     * @author: xj
     */
    public static String getPublicKey(KeyPair keyPair) {

        /** 得到公钥 */
        Key publicKey = keyPair.getPublic();
        byte[] publicKeyBytes = publicKey.getEncoded();
        String publicKeyBase64 = new String(Base64.getEncoder().encode(publicKeyBytes));

        return publicKeyBase64;
    }

    /**
     * 从字符串加载公钥
     *
     * @param keyStr
     * @return
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    public static PublicKey loadPublicKey(String keyStr) throws InvalidKeySpecException, NoSuchAlgorithmException {
        keyStr = keyStr.replace(" ", "");
        X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(Base64.getDecoder().decode(keyStr));
        KeyFactory keyFactory = KeyFactory.getInstance(RSAConst.ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(pubX509);
        return publicKey;
    }

    /**
     * 从字符串中加载私钥
     *
     * @param keyStr
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static PrivateKey loadPrivateKey(String keyStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        keyStr = keyStr.replace(" ", "");
        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(keyStr));
        KeyFactory keyFactory = KeyFactory.getInstance(RSAConst.ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(priPKCS8);
//        log.info(keyFactory.getKeySpec(privateKey, RSAPrivateCrtKeySpec.class).getModulus().toString(2).length()+"");
        return privateKey;
    }
}
