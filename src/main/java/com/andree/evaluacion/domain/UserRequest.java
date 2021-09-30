package com.andree.evaluacion.domain;

import com.andree.evaluacion.configuration.Config;
import com.andree.evaluacion.utils.Messages;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
public class UserRequest {
    private String name;

    @Email(message = Messages.ErrorUserEmail)
    private String email;

    @Pattern(regexp = Config.RegexPassword, message = Messages.ErrorUserPassword)
    private String password;

    private List<PhoneRequest> phones;
}


