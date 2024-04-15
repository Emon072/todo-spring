package com.example.todo.service;

import com.example.todo.entity.Todo;
import jakarta.transaction.Transactional;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo getTodoById(Long id);

    @Transactional
    Todo saveTodoToDatabase(Todo todo);
    @Transactional
    Todo updateTodoToDatabase(Todo todo);

    @Transactional
    void deleteTodoFromDatabase(Long id);
}
