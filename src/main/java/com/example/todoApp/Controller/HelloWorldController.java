package com.example.todoApp.Controller;

import com.example.todoApp.domain.ToDoEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
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
        Hello hello = new Hello("Hello Spring+React");
        return hello;
    }

    public class Hello{
        private String str;

        public Hello(String str){
            this.str=str;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }
}