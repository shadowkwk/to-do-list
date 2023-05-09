/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package example.todolist.jdbc;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author kamwa
 */
public class TodoDao {

    private JdbcTemplate jdbcTemplate;

    public TodoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Todo> getAllTodo() {
        String sql = "select * from todos";
        return jdbcTemplate.query(sql, (rs, rowNum)
                -> new Todo(
                        rs.getInt("id"),
                        rs.getString("content"),
                        rs.getBoolean("Completed")
                ));

    }

    public void updateTodo(Todo todo) {
        String sql = "UPDATE todos SET content=?, Completed=? WHERE id=?";
        jdbcTemplate.update(sql, todo.getContent(), todo.getCompleted(), todo.getId());
    }

    public void deleteTodo(int todoId) {
        String sql = "Delete from todos where id=?";
        jdbcTemplate.update(sql, todoId);
    }
    
    public void createTodo(Todo todo) {
        String sql = "Insert INTO todos (content, completed) VALUES (?,?)";
        jdbcTemplate.update(sql, todo.getContent(), todo.getCompleted());
    }
}
