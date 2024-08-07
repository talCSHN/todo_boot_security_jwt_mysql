package com.exam.service;

import org.springframework.stereotype.Service;

import com.exam.config.MemberMapper;
import com.exam.dto.Member;

@Service
public class MemberServiceImpl implements MemberService{

	MemberMapper memberMapper;
	
	public MemberServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}


	@Override
	public Member save(Member member) {
		int n = memberMapper.save(member);
		return member;		
	}

}
