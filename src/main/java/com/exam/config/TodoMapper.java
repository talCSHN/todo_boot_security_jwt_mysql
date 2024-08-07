package com.exam.config;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.Todo;

@Mapper
public interface TodoMapper {

	public List<Todo> findAll(String userid);
	public int update(Todo todo);
	public int save(Todo todo);
	public int deleteById(long id);
	public Todo findById(long id);
}
