package com.exam.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.exam.config.TodoMapper;
import com.exam.dto.Todo;

@Service
public class TodoMyBatisServiceImpl implements TodoMyBatisService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	TodoMapper todoMapper;
	
	public TodoMyBatisServiceImpl(TodoMapper todoMapper) {
		logger.info("logger:{}", "TodoServiceImpl");
		this.todoMapper = todoMapper;
	}

	@Override
	public Todo save(Todo todo) {
		int n = todoMapper.save( todo);
		return todo;
	}

	@Override
	public void deleteById(long id) {
		todoMapper.deleteById(id);
	}

	@Override
	public Todo findById(long id) {
		return todoMapper.findById(id);
	}

	@Override
	public List<Todo> findAll(String userid) {
		return todoMapper.findAll(userid);
	}

	@Override
	public void update(Todo todo) {
		todoMapper.update(todo);
	}
	
}
