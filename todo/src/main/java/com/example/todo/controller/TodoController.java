package com.example.todo.controller;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TodoController {

    private TodoService todoService;

    private List<Todo> todos;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
        this.todos = todoService.getAllTodos();
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todos);
        return "index";
    }
}
