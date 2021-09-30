package com.andree.evaluacion.controllers;

import com.andree.evaluacion.domain.UserRequest;
import com.andree.evaluacion.domain.UserResponse;
import com.andree.evaluacion.entity.User;
import com.andree.evaluacion.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping("/user")
    @Operation(summary = "Registra un nuevo usuario")
    public ResponseEntity<UserResponse> addUser(@RequestBody @Valid UserRequest userRequest, @RequestHeader(value="token") String token) {
        return new ResponseEntity<>( service.saveUser(userRequest,token), HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    @Operation(summary = "Retorna un usuario desde el ID")
    public ResponseEntity<User> getUser(int id, @RequestHeader(value="token") String token) {
        return new ResponseEntity<>( service.getUser(id), HttpStatus.OK );
    }
}
