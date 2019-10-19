package dzq.group.mark.utils;


import org.apache.commons.codec.digest.DigestUtils;

public final class MD5Encrypt {

	public static String encode(String s) {
		if (s == null) {
			return null;
		}
		return DigestUtils.md5Hex(s);
	}

}