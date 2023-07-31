package codestates.todo.service;

import codestates.todo.domain.Todo;
import codestates.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo createTodo(Todo todo){
        Todo savedTodo = repository.save(todo);
        return savedTodo;
    }

    public Todo updateTodo(Todo todo){
        Optional<Todo> byId = repository.findById(todo.getId());
        Todo updateTodo = byId.orElseThrow();

        if (todo.getTitle() != null) {
            updateTodo.setTitle(todo.getTitle());
        }

        if (todo.getTodoOrder() != null) {
            updateTodo.setTodoOrder(todo.getTodoOrder());
        }

        if (todo.getCompleted() != null) {
            updateTodo.setCompleted(todo.getCompleted());
        }

        Todo save = repository.save(updateTodo);

        return save;
    }

    public Todo findTodo(Long id){
        Optional<Todo> opTodo = repository.findById(id);
        Todo findedtodo = opTodo.orElseThrow();

        return findedtodo;
    }

    public List<Todo> findTodos(){
        List<Todo> listTodos = repository.findAll();

        return listTodos;
    }


    public void deleteTodo(Long id){
        repository.deleteById(id);
    }

    public void deleteTodos(){
        repository.deleteAll();
    }

}
