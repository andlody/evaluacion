package com.andree.evaluacion.configuration;

public abstract class Config {

    public static final String RegexPassword = "^(?=.*\\d\\D*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,}$";
    public static final String JWTSecret = "secret";
}
