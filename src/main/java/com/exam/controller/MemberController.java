package com.exam.controller;

import java.net.URI;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.exam.dto.Member;
import com.exam.service.MemberService;


@RestController
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/")
	public String main( ) {
		
		return "main home- SCM Poll 실습";
	}
	
	@GetMapping("/hello")
	public String hello( ) {
		
		return "hello world";
	}
	
	
    // 회원가입
	@PostMapping(value={"/users"})
	public ResponseEntity<Member>  createMember(@Valid @RequestBody Member member) {
		logger.debug("logger:{}", member);

			// 입력된 비번은 반드시 암호해해야 된다.
		String ecrptPW = new BCryptPasswordEncoder().encode(member.getPassword());
		member.setPassword(ecrptPW);
		
		Member savedMember  = memberService.save(member);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{userid}")
                .buildAndExpand(savedMember.getUserid()) //위의 {userid}를 치환시킴.
                .toUri();
			return ResponseEntity.created(location).build();
	}

	@GetMapping("/users/{userid}")
	public Member findById(@PathVariable String userid ) {
		
		return new Member();
	}
}
