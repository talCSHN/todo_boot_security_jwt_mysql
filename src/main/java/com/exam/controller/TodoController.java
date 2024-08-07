package com.exam.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.exam.dto.Todo;
import com.exam.service.TodoMyBatisService;


@RestController
public class TodoController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	TodoMyBatisService todoMyBatisService;
	
	public TodoController(TodoMyBatisService todoMyBatisService) {
		this.todoMyBatisService = todoMyBatisService;
	}

	// Todo 목록보기
	@GetMapping("/users/{userid}/todos")
	public List<Todo> findAll(@PathVariable String userid) {
		List<Todo> todos = todoMyBatisService.findAll(userid);
		return todos;
	}
	
	@GetMapping("/users/{userid}/todos/{id}")
	public Todo retrieveTodo(@PathVariable String userid,
			@PathVariable int id) {
		return todoMyBatisService.findById(id);
	}
	
	// Todo 삭제하기
	@DeleteMapping("/users/{userid}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String userid,
			@PathVariable int id) {
		System.out.println("userid:" + userid);
		System.out.println("id:" + id);
		todoMyBatisService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	// Todo 생성하기
	@PostMapping("/users/{userid}/todos")
	public Todo createTodo(@PathVariable String userid, 
			@Valid @RequestBody Todo todo) {
		System.out.println("Todo 생성: " + todo);
		Todo createdTodo = todoMyBatisService.save(todo);
		return createdTodo;
	}

	// Todo 수정하기
	@PutMapping("/users/{userid}/todos/{id}")
	public Todo updateTodo(@PathVariable String userid,
			@PathVariable int id, @RequestBody Todo todo) {
		todo.setId(id);
		todo.setUserid(userid);
		todoMyBatisService.update(todo);
		return todo;
	}
	
}
