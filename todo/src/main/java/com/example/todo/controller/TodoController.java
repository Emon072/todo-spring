package com.example.todo.controller;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {

    private TodoService todoService;

    private List<Todo> todos;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;

    }

    @GetMapping("/")
    public String index(Model model) {
        // Retrieve todos from the service
        this.todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        model.addAttribute("newTodo", new Todo());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        this.todoService.deleteTodoFromDatabase(id);
        return "redirect:/";
    }

    @PostMapping("/createNewTodo")
    public String saveTodo(@ModelAttribute("newTodo") Todo newTodo) {
        newTodo.setCompleted(false);
//        System.out.println("this is selected " +newTodo.getImportant());
        this.todoService.saveTodoToDatabase(newTodo);
        return "redirect:/";
    }
}
