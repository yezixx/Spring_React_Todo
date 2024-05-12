import React, { useState, useEffect } from 'react';
import axios from 'axios';
import TodoItem from "./TodoItem";

const Test = () => {
    const [todos, setTodos] = useState([]);

    useEffect(() => {
        axios.get('/list')
            .then(response => {
                //console.log(response.data);
                setTodos(response.data);
            });
    }, []);

    console.log(todos);

    return (
        <div>
            <h1>Todo</h1>
            {todos.map((todo)=>{
                return (
                    <TodoItem
                     key={todo.id}
                     {...todo}
                     />
                );
                })}
        </div>
    );
}

export default Test;