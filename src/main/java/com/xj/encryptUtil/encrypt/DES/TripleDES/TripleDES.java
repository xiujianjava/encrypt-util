package com.xj.encryptUtil.encrypt.DES.TripleDES;

import com.xj.encryptUtil.encrypt.DES.DES.Des;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @ClassName TripleDES
 * @Description TODO
 * @Autohr xj
 * @Date 2020/12/11 5:22 下午
 * @Version 1.0
 */
public class TripleDES {
    private static Logger logger = LoggerFactory.getLogger(Des.class);

    public static byte[] encryption(byte[] key, byte[] src) {
        return null;
    }

    private static Cipher getKey(int type, byte[] key) {
        try {
            DESKeySpec desKeySpec = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(TripleDESConst.ALGORITHM_TRIPLE_DES);
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            Cipher cipher = Cipher.getInstance(TripleDESConst.CIPHER_ALGORITHM_TRIPLE_DES);
            cipher.init(type, secretKey);
            return cipher;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
