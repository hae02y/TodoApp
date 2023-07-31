package codestates.todo.dto;

import codestates.todo.domain.Todo;
import lombok.*;

@Getter
public class ResponseDto {
    private Long id;
    private String title;
    private Long todoOrder;
    private Boolean completed;
    private String url;

    public ResponseDto(Long id, String title, Long todoOrder, Boolean completed, String url) {
        this.id = id;
        this.title = title;
        this.todoOrder = todoOrder;
        this.completed = completed;
        this.url = "http://localhost:8080/" + this.id;
    }
}
