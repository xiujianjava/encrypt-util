package com.xj.encryptUtil.encrypt.DES;

import com.xj.encryptUtil.util.CodeUtl;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * @ClassName KeyUtil
 * @Description TODO
 * @Autohr xj
 * @Date 2020/12/11 4:57 下午
 * @Version 1.0
 */
public class DesUtil {
    private static final String ALGORITHM = "DES";

    //生成一个DES密钥
    public static String createKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(56);//des 7位*8字节  3des 双倍
            // 生成一个Key
            SecretKey generateKey = keyGenerator.generateKey();
            // 转变为字节数组
            byte[] encoded = generateKey.getEncoded();
            // 生成密钥字符串
            String encodeHexString = CodeUtl.byteArray2HexStr(encoded);
//            String encodeHexString=Hex.encodeHexString(encoded);//使用三方包的转换工具
            return encodeHexString;
        } catch (Exception e) {
            e.printStackTrace();
            return "密钥生成错误.";
        }
    }

    public static void main(String[] args) throws Exception {
        String key = createKey();
        System.out.printf(key);
    }
}