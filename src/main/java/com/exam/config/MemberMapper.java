package com.exam.config;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.Member;

@Mapper
public interface MemberMapper {

	public Member idCheck(String userid);
	public Member authenticate(Map<String, String> map);
	public int save(Member m);
	public Member findById(String userid);
	
}
