package com.andree.evaluacion.domain;

import com.andree.evaluacion.configuration.Config;
import com.andree.evaluacion.utils.Messages;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class LoginRequest {
    @Email(message = Messages.ErrorUserEmail)
    private String userName;

    @Pattern(regexp = Config.RegexPassword, message = Messages.ErrorUserPassword)
    private String userPassword;
}
