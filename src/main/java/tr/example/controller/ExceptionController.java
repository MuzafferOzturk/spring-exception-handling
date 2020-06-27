package tr.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.example.data.User;
import tr.example.exception.UserNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("ex")
public class ExceptionController {

    @GetMapping("/say-hello")
    public String getSayHello(){
        return "Hello";
    }

    @GetMapping("/get-user-name/{id}")
    public String getUserName(@PathVariable("id") String id){
        throw new UserNotFoundException("Id :" + id);
    }

    //Controller Level Exception Handling
    @ExceptionHandler(UserNotFoundException.class)
    public void handleUserException(UserNotFoundException exception){
        System.out.println(exception.toString());
    }

    @PostMapping("/insert-user")
    public User saveUser(@Valid @RequestBody User user){
        return user;
    }
}
