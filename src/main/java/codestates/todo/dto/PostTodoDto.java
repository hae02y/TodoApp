package codestates.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class PostTodoDto {
    private String title;
    private Long todoOrder;
    private Boolean completed;
}
