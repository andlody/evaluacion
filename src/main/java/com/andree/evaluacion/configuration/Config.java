package com.andree.evaluacion.configuration;

public class Config {
    public static final String RegexMail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public static final String RegexPassword = "^(?=.*\\d\\D*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,}$";
    public static final String JWTSecret = "secret";

    public static final String ErrorJwtToken = "Token no autorizado.";

    public static final String ErrorLogin = "Usuario y/o Contraseña no autorizada.";
    public static final String ErrorUserNoFound = "No se encontró el usuario.";

    public static final String ErrorUserEmail = "El correo ingresado es incorrecto.";
    public static final String ErrorUserPassword = "La contraseña debe tener al menos una letra mayuscula, minuscula y dos numeros.";
    public static final String ErrorUserExistEmail = "El correo ingresado ya se encuentra registrado.";
}
