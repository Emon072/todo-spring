package com.example.todo.controller;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class TodoController {

    private TodoService todoService;

    private List<Todo> todos;
    private Long currentId = (long) -1;

    private int currentPage = 0;


    public TodoController(TodoService todoService) {
        this.todoService = todoService;
        this.todos = todoService.getAllTodos();
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("mainBodyTitle", "All Tasks is : " + todos.size());
        model.addAttribute("todos", todos);

        model.addAttribute("newTodo", new Todo());

        model.addAttribute("currentPage" , 1);

        this.currentPage = 1;

        return "index";
    }

    @GetMapping("/today")
    public String today(Model model) {

        List<Todo> todosDueToday = new ArrayList<>();
        LocalDate today = LocalDate.now();

        for (Todo todo : todos) {
            if (todo.getDueDate().isEqual(today)){
                todosDueToday.add(todo);
            }
        }

        model.addAttribute("mainBodyTitle", "Today's Total Tasks is : " + todosDueToday.size());

        model.addAttribute("todos", todosDueToday);

        model.addAttribute("newTodo", new Todo());

        model.addAttribute("currentPage" , 0);


        this.currentPage = 0;

        return "todays";
    }

    @GetMapping("/completed")
    public String completed(Model model) {

        List<Todo> todoCompleted = new ArrayList<>();

        for (Todo todo : todos) {
            if (todo.getCompleted()){
                todoCompleted.add(todo);
            }
        }

        model.addAttribute("mainBodyTitle", "Completed Tasks is : " + todoCompleted.size());

        model.addAttribute("todos", todoCompleted);

        model.addAttribute("newTodo", new Todo());

        model.addAttribute("currentPage" , 2);

        this.currentPage = 2;

        return "completed";
    }

    @GetMapping("/pending")
    public String pending(Model model) {

        List<Todo> todosPending = new ArrayList<>();

        for (Todo todo : todos) {
            if (!todo.getCompleted()){
                todosPending.add(todo);
            }
        }

        model.addAttribute("mainBodyTitle", "Pending Tasks is : " + todosPending.size());

        model.addAttribute("todos", todosPending);

        model.addAttribute("newTodo", new Todo());

        model.addAttribute("currentPage" , 3);

        this.currentPage = 3;


        return "pending";
    }

    @GetMapping("/important")
    public String important(Model model) {
        List < Todo > importantTodo = todos;

        Collections.sort(importantTodo , (a , b) -> Integer.compare(b.getImportant() , a.getImportant()));
        model.addAttribute("mainBodyTitle", "Sorted Tasks by Importance is : " + importantTodo.size());

        model.addAttribute("todos", importantTodo);

        model.addAttribute("newTodo", new Todo());

        model.addAttribute("currentPage" , 4);
        this.currentPage = 4;
        return "important";
    }

    @GetMapping("/all")
    private String getAllTodos(){
        todos = todoService.getAllTodos();
        this.currentPage = 1;
        return "redirect:/";
    }

    @PostMapping("/createNewTodo")
    public String saveTodo(@ModelAttribute("newTodo") Todo newTodo ) {

        if (currentId!=-1){
            Todo current = this.todoService.getTodoById(currentId);
            newTodo.setId(currentId);
            newTodo.setCompleted(current.getCompleted());
        }
        else{
            newTodo.setCompleted(false);
        }
        currentId =(long) -1;
        this.todoService.saveTodoToDatabase(newTodo);

        todos = todoService.getAllTodos();

        if (this.currentPage==0) return "redirect:/today";
        else if (this.currentPage==2) return "redirect:/completed";
        else if (this.currentPage==3) return  "redirect:/pending";
        else if (this.currentPage==4) return "redirect:/important";

        return "redirect:/all";
    }


    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        this.todoService.deleteTodoFromDatabase(id);

        todos = todoService.getAllTodos();

        if (this.currentPage==0) return "redirect:/today";
        else if (this.currentPage==2) return "redirect:/completed";
        else if (this.currentPage==3) return  "redirect:/pending";
        else if (this.currentPage==4) return "redirect:/important";

        return "redirect:/all";
    }

    @PostMapping("/update-completed/{id}")
    public String updateCompleted(@PathVariable Long id , Model model){
        Todo currentTodo = this.todoService.getTodoById(id);
        currentTodo.setCompleted(!currentTodo.getCompleted());
        this.todoService.updateTodoToDatabase(currentTodo);

        todos = todoService.getAllTodos();

        if (this.currentPage==0) return "redirect:/today";
        else if (this.currentPage==2) return "redirect:/completed";
        else if (this.currentPage==3) return  "redirect:/pending";
        else if (this.currentPage==4) return "redirect:/important";

        return "redirect:/all";
    }

    @GetMapping("/update/{id}")
    @ResponseBody
    public String updateTodo(@PathVariable Long id, Model model) {
        currentId = id;
        Todo updatedTodo = this.todoService.getTodoById(id);
        model.addAttribute("newTodo", updatedTodo);

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
