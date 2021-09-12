package com.andree.evaluacion.controllers;

import com.andree.evaluacion.domain.*;
import com.andree.evaluacion.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    UserService userService = Mockito.mock(UserService.class);
    UserController userController = new UserController(userService);
    final String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUb2tlbiBkZSBhY2Nlc28iLCJJZCI6MSwibmFtZSI6IkFuZHJlZSBPY2hvYSIsInVzZXIiOiJhbmRsb2R5QGdtYWlsLmNvbSJ9.Lkivgj8ojLGM7RadhUtY1jAA1TJSE22lh0wXqlBo27tOBOeoeYU5lPYNUROCT02Ud2K8Ov_p6XMfDU6tcbYHBQ";
    final Date newDate = new Date();

    @BeforeEach
    void setUp() {
        PhoneRequest phoneRequest = new PhoneRequest("966833833","66","51");
        List<PhoneRequest> list = new ArrayList<>();
        list.add(phoneRequest);

        UserRequest userRequest = new UserRequest(
                "Andree Ochoa",
                "andlody@gmail.com",
                "Abc123", list);

        UserResponse userResponse = new UserResponse(1,token, newDate,null, newDate,true,userRequest);

        Mockito.when(userService.saveUser(userRequest,token)).thenReturn(userResponse);
    }

    @Test
    void addUser() {
        PhoneRequest phoneRequest = new PhoneRequest("966833833","66","51");
        List<PhoneRequest> list = new ArrayList<>();
        list.add(phoneRequest);
        UserRequest userRequest = new UserRequest("Andree Ochoa", "andlody@gmail.com", "Abc123", list);

        ResponseEntity<UserResponse> response = userController.addUser(userRequest,token);
        assertEquals(
                new ResponseEntity<>(
                        new UserResponse(1,token, newDate,null, newDate,true,userRequest),
                        HttpStatus.CREATED),
                response
        );
    }
}