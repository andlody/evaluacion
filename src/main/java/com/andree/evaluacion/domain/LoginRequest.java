package com.andree.evaluacion.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {
    private String userName;
    private String userPassword;
}
