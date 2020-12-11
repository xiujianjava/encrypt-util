/**
 * @Author xj
 * @Description 3DES（即Triple DES）是DES向AES过渡的加密算法，它使用3条56位的密钥对数据进行三次加密。是DES的一个更安全的变形。它以DES为基本模块，通过组合分组方法设计出分组加密算法。比起最初的DES，3DES更为安全。
 *
 * 3DES使用对称密钥进行加解密
 * 密钥长度16字节128位
 *
 * 理论上3Des密钥长度位24字节  分三组 每组8字节 实际使用中 通常k3使用k1替代
 *
 * 3DES加密过程为：C=Ek3(Dk2(Ek1(P)))
 * 3DES解密过程为：P=Dk1(EK2(Dk3(C)))
 * @Date 10:48 上午 2020/12/11
 */
package com.xj.encryptUtil.encrypt.DES.TripleDES;
class TripleDESConst{
    static final String ALGORITHM_TRIPLE_DES="DESede";
    static final String CIPHER_ALGORITHM_TRIPLE_DES="DESede/ECB/NoPadding";
}