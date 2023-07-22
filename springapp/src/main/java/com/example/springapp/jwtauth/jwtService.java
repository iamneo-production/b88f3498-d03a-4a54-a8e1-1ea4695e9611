// package main.java.com.example.springapp.jwtauth;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.io.Decoders;
// import io.jsonwebtoken.security.Keys;

// import java.security.Key;
// import java.util.Date;
// import java.util.Map;
// import java.util.function.Function;


// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Service;

// import io.jsonwebtoken.Claims;

// @Service
// public class jwtService {

//     private final String Secret_Key = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";


//     public String generateToken(Map<String,Object> extraClaims,UserDetails userDetails){
        
//         return Jwts.builder()
//                 .setClaims(extraClaims)
//                 .setSubject(userDetails.getUsername())
//                 .setIssuedAt(new Date(System.currentTimeMillis()))
//                 .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *24))
//                 .signWith(getSigningKey(),SignatureAlgorithm.HS256)
//                 .compact();
//     }


//     public String extractUsername(String token){
//         return extractClaims(token, Claims::getSubject);
//     }
    
//     public <T> T extractClaims(String token,Function<Claims,T> claimsResolver){
//         final Claims claims = extractAllClaims(token);
//         return claimsResolver.apply(claims);
//     }

//     public Claims extractAllClaims(String token){

//         return Jwts.parserBuilder()
//         .setSigningKey(getSigningKey())
//         .build()
//         .parseClaimsJws(token)
//         .getBody();
//     }


//     private Key getSigningKey() {
//         byte[] keyBytes= Decoders.BASE64.decode(Secret_Key);
//         return Keys.hmacShaKeyFor(keyBytes);
//     }

//     public Boolean isTokenValid(String token,UserDetails userDetails){
//         final String username = extractUsername(token);
//         return (username.equals(userDetails.getUsername()))|| !isTokenExpired(token);
//     }


//     private boolean isTokenExpired(String token) {
//         return extractExpiration(token).before(new Date());
//     }


//     private Date extractExpiration(String token) {

//         return extractClaims(token,Claims::getExpiration);
//     }
// }