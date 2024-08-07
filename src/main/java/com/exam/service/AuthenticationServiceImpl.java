package com.exam.service;

import java.util.Map;
import org.springframework.stereotype.Service;
import com.exam.config.MemberMapper;
import com.exam.dto.Member;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	MemberMapper memberMapper;
	
	public AuthenticationServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}


	@Override
	public Member authenticate(Map<String, String> map) {
		return memberMapper.authenticate(map);
	}


	@Override
	public Member findById(String userid) {
		return memberMapper.findById(userid);
	}

}
