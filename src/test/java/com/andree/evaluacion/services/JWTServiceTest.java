package com.andree.evaluacion.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JWTServiceTest {

    @Test
    void createJWT() {
        String token1 = JWTService.createJWT(1,"Andree Ochoa","andlody@gmail.com");
        String token2 = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUb2tlbiBkZSBhY2Nlc28iLCJJZCI6MSwibmFtZSI6IkFuZHJlZSBPY2hvYSIsInVzZXIiOiJhbmRsb2R5QGdtYWlsLmNvbSJ9.Lkivgj8ojLGM7RadhUtY1jAA1TJSE22lh0wXqlBo27tOBOeoeYU5lPYNUROCT02Ud2K8Ov_p6XMfDU6tcbYHBQ";
        assertEquals(token1, token2);
    }

    @Test
    void validateToken() {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUb2tlbiBkZSBhY2Nlc28iLCJJZCI6MSwibmFtZSI6IkFuZHJlZSBPY2hvYSIsInVzZXIiOiJhbmRsb2R5QGdtYWlsLmNvbSJ9.Lkivgj8ojLGM7RadhUtY1jAA1TJSE22lh0wXqlBo27tOBOeoeYU5lPYNUROCT02Ud2K8Ov_p6XMfDU6tcbYHBQ";
        assertEquals(true, JWTService.validateToken( token ));

        assertEquals(false, JWTService.validateToken( "xxx.xx.xx" ));
        assertEquals(false, JWTService.validateToken( "xxx" ));
        assertEquals(false, JWTService.validateToken( "xxxx.xx" ));
    }
}