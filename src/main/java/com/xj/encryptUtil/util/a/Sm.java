//package com.xj.encryptUtil.util.a;
//
//import org.apache.commons.codec.binary.Hex;
//import org.bouncycastle.crypto.InvalidCipherTextException;
//import org.bouncycastle.crypto.engines.SM2Engine;
//import org.bouncycastle.crypto.params.ECDomainParameters;
//import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
//import org.bouncycastle.crypto.params.ECPublicKeyParameters;
//import org.bouncycastle.crypto.params.ParametersWithRandom;
//import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;
//import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//import org.bouncycastle.jce.spec.ECParameterSpec;
//
//import java.security.*;
//import java.security.spec.ECGenParameterSpec;
//import java.security.spec.InvalidKeySpecException;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//import java.util.Base64;
//
///**
// * @ClassName Sm
// * @Description TODO
// * @Autohr xj
// * @Date 2020/12/16 10:32 上午
// */
//public class Sm {
//    public static void main(String[] args) throws Exception {
////        KeyPair keyPair = grantKey();
////        PrivateKey privateKey = keyPair.getPrivate();
////        PublicKey publicKey = keyPair.getPublic();
////        ECPoint pubKeyPointQ = ((BCECPublicKey) publicKey).getQ();
////        String sm2PubKey = "04" + pubKeyPointQ.getXCoord().toString() + pubKeyPointQ.getYCoord().toString();
////        System.out.println("sm2PUBKEY:"+sm2PubKey);
////        System.out.println("PUBKEY:" + Hex.encodeHexString(publicKey.getEncoded()));
////        System.out.println("publicKey:" + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
////        System.out.println();
////        System.out.println("PRIKEY:" + Hex.encodeHexString(privateKey.getEncoded()));
////        System.out.println("privateKey:" + Base64.getEncoder().encodeToString((privateKey.getEncoded())));
//
//        String pubkey = "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEIl7ttZoiikZDGtuw96fn+r85gFxYDDdvVzNuAHdnIWMUsYv5HeVbaQmg86to7ux/LBEKQ+TOGIAS5/blp+j5vQ==";
//        System.out.println("PUBKEY:" + Hex.encodeHexString(Base64.getDecoder().decode(pubkey)));
//        String priKey = "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgzTTBDtDZSJ3xW5is5uIcNWKuohKlvwJV/Z6VicWzyfSgCgYIKoEcz1UBgi2hRANCAAQiXu21miKKRkMa27D3p+f6vzmAXFgMN29XM24Ad2chYxSxi/kd5VtpCaDzq2ju7H8sEQpD5M4YgBLn9uWn6Pm9";
//        System.out.println("PRIKEY:" + Hex.encodeHexString(Base64.getDecoder().decode(priKey)));
//        PrivateKey privateKey = loadPrivateKey(priKey);
//        PublicKey publicKey = loadPublicKey(pubkey);
//
//        String data = "你好中国";
//        String en = encrypt(data, publicKey);
//        System.out.println("加密后数据：" + en);
////        en = Base64.getEncoder().encodeToString(Hex.decodeHex("04D5F6D5CB2EA7353E6B72CFFCDAE14D61C14F04FD47BA4D358F38D83DA5835D6B50445E179DCF63FA58FEE2FD825E73DC5679B62B5BE1E6C7D95478B90B6983FCAA89B560BB74AB4D9926B8B9C3A279DF6214431453B9FB40469ACB74FD0CBF8876624C"));
//        String nd = decrypt(en, privateKey);
//        System.out.println("解密后的数据：" + nd);
//
//    }
//
//
//    public static String encrypt(String data, PublicKey publicKey) {
//
//        ECPublicKeyParameters localECPublicKeyParameters = null;
//
//        if (publicKey instanceof BCECPublicKey) {
//            BCECPublicKey bcecPublicKey = (BCECPublicKey) publicKey;
//            ECParameterSpec ecParameterSpec = bcecPublicKey.getParameters();
//            ECDomainParameters ecDomainParameters = new ECDomainParameters(
//                    ecParameterSpec.getCurve(), ecParameterSpec.getG(),
//                    ecParameterSpec.getN());
//            localECPublicKeyParameters = new ECPublicKeyParameters(bcecPublicKey.getQ(),
//                    ecDomainParameters);
//        }
//        SM2Engine localSM2Engine = new SM2Engine();
//        localSM2Engine.init(true, new ParametersWithRandom(localECPublicKeyParameters,
//                new SecureRandom()));
//        byte[] arrayOfByte2;
//        try {
//            arrayOfByte2 = localSM2Engine.processBlock(data.getBytes(), 0, data.getBytes().length);
//            return Base64.getEncoder().encodeToString(arrayOfByte2);
//        } catch (InvalidCipherTextException e) {
//
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//
//    public static String decrypt(String encodedata, PrivateKey privateKey) {
//        byte[] encodedataByte = Base64.getDecoder().decode(encodedata.getBytes());
//        SM2Engine sm2Engine = new SM2Engine();
//        BCECPrivateKey sm2PriK = (BCECPrivateKey) privateKey;
//        ECParameterSpec ecParameterSpec = sm2PriK.getParameters();
//        ECDomainParameters ecDomainParameters = new ECDomainParameters(
//                ecParameterSpec.getCurve(), ecParameterSpec.getG(),
//                ecParameterSpec.getN());
//        ECPrivateKeyParameters localECPrivateKeyParameters = new ECPrivateKeyParameters(
//                sm2PriK.getD(), ecDomainParameters);
//        sm2Engine.init(false, localECPrivateKeyParameters);
//        try {
//            byte[] arrayOfByte3 = sm2Engine.processBlock(encodedataByte, 0,
//                    encodedataByte.length);
//            return new String(arrayOfByte3);
//        } catch (InvalidCipherTextException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//
//    /**
//     * 从字符串加载公钥
//     *
//     * @param keyStr
//     * @return
//     * @throws InvalidKeySpecException
//     * @throws NoSuchAlgorithmException
//     */
//    public static PublicKey loadPublicKey(String keyStr) throws InvalidKeySpecException, NoSuchAlgorithmException {
//        keyStr = keyStr.replace(" ", "");
//        BouncyCastleProvider bc = new BouncyCastleProvider();
//        X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(Base64.getDecoder().decode(keyStr));
//        KeyFactory keyFactory = KeyFactory.getInstance("EC", bc);
//        PublicKey publicKey = keyFactory.generatePublic(pubX509);
//        return publicKey;
//    }
//
//    /**
//     * 从字符串中加载私钥
//     *
//     * @param keyStr
//     * @return
//     * @throws NoSuchAlgorithmException
//     * @throws InvalidKeySpecException
//     */
//    public static PrivateKey loadPrivateKey(String keyStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
//        keyStr = keyStr.replace(" ", "");
//        BouncyCastleProvider bc = new BouncyCastleProvider();
//        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(keyStr));
//        KeyFactory keyFactory = KeyFactory.getInstance("EC", bc);
//        PrivateKey privateKey = keyFactory.generatePrivate(priPKCS8);
////        log.info(keyFactory.getKeySpec(privateKey, RSAPrivateCrtKeySpec.class).getModulus().toString(2).length()+"");
//        return privateKey;
//    }
//
//    public static KeyPair grantKey() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException {
//        // 获取SM2椭圆曲线的参数
//        ECGenParameterSpec sm2Spec = new ECGenParameterSpec("sm2p256v1");
//
//        // 获取一个椭圆曲线类型的密钥对生成器
//        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", new BouncyCastleProvider());
//        // 使用SM2参数初始化生成器
//        kpg.initialize(sm2Spec);
//        // 使用SM2的算法区域初始化密钥生成器
//        kpg.initialize(sm2Spec, new SecureRandom());
//        // 获取密钥对
//        KeyPair keyPair = kpg.generateKeyPair();
//        return keyPair;
//    }
//}
