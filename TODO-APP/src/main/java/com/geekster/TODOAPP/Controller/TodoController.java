package com.geekster.TODOAPP.Controller;

import com.geekster.TODOAPP.Entity.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TodoController {

    private List<Todo> myTodos;

    public TodoController(){
        myTodos = new ArrayList<>();
    }
    @GetMapping("todos")
    public List<Todo> getAllTodos(){
        return myTodos;
    }

    @GetMapping("todo/done")
    public List<Todo> getDoneTodos(){
        List<Todo> doneTodos = new ArrayList<>();

        for(Todo myTodo : myTodos){
            if(myTodo.isTodoDoneStatus()){
                doneTodos.add(myTodo);
            }
        }

        return doneTodos;
    }

    @GetMapping("todo/undone")
    public List<Todo> getNotDoneTodos(){
        List<Todo> unDoneTodos = new ArrayList<>();

        for(Todo myTodo : myTodos){
            if(!myTodo.isTodoDoneStatus()){
                unDoneTodos.add(myTodo);
            }
        }

        return unDoneTodos;
    }
    @PostMapping("todo")
    public String addTodo(@RequestBody Todo todo){
        myTodos.add(todo);
        return "Todo added";
    }

    @PutMapping("todo/{todoId}/{status}")
    public String markTodo(@PathVariable Integer todoId,@PathVariable boolean status){
        for(Todo myTodo : myTodos){
            if(myTodo.getTodoId().equals(todoId)){
                myTodo.setTodoStatus(status);
                return "todo updated for todo Id : "+ todoId;
            }
        }

        return "todo not found for : "+ todoId;
    }

    @DeleteMapping("todo")
    public String removeTodo(@RequestParam Integer todoId){
        for(Todo myTodo : myTodos){
            if(myTodo.getTodoId().equals(todoId)){
                myTodos.remove(myTodo);
                return "todo updated for todo Id : "+ todoId;
            }
        }
        return "todo : "+ todoId +" not deleted as it doesn't exist";
    }
}
