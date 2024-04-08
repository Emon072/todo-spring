package com.example.todo.service;

import com.example.todo.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo saveTodoToDatabase(Todo todo);
    void deleteTodoFromDatabase(Long id);
}
