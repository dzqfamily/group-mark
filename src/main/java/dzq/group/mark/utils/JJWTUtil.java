package dzq.group.mark.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.util.Date;

public class JJWTUtil {

    private static String signingKey;
    static {
        try {
            signingKey = PropertiesUtil.getValue("password.properties", "signingKey");
        } catch (IOException e) {
            //skip
        }
    }

    public static String token(String openid) {

        JwtBuilder builder= Jwts.builder()
                .setId(openid)
                .setIssuedAt(new Date())//设置签发时间
                .signWith(SignatureAlgorithm.HS256,signingKey);//设置签名秘钥
        return builder.compact();
    }

    public static String parseJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token).getBody();
        return claims.getId();
    }

}
