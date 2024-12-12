package spring.server.il.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import spring.server.dl.entities.person.Professional;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.UUID;

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

    public String generateToken(Professional professional){
        return this.builder
                .setSubject(professional.getUsername())
                .claim("id", professional.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME * 1000))
                .compact();
    }

    private Claims parseToken(String token){
        return this.parser.parseClaimsJws(token).getBody();
    }

    public String getUsername(String token){
        return parseToken(token).getSubject();
    }

    public UUID getUserId(String token){
        return parseToken(token).get("id", UUID.class);
    }

    public boolean isValid(String token){
        Claims claims = parseToken(token);
        Date now = new Date();

        return now.after(claims.getIssuedAt()) && now.before(claims.getExpiration());
    }
}