package com.example.todo.service;

import com.example.todo.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo getTodoById(Long id);
    Todo saveTodoToDatabase(Todo todo);
    Todo updateTodoToDatabase(Todo todo);
    void deleteTodoFromDatabase(Long id);
}
