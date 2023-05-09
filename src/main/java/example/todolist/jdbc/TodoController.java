/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package example.todolist.jdbc;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author kamwa
 */
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private TodoDao todoDao;

    public TodoController(TodoDao toDoDao) {
        this.todoDao = toDoDao;
    }
    
    @GetMapping("")
    public List<Todo> getAllTodo(){
        return todoDao.getAllTodo();
    }
    
//    // curl -i -X PUT -H "Content-Type: application/json" -d '{"id":10004,"name":"Informatics 300","teacherId":1234}' http://localhost/spring/data/courses/10004
    @PutMapping("/{id}")
    public void updateTodo(@PathVariable int id, @RequestBody Todo todo) {
        todoDao.updateTodo(todo);
    }
//    
//    // curl -i -X DELETE http://localhost/spring/data/courses/10004
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable int id) {
        todoDao.deleteTodo(id);
    }
    
    @PostMapping("")
    public void createTodo(@RequestBody Todo todo) {
        todoDao.createTodo(todo);
    }
}
