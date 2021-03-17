package com.thales.formation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thales.formation.dto.TodoDto;
import com.thales.formation.enums.TodoStatus;
import com.thales.formation.mapper.TodoMapper;
import com.thales.formation.model.Todo;
import com.thales.formation.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoMapper todoMapper;
	
	@Autowired
	private TodoRepository todoRepository;
	
	public Iterable<Todo> findAllNotCompleted() {
		return todoRepository.findByStatus(TodoStatus.TODO);
	}
	
	public Todo findById(Long id) {
		Optional<Todo> optTodo = todoRepository.findById(id);
		return optTodo.get();
	}

	public Todo create(TodoDto todoDto) {
		Todo todo = todoMapper.dtoToModel(todoDto);
		todo.setStatus(TodoStatus.TODO);
		return todoRepository.save(todo);
	}

	public void update(TodoDto todoDto) {
		Todo todo = this.findById(todoDto.getId());
		todo.setName(todoDto.getName());
	}
	
	public void complete(Long todoId) {
		Todo todo = this.findById(todoId);
		todo.setStatus(TodoStatus.COMPLETED);
	}

	public void delete(Long id) {
		todoRepository.deleteById(id);
	}
	
	public void deleteAll() {
		todoRepository.deleteAll();
	}

}
