package codestates.todo.controller;

import codestates.todo.domain.Todo;
import codestates.todo.dto.PatchTodoDto;
import codestates.todo.dto.PostTodoDto;
import codestates.todo.dto.ResponseDto;
import codestates.todo.mapper.TodoMapper;
import codestates.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.sound.midi.Patch;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class TodoController {

    private final TodoService service;
    private final TodoMapper mapper;


    @PostMapping
    public ResponseEntity<ResponseDto> postTodo(@RequestBody PostTodoDto postTodoDto){

        if (ObjectUtils.isEmpty(postTodoDto.getTitle()))
            return ResponseEntity.badRequest().build();

        if (ObjectUtils.isEmpty(postTodoDto.getTodoOrder()))
            postTodoDto.setTodoOrder(0L);

        if (ObjectUtils.isEmpty(postTodoDto.getCompleted()))
            postTodoDto.setCompleted(false);

        Todo createdTodo = service.createTodo(mapper.posttoTodo(postTodoDto));

        return new ResponseEntity<>(mapper.todoToResponse(createdTodo),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResponseDto>> getTodos(){

        List<Todo> todos = service.findTodos();
        List<ResponseDto> collect = todos.stream().map(mapper::todoToResponse).collect(Collectors.toList());

        return new ResponseEntity<>(collect,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> getTodo(@PathVariable long id){

        Todo findedTodo = service.findTodo(id);

        return new ResponseEntity<>(mapper.todoToResponse(findedTodo),HttpStatus.OK);
//        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<ResponseDto> patchTodo(@PathVariable long id,
                                                 @RequestBody PatchTodoDto patchTodoDto){
        patchTodoDto.setId(id);
        Todo updatedTodo = service.updateTodo(mapper.patchtoTodo(patchTodoDto));

        return new ResponseEntity<>(mapper.todoToResponse(updatedTodo),HttpStatus.OK);
//        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping
    public ResponseEntity<String> deleteTodos(){

        String message = "delete everything";
        service.deleteTodos();

//        return new ResponseEntity<>(message,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable long id){

        String message = "delete Ok";
        service.deleteTodo(id);

//        return new ResponseEntity<>(message,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
