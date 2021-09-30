package com.andree.evaluacion.services;

import com.andree.evaluacion.utils.JWTUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JWTUtilsTest {

    @Test
    void createJWT() {
        String token1 = JWTUtils.createJWT(1,"Andree Ochoa","andlody@gmail.com");
        String token2 = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUb2tlbiBkZSBhY2Nlc28iLCJJZCI6MSwibmFtZSI6IkFuZHJlZSBPY2hvYSIsInVzZXIiOiJhbmRsb2R5QGdtYWlsLmNvbSJ9.Lkivgj8ojLGM7RadhUtY1jAA1TJSE22lh0wXqlBo27tOBOeoeYU5lPYNUROCT02Ud2K8Ov_p6XMfDU6tcbYHBQ";
        assertEquals(token1, token2);
    }

    @Test
    void validateToken() {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUb2tlbiBkZSBhY2Nlc28iLCJJZCI6MSwibmFtZSI6IkFuZHJlZSBPY2hvYSIsInVzZXIiOiJhbmRsb2R5QGdtYWlsLmNvbSJ9.Lkivgj8ojLGM7RadhUtY1jAA1TJSE22lh0wXqlBo27tOBOeoeYU5lPYNUROCT02Ud2K8Ov_p6XMfDU6tcbYHBQ";
        assertEquals(true, JWTUtils.validateToken( token ));

        assertEquals(false, JWTUtils.validateToken( "xxx.xx.xx" ));
        assertEquals(false, JWTUtils.validateToken( "xxx" ));
        assertEquals(false, JWTUtils.validateToken( "xxxx.xx" ));
    }
}