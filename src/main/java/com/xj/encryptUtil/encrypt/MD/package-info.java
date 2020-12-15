/**
 * @Description TODO
 * @Autohr xj
 * @Date 2020/12/15 9:54 上午
 */
package com.xj.encryptUtil.encrypt.MD;

class MDConst {
    static final String ALGORITHM_TRIPLE_MD5 = "MD5";
}
/**
 * apache-commons-codec提供MD加密方法
 * 对于md5加密来说，DigestUtils提供了6个静态方法
 * byte[] DigestUtils.md5(byte[] data)
 * byte[] DigestUtils.md5(InputStream is)
 * byte[] DigestUtils.md5(String data)
 * <p>
 * String DigestUtils.md5Hex(byte[] data)
 * String DigestUtils.md5Hex(InputStream is)
 * String DigestUtils.md5Hex(String data)
 */
