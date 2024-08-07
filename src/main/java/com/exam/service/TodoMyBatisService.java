package com.exam.service;

import java.util.List;

import com.exam.dto.Todo;

public interface TodoMyBatisService {

	public Todo save(Todo todo);
	public void update(Todo todo);
	public void deleteById(long id);
	public Todo findById(long id);
	public List<Todo> findAll(String userid);
	
	
}
