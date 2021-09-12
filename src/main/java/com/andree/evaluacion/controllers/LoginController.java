package com.andree.evaluacion.controllers;

import com.andree.evaluacion.configuration.Config;
import com.andree.evaluacion.domain.ErrorResponse;
import com.andree.evaluacion.domain.LoginRequest;
import com.andree.evaluacion.domain.LoginResponse;
import com.andree.evaluacion.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    public LoginController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    @Operation(summary = "Login para obtener token. (Usuario de muestra: andlody@gmail.com  contraseña: Abc123) ")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        String token = userService.login(loginRequest);
        if(token==null)
            return new ResponseEntity(new ErrorResponse(Config.ErrorLogin),HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(new LoginResponse(token),HttpStatus.OK);
    }
}
