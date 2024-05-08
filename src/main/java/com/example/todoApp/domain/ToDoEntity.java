package com.example.todoApp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name = "todo")
@Entity(name="ToDoEntity")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ToDoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isDone;

    private String content;

    private Date date;
}
