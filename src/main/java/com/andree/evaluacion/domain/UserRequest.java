package com.andree.evaluacion.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private List<PhoneRequest> phones;
}


