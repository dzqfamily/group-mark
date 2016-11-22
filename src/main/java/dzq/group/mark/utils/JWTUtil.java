package dzq.group.mark.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;
import java.util.Date;

/**
 * Created by duanzhiqiang1 on 2016/11/21.
 */
public class JWTUtil {
	//issuer
	private static final String ISSUER = "GROUPMARK";
	//android
	private static final String SUBJECT_ANDROID = "v1";
	//We will sign our JWT with our ApiKey secret
	private static final Key signingKey = MacProvider.generateKey();

	/**
	 *
	 * @param id 用户id
	 * @param subject 用户群v1:android
	 * @param ttlMillis 超时时间
	 * @return
	 */
	public static String createJWT(String id,String subject, long ttlMillis) {

		//The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		//Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id)
				.setIssuedAt(now)
				.setSubject(subject)
				.setIssuer(ISSUER)
				.signWith(signatureAlgorithm, signingKey);

		//if it has been specified, let's add the expiration
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		//Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	public static Claims parseJWT(String jwt) {

		//This line will throw an exception if it is not a signed JWS (as expected)
		Claims claims = Jwts.parser()
				.setSigningKey(signingKey)
				.parseClaimsJws(jwt).getBody();
		return claims;
	}

}
