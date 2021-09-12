package com.andree.evaluacion.controllers;

import com.andree.evaluacion.domain.LoginRequest;
import com.andree.evaluacion.domain.LoginResponse;
import com.andree.evaluacion.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    UserService userService = Mockito.mock(UserService.class);
    LoginController loginController = new LoginController(userService);
    final String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUb2tlbiBkZSBhY2Nlc28iLCJJZCI6MSwibmFtZSI6IkFuZHJlZSBPY2hvYSIsInVzZXIiOiJhbmRsb2R5QGdtYWlsLmNvbSJ9.Lkivgj8ojLGM7RadhUtY1jAA1TJSE22lh0wXqlBo27tOBOeoeYU5lPYNUROCT02Ud2K8Ov_p6XMfDU6tcbYHBQ";

    @BeforeEach
    void setUp() {
        LoginRequest loginRequest = new LoginRequest(
                "andlody@gmail.com",
                "Abc123");

        Mockito.when(userService.login(loginRequest)).thenReturn(token);
    }

    @Test
    void login() {
        LoginRequest loginRequest = new LoginRequest(
                "andlody@gmail.com",
                "Abc123");

        ResponseEntity<LoginResponse> response = loginController.login(loginRequest);
        assertEquals(
                new ResponseEntity<>(new LoginResponse(token), HttpStatus.OK), response
        );
    }
}