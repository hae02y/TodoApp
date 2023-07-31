package codestates.todo.mapper;

import codestates.todo.domain.Todo;
import codestates.todo.dto.PatchTodoDto;
import codestates.todo.dto.PostTodoDto;
import codestates.todo.dto.ResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-31T19:48:15+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.18 (Azul Systems, Inc.)"
)
@Component
public class TodoMapperImpl implements TodoMapper {

    @Override
    public Todo posttoTodo(PostTodoDto postTodoDto) {
        if ( postTodoDto == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.setTitle( postTodoDto.getTitle() );
        todo.setTodoOrder( postTodoDto.getTodoOrder() );
        todo.setCompleted( postTodoDto.getCompleted() );

        return todo;
    }

    @Override
    public Todo patchtoTodo(PatchTodoDto patchTodoDto) {
        if ( patchTodoDto == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.setId( patchTodoDto.getId() );
        todo.setTitle( patchTodoDto.getTitle() );
        todo.setTodoOrder( patchTodoDto.getTodoOrder() );
        todo.setCompleted( patchTodoDto.getCompleted() );

        return todo;
    }

    @Override
    public ResponseDto todoToResponse(Todo todo) {
        if ( todo == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        Long todoOrder = null;
        Boolean completed = null;

        id = todo.getId();
        title = todo.getTitle();
        todoOrder = todo.getTodoOrder();
        completed = todo.getCompleted();

        String url = null;

        ResponseDto responseDto = new ResponseDto( id, title, todoOrder, completed, url );

        return responseDto;
    }
}
