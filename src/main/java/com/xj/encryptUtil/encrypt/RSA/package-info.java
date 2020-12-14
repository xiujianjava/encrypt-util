/**
 * @Author xj
 * @Description //RSA是1977年由罗纳德·李维斯特（Ron Rivest）、阿迪·萨莫尔（Adi Shamir）和伦纳德·阿德曼（Leonard Adleman）一起提出的。当时他们三人都在麻省理工学院工作。RSA就是他们三人姓氏开头字母拼在一起组成的
 * <p>
 * 使用非对称密钥
 * RSA允许你选择公钥的大小。512位的密钥被视为不安全的；768位的密钥不用担心受到除了国家安全管理（NSA）外的其他事物的危害；1024位的密钥几乎是安全的。密钥最大位数无限制
 * 通常个人保存私钥，公钥是公开的（可能同时多人持有）。
 * <p>
 * RSA加密 公钥加密 私钥解密
 * RSA签名 私钥签名、公钥验签。
 * @Date 10:48 上午 2020/12/11
 */
package com.xj.encryptUtil.encrypt.RSA;

class RSAConst {
    /** 指定算法 */
    static final String ALGORITHM = "RSA";
    //
    static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";
    static final String CHARSET = "UTF-8";
    static final int RESERVESIZE = 11;
    static final String SIGNATURE = "SHA1withRSA";
}
