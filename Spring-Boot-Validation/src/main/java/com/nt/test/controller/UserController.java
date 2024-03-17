package com.nt.test.controller;

import com.nt.test.dto.UserRequest;
import com.nt.test.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")

  public ResponseEntity<User>saveUser(@RequestBody UserRequest userRequest){
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }


    @GetMapping("/findAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/id")
    public ResponseEntity<User>getUser(@PathVariable int id){
        return ResponseEntity.ok(userService.getUser(id));

    }
}
