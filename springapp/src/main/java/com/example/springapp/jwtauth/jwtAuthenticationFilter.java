// package main.java.com.example.springapp.jwtauth;

// import java.io.IOException;

// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import lombok.RequiredArgsConstructor;


// @RequiredArgsConstructor
// @Component
// public class jwtAuthenticationFilter extends OncePerRequestFilter{

//     private final jwtService jwtserv;

//     private final UserDetailsService userDetailsService;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {

//                 final String authHeader = request.getHeader("authorization");
//                 if(authHeader == null || !authHeader.startsWith("Bearer ")){
//                     filterChain.doFilter(request,response);
//                     return; 
//                 }
//                 String jwt = authHeader.substring(7); 
//                 String username = jwtserv.extractUsername(jwt);

//                 if(username != null && SecurityContextHolder.getContext().getAuthentication()== null){
//                     UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//                     if(jwtserv.isTokenValid(jwt,userDetails)){
//                         UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
//                             userDetails,
//                             null,
//                             userDetails.getAuthorities()
//                         );
//                         authToken.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));
//                         SecurityContextHolder.getContext().setAuthentication(authToken);
//                     }
//                 }
//                 filterChain.doFilter(request,response);

                
//     }
    
// }
