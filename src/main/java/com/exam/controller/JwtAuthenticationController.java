package com.exam.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dto.Member;
import com.exam.security.JwtTokenResponse;
import com.exam.security.JwtTokenService;
import com.exam.service.AuthenticationService;

@RestController
public class JwtAuthenticationController {
    
	private Logger logger = LoggerFactory.getLogger(getClass());
	
    private  JwtTokenService tokenService;
    
//    private  AuthenticationManager authenticationManager;

    public JwtAuthenticationController(JwtTokenService tokenService) {
        this.tokenService = tokenService;
//        this.authenticationManager= authenticationManager;
    }

    /*
      작업1: authenticate 요청해서 먼저 인증처리하고 token을 받는다.
            반드시 POST로 요청하고 permitAll() 지정한다.
            
      request 요청:
      {
        "userid":"inky4832",
        "password":"1234",
      }
      
      response :
       {
         token: "TOKEN_VALUE"
       }
       
     
     */
    
    
    @Autowired
    AuthenticationService authenticationService;
    
    // 로그인 처리 + token 얻기
    @PostMapping("/authenticate")
    public ResponseEntity<JwtTokenResponse> generateToken(
            @RequestBody Map<String, String> jwtTokenRequest) {
        
    	logger.info("logger: jwtTokenRequest: {}", jwtTokenRequest);
    	
    	Member member = authenticationService.findById(jwtTokenRequest.get("userid"));
    	
    	PasswordEncoder passwordEncoder = passwordEncoder(); 
    	UsernamePasswordAuthenticationToken authenticationToken=null; 
    	
    	if (member != null && passwordEncoder.matches(jwtTokenRequest.get("password"), member.getPassword())) { // 일치하는 사용자와 비번이 일치하면
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("USER")); // 권한 부여, 현재는 모든 사용자권한을 USER로 지정한다.
            authenticationToken =
            		new UsernamePasswordAuthenticationToken(new Member(jwtTokenRequest.get("userid"), jwtTokenRequest.get("password"), member.getUsername(), member.getRole()), null, roles); 
           
        }
              
        String token = tokenService.generateToken(authenticationToken);
        return ResponseEntity.ok(new JwtTokenResponse(token));
    }
 // 암호화 객체 생성
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
   
    
    /*
       작업2: token 이용해서 다른 요청 작업을 한다.
            반드시 다음과 같이 Authorization header 값을 설정해야 된다.
            
        
        Authorization: Bearer TOKEN_VALUE   
       
      
     */
    @GetMapping("/authenticate-hello")
    public String authenticateHello() {
    	return "authenticateHello";
    }
}