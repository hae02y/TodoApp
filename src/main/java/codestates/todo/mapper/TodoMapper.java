package codestates.todo.mapper;

import codestates.todo.domain.Todo;
import codestates.todo.dto.PatchTodoDto;
import codestates.todo.dto.PostTodoDto;
import codestates.todo.dto.ResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    public Todo posttoTodo(PostTodoDto postTodoDto);
    public Todo patchtoTodo(PatchTodoDto patchTodoDto);
    public ResponseDto todoToResponse(Todo todo);
}
