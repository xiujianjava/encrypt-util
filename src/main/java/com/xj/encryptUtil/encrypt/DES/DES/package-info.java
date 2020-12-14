/**
 * @Author xj
 * @Description DES全称为Data Encryption Standard，即数据加密标准
 * DES使用对称密钥进行加解密
 * 密钥长度8字节64位
 * DES算法的入口参数有三个：Key、Data、Mode。其中Key为7个字节共56位，是DES算法的工作密钥；Data为8个字节64位，是要被加密或被解密的数据；Mode为DES的工作方式,有两种:加密或解密。
 * @Date 10:48 上午 2020/12/11
 */
package com.xj.encryptUtil.encrypt.DES.DES;

class DesConst {
    /** 指定算法 */
    static final String ALGORITHM_DES = "DES";
    //
    static final String CIPHER_ALGORITHM_DES = "DES/CBC/NoPadding";
}