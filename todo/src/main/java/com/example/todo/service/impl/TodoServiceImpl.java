package com.example.todo.service.impl;

import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    public TodoRepository todoRepository;
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        // Sort todos by id in descending order
        Collections.sort(todos, (a, b) -> Long.compare(b.getId(), a.getId()));
        return todos;
    }

    @Override
    public Todo getTodoById(Long id) {
        return this.todoRepository.findById(id).get();
    }

    @Override
    public Todo saveTodoToDatabase(Todo todo) {
        return this.todoRepository.save(todo);
    }

    @Override
    public Todo updateTodoToDatabase(Todo todo) {
        return this.todoRepository.save(todo);
    }

    @Override
    public void deleteTodoFromDatabase(Long id) {
        this.todoRepository.deleteById(id);
    }
}
