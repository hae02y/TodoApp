package codestates.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchTodoDto {
    private Long id;
    private String title;
    private Long todoOrder;
    private Boolean completed;
}
