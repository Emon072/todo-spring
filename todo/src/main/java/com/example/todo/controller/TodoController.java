package com.example.todo.controller;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {

    private TodoService todoService;

    private List<Todo> todos;
    private Long currentId = (long) -1;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
        this.todos = todoService.getAllTodos();
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todos);

        model.addAttribute("newTodo", new Todo());

        return "index";
    }

    @GetMapping("/all")
    private String getAllTodos(){
        todos = todoService.getAllTodos();
        return "redirect:/";
    }

    @PostMapping("/createNewTodo")
    public String saveTodo(@ModelAttribute("newTodo") Todo newTodo ) {
        if (currentId!=-1){
            newTodo.setId(currentId);
//            System.out.println(newTodo.getTitle());
//            System.out.println(newTodo.getId());
//            System.out.println(newTodo.getDescription());
//            System.out.println(newTodo.getCompleted());
//            System.out.println(newTodo.getImportant());
//            System.out.println(newTodo.getDir());
        }
        else{
            newTodo.setCompleted(false);
        }
        currentId =(long) -1;
        this.todoService.saveTodoToDatabase(newTodo);
        return "redirect:/all";
    }

    @PostMapping("/updateTodo")
    public String updateCurrentTodo(@ModelAttribute("newTodo") Todo newTodo ) {
        this.todoService.updateTodoToDatabase(newTodo);
        return "redirect:/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        this.todoService.deleteTodoFromDatabase(id);
        return "redirect:/all";
    }

    @GetMapping("/update/{id}")
    @ResponseBody
    public String updateTodo(@PathVariable Long id, Model model) {
        currentId = id;
        Todo updatedTodo = this.todoService.getTodoById(id);
        model.addAttribute("newTodo", updatedTodo); // Change here
//        Todo todo = (Todo) model.getAttribute("newTodo");
//        System.out.println("Current Todo Title: " + todo.getTitle());

        return " "+ //
                "<div class=\"form-group mb-3\">\n" +
                "    <label for=\"title\">Note Title</label>\n" +
                "    <input type=\"text\" class=\"form-control\" id=\"title\" placeholder=\"Note Title\" name=\"title\" value=\" " + updatedTodo.getTitle() + "\" th:field=\"*{title}\" />\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"form-group mb-3\">\n" +
                "    <label for=\"description\">Description</label>\n" +
                "    <textarea class=\"form-control\" id=\"description\" rows=\"3\" name=\"description\"  th:field=\"*{description}\">" + updatedTodo.getDescription() + "</textarea>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"form-group mb-3\">\n" +
                "    <label for=\"dueDate\">Select Date</label>\n" +
                "    <div class=\"date-picker-wrapper\">\n" +
                "        <input type=\"date\" class=\"form-control custom-date-picker\" id=\"dueDate\" th:value=\"*{dueDate}\" name=\"dueDate\" value=\"" + updatedTodo.getDueDate() + "\" />\n" +
                "        <i class=\"calendar-icon\"></i>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "<div class=\"form-group mb-3\">\n" +
                "    <label for=\"important\">Importance</label>\n" +
                "    <select class=\"form-select\" id=\"important\" name=\"important\" th:field=\"*{important}\" >\n" +
                "        <option value=\"1\"" + (updatedTodo.getImportant() == 1 ? " selected" : "") + ">1</option>\n" +
                "        <option value=\"2\"" + (updatedTodo.getImportant() == 2 ? " selected" : "") + ">2</option>\n" +
                "        <option value=\"3\"" + (updatedTodo.getImportant() == 3 ? " selected" : "") + ">3</option>\n" +
                "    </select>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"form-group mb-3\">\n" +
                "    <label for=\"dir\">Directory</label>\n" +
                "    <select class=\"form-select\" id=\"dir\" name=\"dir\" th:field=\"*{dir}\">\n" +
                "        <option value=\"Main\"" + (updatedTodo.getDir().equals("Main") ? " selected" : "") + ">Main</option>\n" +
                "        <option value=\"Job\"" + (updatedTodo.getDir().equals("Job") ? " selected" : "") + ">Job</option>\n" +
                "        <option value=\"Study\"" + (updatedTodo.getDir().equals("Study") ? " selected" : "") + ">Study</option>\n" +
                "    </select>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"button-container\">\n" +
                "    <button type=\"submit\" class=\"btn btn-primary submit-btn\">Submit</button>\n" +
                "    <button type=\"button\" class=\"btn btn-secondary clear-btn\">Clear</button>\n" +
                "</div>";
    }



}
