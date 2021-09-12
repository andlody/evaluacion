package com.andree.evaluacion.controllers;

import com.andree.evaluacion.configuration.Config;
import com.andree.evaluacion.domain.ErrorResponse;
import com.andree.evaluacion.domain.UserRequest;
import com.andree.evaluacion.domain.UserResponse;
import com.andree.evaluacion.entity.User;
import com.andree.evaluacion.services.JWTService;
import com.andree.evaluacion.services.UserService;
import com.andree.evaluacion.services.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping("/user")
    @Operation(summary = "Registra un nuevo usuario")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest,@RequestHeader(value="token") String token) {
        if(!JWTService.validateToken(token))
            return new ResponseEntity(new ErrorResponse(Config.ErrorJwtToken), HttpStatus.UNAUTHORIZED);

        if(ValidateService.validateEmail(userRequest.getEmail()))
            return new ResponseEntity(new ErrorResponse(Config.ErrorUserEmail), HttpStatus.NOT_ACCEPTABLE);

        if(ValidateService.validatePassoword(userRequest.getPassword()))
            return new ResponseEntity(new ErrorResponse(Config.ErrorUserPassword), HttpStatus.NOT_ACCEPTABLE);

        if(service.validateExistEmail(userRequest.getEmail()))
            return new ResponseEntity(new ErrorResponse(Config.ErrorUserExistEmail), HttpStatus.NOT_ACCEPTABLE);

        return new ResponseEntity<>(service.saveUser(userRequest, token),HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    @Operation(summary = "Retorna un usuario desde el ID")
    public ResponseEntity<User> getUser(int id, @RequestHeader(value="token") String token) {
        if(!JWTService.validateToken(token))
            return new ResponseEntity(new ErrorResponse(Config.ErrorJwtToken), HttpStatus.UNAUTHORIZED);

        User user = service.getUser(id);
        if(user==null)
            return new ResponseEntity(new ErrorResponse(Config.ErrorUserNoFound), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
