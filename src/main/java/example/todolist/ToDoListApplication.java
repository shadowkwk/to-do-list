package example.todolist;

import example.todolist.jdbc.TodoDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ToDoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoListApplication.class, args);
    }

    @Bean
    public TodoDao movieDao(JdbcTemplate jdbcTemplate) {
        return new TodoDao(jdbcTemplate);
    }
}
