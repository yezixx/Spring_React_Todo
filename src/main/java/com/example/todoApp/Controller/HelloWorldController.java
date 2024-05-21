package com.example.todoApp.Controller;

import com.example.todoApp.Service.ToDoService;
import com.example.todoApp.domain.ToDoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HelloWorldController {
    private final ToDoService toDoService;
/*
    @GetMapping("/")
    @ResponseBody
    public ToDoEntity test(@RequestParam(name="id") Long id, @RequestParam(name="todo") String todo) {
        ToDoEntity todoData = new ToDoEntity(id, todo);
        System.out.println(todoData);
        return todoData;
    }*/

    @GetMapping("/list")
    public List<ToDoEntity> list(){
        List<ToDoEntity> toDoList=this.toDoService.getList();
        return toDoList;
    }

    @PostMapping("/list/create")
    public void createToDo(@RequestBody ToDoEntity todoContent){
        this.toDoService.create(todoContent);
    }
}