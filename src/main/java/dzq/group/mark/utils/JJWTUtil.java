package dzq.group.mark.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JJWTUtil {

    public static String token(String openid,String signingKey) {

        JwtBuilder builder= Jwts.builder()
                .setId(openid)
                .setIssuedAt(new Date())//设置签发时间
                .signWith(SignatureAlgorithm.HS256,signingKey);//设置签名秘钥
        return builder.compact();
    }

    public static String parseJWT(String token,String signingKey) {
        Claims claims = Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token).getBody();
        return claims.getId();
    }

}
