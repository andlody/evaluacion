package com.andree.evaluacion.services;

import com.andree.evaluacion.configuration.Config;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateUtilsTest {

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
        Pattern pattern = Pattern.compile(Config.RegexPassword);
        for(String passError:passErrorList)
            assertEquals(false, pattern.matcher(passError).matches(), "Rechazo" );

        assertEquals( true, pattern.matcher("Ab12").matches(), "Aceptado");
    }
}