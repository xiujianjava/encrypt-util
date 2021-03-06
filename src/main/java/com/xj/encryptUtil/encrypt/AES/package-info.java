/**
 * @Author xj
 * @Description AES 高级加密标准
 * <p>
 * Aes使用对称密钥进行加解密
 * AES的区块长度固定为128位，
 * 密钥长度则可以是128，192或256位
 * <p>
 * 对称/分组密码一般分为流加密(如OFB、CFB等)和块加密(如ECB、CBC等)。对于流加密，需要将分组密码转化为流模式工作。对于块加密(或称分组加密)，如果要加密超过块大小的数据，就需要涉及填充和链加密模式。
 * ECB(Electronic Code Book电子密码本)模式
 * ECB模式是最早采用和最简单的模式，它将加密的数据分成若干组，每组的大小跟加密密钥长度相同，然后每组都用相同的密钥进行加密。
 * 优点:
 * 1.简单；　2.有利于并行计算；　3.误差不会被传送；　缺点:　1.不能隐藏明文的模式；　2.可能对明文进行主动攻击；　因此，此模式适于加密小消息。
 * <p>
 * CBC(Cipher Block Chaining，加密块链)模式
 * 优点：1.不容易主动攻击,安全性好于ECB,适合传输长度长的报文,是SSL、IPSec的标准。
 * 缺点：　1.不利于并行计算；　2.误差传递；　3.需要初始化向量IV
 * <p>
 * CFB(Cipher FeedBack Mode，加密反馈)模式
 * 优点：1.隐藏了明文模式;　2.分组密码转化为流模式;　3.可以及时加密传送小于分组的数据;
 * 缺点:　1.不利于并行计算;　2.误差传送：一个明文单元损坏影响多个单元;　3.唯一的IV;
 * <p>
 * OFB(Output FeedBack，输出反馈)模式
 * 优点:1.隐藏了明文模式;　2.分组密码转化为流模式;　3.可以及时加密传送小于分组的数据;
 * 缺点:　1.不利于并行计算;　2.对明文的主动攻击是可能的;　3.误差传送：一个明文单元损坏影响多个单元 [4]  。
 * @Date 10:48 上午 2020/12/11
 */
package com.xj.encryptUtil.encrypt.AES;

class AesConst {
    /** 指定算法 */
    static final String ALGORITHM_AES = "AES";
    //
    static final String CIPHER_ALGORITHM_AES = "AES/ECB/PKCS5Padding";
    static final String CHARSET = "GBK";
}
