package com.xj.encryptUtil.encrypt.RSA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @ClassName RSASignature
 * @Description TODO
 * @Autohr xj
 * @Date 2020/12/14 5:49 下午
 */
public class RSASignature {
    private static Logger log = LoggerFactory.getLogger(RSASignature.class);

    /**
     * RSA 签名
     *
     * @param privateKey PrivateKey 私钥对象
     * @param src 待加签数据
     * @return
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws SignatureException
     * @Date 2020/12/14 6:07 下午
     * @author: xj
     */
    public static byte[] signature(PrivateKey privateKey, byte[] src) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException {
//        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
//        KeyFactory keyFactory = KeyFactory.getInstance(RSAConst.ALGORITHM);
//        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance(RSAConst.SIGNATURE);
        signature.initSign(privateKey);
        signature.update(src);
        byte[] result = signature.sign();
        return result;
    }

    /**
     * RSA 验证签名
     *
     * @param publicKey PublicKey 公钥对象
     * @param src 待验签数据
     * @param sign 签名
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws InvalidKeyException
     * @throws SignatureException
     * @throws IOException
     * @Date 2020/12/14 6:07 下午
     * @author: xj
     */
    public static boolean verifySignature(PublicKey publicKey, byte[] src, byte[] sign) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException, IOException {
//        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
//        KeyFactory keyFactory = KeyFactory.getInstance(RSAConst.ALGORITHM);
//        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Signature signature = Signature.getInstance(RSAConst.SIGNATURE);
        signature.initVerify(publicKey);
        signature.update(src);
        boolean bool = signature.verify(sign);
        return bool;
    }

 
}
