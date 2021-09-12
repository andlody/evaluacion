package com.andree.evaluacion.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateServiceTest {

    @Test
    void validateEmail() {
        String[] emailErrorList = {
                "abc",
                "abc@",
                "abc@ss",
                "abc@ss.",
                "abc@ss.c",
                "abc@.cl",
                "@s.cl"
        };
        for(String emailError:emailErrorList) {
            assertEquals(true, ValidateService.validateEmail(emailError));
        }

        assertEquals(false, ValidateService.validateEmail("email@dominio.com"));
    }

    @Test
    void validatePassoword() {
        String[] passErrorList = {
                "abc",
                "Absasas",
                "Ab1AAsss",
                "Ab3ee",
                "as23jj",
                "ab",
                "1234"
        };
        for(String passError:passErrorList) {
            assertEquals(true, ValidateService.validatePassoword(passError));
        }

        assertEquals(false, ValidateService.validatePassoword("Ab12"));
    }
}