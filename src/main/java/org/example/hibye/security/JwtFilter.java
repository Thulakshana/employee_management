package org.example.hibye.security;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtFilter extends GenericFilter {

    private final JwtUtil obj4;
    public JwtFilter(JwtUtil obj4){
        this.obj4=obj4;
    }


   @Override
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        String header=req.getHeader("Authorization");
        if(header !=null && header.startsWith("Bearer ")){
            String token=header.substring(7);
            if(!obj4.validationtoken(token)){
                HttpServletResponse res=(HttpServletResponse) response;
                res.setStatus(401);
                return;

            }
        }
        chain.doFilter(request,response);
   }


}
