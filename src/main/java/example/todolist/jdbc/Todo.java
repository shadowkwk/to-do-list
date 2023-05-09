package example.todolist.jdbc;

public class Todo {

    private int id;
    private String content;
    private boolean completed;

    // Constructors, getters, and setters
    public Todo(int id, String content, boolean completed) {
        this.id = id;
        this.content = content;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
