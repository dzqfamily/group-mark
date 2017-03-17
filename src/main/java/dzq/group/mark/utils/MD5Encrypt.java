package dzq.group.mark.utils;


import org.apache.commons.codec.digest.DigestUtils;

public final class MD5Encrypt {

	private static final ThreadLocal<MD5Encrypt> local = new ThreadLocal<MD5Encrypt>();

	private MD5Encrypt() {
		super();
	}

	public static MD5Encrypt getEncrypt() {
		MD5Encrypt encrypt = local.get();
		if (encrypt == null) {
			encrypt = new MD5Encrypt();
			local.set(encrypt);
		}
		return encrypt;
	}

	public static String encode(String s) {
		if (s == null) {
			return null;
		}
		return DigestUtils.md5Hex(s);
	}

}