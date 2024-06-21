package com.HUFS19.backend.jwt;

import com.HUFS19.backend.common.util.ResponseUtils;
import com.HUFS19.backend.dto.auth.CustomUserDetails;
import com.HUFS19.backend.error.ErrorCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Response;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CustumLoginFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    private final ObjectMapper mapper = new ObjectMapper();

    public CustumLoginFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil=jwtUtil;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse responser){

        //클라이언트 요청에서 username, password 추출
        String username = request.getParameter("id");
        String password = request.getParameter("pw");

        //스프링 시큐리티에서 username과 password를 검증하기 위해서는 token에 담아야 함
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);

        //token에 담은 검증을 위한 AuthenticationManager로 전달
        return authenticationManager.authenticate(authToken);
    }

    //로그인 성공시 실행하는 메소드
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException {
        CustomUserDetails customUserDetails=(CustomUserDetails) authentication.getPrincipal();
        String userId = customUserDetails.getUsername();

        String token = jwtUtil.createJwt(userId, 12*60*60*100L);

        response.addHeader("Authorization", "Bearer "+token);
        response.getOutputStream().println(mapper.writeValueAsString(ResponseUtils.ok("login success")));
    }

    //로그인 실패
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        response.setContentType(String.valueOf(new MediaType("application", "json", StandardCharsets.UTF_8)));
        response.getWriter().println(mapper.writeValueAsString(ResponseUtils.error(ErrorCode.AUTHENTICATION_FAIL.getStatus(),
                ErrorCode.AUTHENTICATION_FAIL.getCode(),
                ErrorCode.AUTHENTICATION_FAIL.getMessage())));
        response.setStatus(401);
    }
}
