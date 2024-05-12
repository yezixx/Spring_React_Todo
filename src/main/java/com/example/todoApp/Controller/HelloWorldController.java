package com.example.todoApp.Controller;

import com.example.todoApp.Service.ToDoService;
import com.example.todoApp.domain.ToDoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}