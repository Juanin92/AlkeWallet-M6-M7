package com.controller;

import com.model.UserEntity;
import com.service.IUserService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable int id) {
        UserEntity userEntity = userService.findByUserId(id);
        if (userEntity != null) {
            return ResponseEntity.ok(userEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

   @PostMapping("/login")
   public ResponseEntity<UserEntity> loginUser(@RequestBody String email, @RequestBody String password) {
        UserEntity userEntity = iUserService.findByUser(email, password);
        if (userEntity != null) {
            return ResponseEntity.ok(userEntity);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity userEntity) {
        try {
            UserEntity newUSer = iUserService.saveUser(userEntity);
            return new ResponseEntity<>(newUSer,HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
