/*
import "./App.css";
import Header from "./components/Header";
import Editor from "./components/Editor";
import List from "./components/List";
import { useReducer, useRef, useState } from "react";

const mockData = [
  {
    id: 0,
    isDone: false,
    content: "React 공부하기",
    date: new Date().getTime(),
  },
  {
    id: 1,
    isDone: false,
    content: "빨래하기",
    date: new Date().getTime(),
  },
  {
    id: 2,
    isDone: false,
    content: "노래 연습하기",
    date: new Date().getTime(),
  },
];

function reducer(state, action) {
  switch (action.type) {
    case "CREATE":
      return [action.data, ...state];
    case "UPDATE":
      return state.map((item) =>
        item.id === action.targetId
          ? {
              ...item,
              isDone: !item.isDone,
            }
          : item
      );
    case "DELETE":
      return state.filter((item) => item.id !== action.targetId);
    default:
      return state;
  }
}

function App() {
  const [todos, dispatch] = useReducer(reducer, mockData);

  const idRef = useRef(3);

  const onCreate = (content) => {
    dispatch({
      type: "CREATE",
      data: {
        id: idRef.current++,
        isDone: false,
        content: content,
        date: new Date().getTime(),
      },
    });
  };

  const onUpdate = (targetId) => {
    dispatch({
      type: "UPDATE",
      targetId: targetId,
    });
  };

  const onDelete = (targetId) => {
    dispatch({
      type: "DELETE",
      targetId: targetId,
    });
  };

  return (
    <div className="App">
      <Header />
      <Editor onCreate={onCreate} />
      <List todos={todos} onUpdate={onUpdate} onDelete={onDelete} />
    </div>
  );
}

export default App;
 */
 import "./App.css";
 import React, {useEffect, useState, useRef} from 'react';
 import axios from 'axios';
 import Header from "./components/Header";
 import Editor from "./components/Editor";
 import List from "./components/List";

 function App() {
    const [todos, setTodos] = useState([]);

    const idRef = useRef(3);

      const onCreate = (content) => {
        const newTodo = {
          id: idRef.current++,
          isDone: false,
          content: content,
          date: new Date().getTime(),
        };
        setTodos([newTodo, ...todos]);
        axios.post('/list/create', newTodo);
      };

      const onUpdate = (targetId) => {
          setTodos(
            todos.map((todo) =>
              todo.id === targetId
                ? {
                    ...todo,
                    isDone: !todo.isDone,
                  }
                : todo
            )
          );
          axios.post(`/list/update/${targetId}`, targetId);
        };

        const onDelete = (targetId) => {
            setTodos(todos.filter((todo) => todo.id !== targetId));
            axios.post(`/list/delete/${targetId}`, targetId);
          };

        useEffect(() => {
            axios.get('/list')
                .then(response => {
                    setTodos(response.data);
                })
                .catch(error => console.log(error))
        }, []);

     return (
        <div className="App">
        <Header/>
        <Editor onCreate={onCreate} />
        <List todos={todos} onUpdate={onUpdate} onDelete={onDelete}/>
        </div>
     );
 }

 export default App;
