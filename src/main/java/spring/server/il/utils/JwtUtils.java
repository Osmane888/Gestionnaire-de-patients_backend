package spring.server.il.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Component
public class JwtUtils {

    private static final String SECRET = "notresuperprojetengroupedesuperamis";
    private static final long EXPIRATION_TIME = 99999L;

    private final JwtBuilder builder;
    private final JwtParser parser;

    public JwtUtils() {
        SecretKey secretKey = new SecretKeySpec(SECRET.getBytes(), "HmacSHA256");
        this.builder = Jwts.builder().signWith(secretKey);
        this.parser = Jwts.parserBuilder().setSigningKey(secretKey).build();
    }

    private Claims parseToken(String token){
        return this.parser.parseClaimsJws(token).getBody();
    }
}