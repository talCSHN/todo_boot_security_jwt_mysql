package com.exam.service;

import java.util.Map;

import com.exam.dto.Member;

public interface AuthenticationService {

	
	  public Member authenticate(Map<String, String> map);
	  
	  public Member findById(String userid);
	  
}
