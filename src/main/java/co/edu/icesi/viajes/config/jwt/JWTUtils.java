package co.edu.icesi.viajes.config.jwt;

import co.edu.icesi.viajes.service.JwtUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Component
@Slf4j
public class JWTUtils {

    @Autowired
    JwtUserDetailsService jwtUserDetailsService;

    private SecretKey Key;
    private  static  final long EXPIRATION_TIME = 86400000;  //24 hours

    public JWTUtils(){
        String secreteString = "843567893696976453275974432697R634976R738467TR678T34865R6834R8763T478378637664538745673865783678548735687R3";
        byte[] keyBytes = Base64.getDecoder().decode(secreteString.getBytes(StandardCharsets.UTF_8)); //Decodificar la clave secreta (en string)
        this.Key = new SecretKeySpec(keyBytes, "HmacSHA256"); //Encriptamos la clave secreta
    }

    //Generar el token de acceso
    public String generateToken(UserDetails userDetails){

        //System.out.println("Rol en el metodo GenerateToken: " + userDetails.getAuthorities());
        //System.out.println("UserDetails: " + userDetails);
        return Jwts.builder()
                .subject(userDetails.getUsername()) //Usuario al que le generara el tokens
                .claim("Rol",userDetails.getAuthorities())
                .issuedAt(new Date(System.currentTimeMillis())) //Fecha de creacion del token
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) //Cuando se va vencer el token (momento actual + 24 horas)
                .signWith(Key) // Cual va ser la firma
                .compact();
    }

    //Validar si el token es valido
    public  boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    /*
    public boolean tokenvalidation(String token){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSignatureKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return true;

        }catch (Exception e){
            log.error("Token invalido, error: ".concat(e.getMessage()));
            return false;

        }
    }
     */

    // Obtener UNICAMENTE un solo CLAIM
    // Le pasamos como parametro el token
    // Tenemos un function que recibe los claims (datos) y retorna un generico ya que un claim puede ser de cualquier tipo
    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction){
        return claimsTFunction.apply(Jwts.parser().verifyWith(Key).build().parseSignedClaims(token).getPayload());
    }


    // Obtener TODOS los claims del token

    // Claims: los datos que vienen dentro del token
    /*
    public Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignatureKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
     */

    /*
    public <T> T getClaim(String token, Function<Claims, T> claimsTFunction){
        Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims)
     */

    public  String generateRefreshToken(HashMap<String, Object> claims, UserDetails userDetails){
        return Jwts.builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Key)
                .compact();
    }

    public  String extractUsername(String token){
        return  extractClaims(token, Claims::getSubject);
    }

    public  boolean isTokenExpired(String token){
        return extractClaims(token, Claims::getExpiration).before(new Date());
    }


}
