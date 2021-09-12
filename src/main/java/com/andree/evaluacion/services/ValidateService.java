package com.andree.evaluacion.services;

import com.andree.evaluacion.configuration.Config;
import com.andree.evaluacion.domain.UserRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.regex.Pattern;

public class ValidateService {
    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(Config.RegexMail, Pattern.CASE_INSENSITIVE);
       return !pattern.matcher(email).matches();
    }

    public static boolean validatePassoword(String password) {
        Pattern pattern = Pattern.compile(Config.RegexPassword);
        return !pattern.matcher(password).matches();
    }
}
