package com.example.demo.service;

import com.example.demo.utility.CodiceFiscaleUtility;
import org.springframework.stereotype.Service;

@Service
public class CodiceFiscaleService {

    private final CodiceFiscaleUtility codiceFiscaleUtility;

    public CodiceFiscaleService(CodiceFiscaleUtility codiceFiscaleUtility) {
        this.codiceFiscaleUtility = codiceFiscaleUtility;
    }

    public String estrazioneDatiCf(String codiceFiscale) {
        return codiceFiscaleUtility.estrazione(codiceFiscale);
    }
}
