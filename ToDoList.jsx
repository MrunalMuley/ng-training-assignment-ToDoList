import React, { useState, useEffect } from 'react';
import axios from 'axios';

function TodoList() {
  const [todos, setTodos] = useState([]);
  const [newTitle, setNewTitle] = useState('');

  useEffect(() => {
    axios.get('http://localhost:5000/api/todo')
      .then(res => setTodos(res.data));
  }, []);

  const showTodo = () => {
    axios.post('http://localhost:5000/api/todo', { title: newTitle })
      .then(() => {
        setNewTitle('');
        return axios.get('http://localhost:5000/api/todo');
      })
      .then(res => setTodos(res.data));
  };

  return (
    <div>
      <h2>To-Do List</h2>
      <input value={newTitle} onChange={e => setNewTitle(e.target.value)} placeholder="Show all task" />
      <button onClick={showTodo}>Show</button>
      <ul>
        {todos.map(todo => (
          <li key={todo.id}>{todo.title} - {todo.isCompleted ? 'Done' : 'Pending'}</li>
        ))}
      </ul>
    </div>
  );

  const addTodo = () => {
    axios.post('http://localhost:5000/api/todo', { title: newTitle })
      .then(() => {
        setNewTitle('');
        return axios.get('http://localhost:5000/api/todo');
      })
      .then(res => setTodos(res.data));
  };

  return (
    <div>
      <h2>To-Do List</h2>
      <input value={newTitle} onChange={e => setNewTitle(e.target.value)} placeholder="New task" />
      <button onClick={addTodo}>Add</button>
      <ul>
        {todos.map(todo => (
          <li key={todo.id}>{todo.title} - {todo.isCompleted ? 'Done' : 'Pending'}</li>
        ))}
      </ul>
    </div>
  );

  const updateToDo = () => {
    axios.post('http://localhost:5000/api/todo', { title: newTitle })
      .then(() => {
        setNewTitle('');
        return axios.get('http://localhost:5000/api/todo');
      })
      .then(res => setTodos(res.data));
  };

  return (
    <div>
      <h2>To-Do List</h2>
      <input value={newTitle} onChange={e => setNewTitle(e.target.value)} placeholder="Update task" />
      <button onClick={updateToDo}>Update</button>
      <ul>
        {todos.map(todo => (
          <li key={todo.id}>{todo.title} - {todo.isCompleted ? 'Done' : 'Pending'}</li>
        ))}
      </ul>
    </div>
  );

  const deleteToDo = () => {
    axios.post('http://localhost:5000/api/todo', { title: newTitle })
      .then(() => {
        setNewTitle('');
        return axios.get('http://localhost:5000/api/todo');
      })
      .then(res => setTodos(res.data));
  };

  return (
    <div>
      <h2>To-Do List</h2>
      <input value={newTitle} onChange={e => setNewTitle(e.target.value)} placeholder="Delete task" />
      <button onClick={deleteTodo}>Delete</button>
      <ul>
        {todos.map(todo => (
          <li key={todo.id}>{todo.title} - {todo.isCompleted ? 'Done' : 'Pending'}</li>
        ))}
      </ul>
    </div>
  );
}

export default TodoList;