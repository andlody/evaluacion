package com.andree.evaluacion.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PhoneRequest {
    private String number;
    private String citycode;
    private String contrycode;
}
