package codestates.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "To-do Application";
    }
}
