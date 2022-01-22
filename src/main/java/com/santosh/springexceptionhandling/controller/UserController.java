package com.santosh.springexceptionhandling.controller;

import com.santosh.springexceptionhandling.dto.ErrorResponse;
import com.santosh.springexceptionhandling.exception.RecordNotFoundException;
import com.santosh.springexceptionhandling.model.User;
import com.santosh.springexceptionhandling.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.fetchUserList();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
        if (id == 0) {
            throw new RuntimeException("User id is empty");
        }
        User user = userService.getUser(id);

        if (user == null) {
            throw new RecordNotFoundException("User with id " + id + " not found");
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        //throwing null pointer exception
        user = null;

        User created = userService.addUser(user.getName(), user.getUsername(), user.getPassword());

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-auth-token", "12345");

        return new ResponseEntity<>(created, headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(RecordNotFoundException ex,
                                                                           WebRequest request) {
        log.error("Controller record not found exception called");

        ErrorResponse error = new ErrorResponse("2", ex.getMessage(),
                HttpStatus.NOT_FOUND.value(), new Date());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        log.error("Controller handleAllExceptions called");

        ErrorResponse error = new ErrorResponse("2", ex.getMessage() != null ? ex.getMessage() : "Internal Server Error",
                HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Object> handleRuntimeException(Exception ex) {
        log.error("Controller handleRuntimeException called");

        ErrorResponse error = new ErrorResponse("2", ex.getMessage() != null ? ex.getMessage() : "Internal Server Error",
                HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

