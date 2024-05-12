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

    @GetMapping("/api/hello")
    public Hello test() {
        Hello hello = new Hello("Hello Spring", "Hello React");
        return hello;
    }

    @GetMapping("/list")
    public List<ToDoEntity> list(){
        List<ToDoEntity> toDoList=this.toDoService.getList();
        return toDoList;
    }

    public class Hello{
        private String str;
        private String str2;

        public Hello(String str, String str2){
            this.str = str;
            this.str2=str2;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public String getStr2() {
            return str2;
        }

        public void setStr2(String str2) {
            this.str2 = str2;
        }
    }
}