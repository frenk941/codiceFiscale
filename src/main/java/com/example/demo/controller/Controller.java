package com.example.demo.controller;

import com.example.demo.service.CodiceFiscaleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/esercizio/codice-fiscale")
public class Controller {
    @Autowired
    CodiceFiscaleService codiceFiscaleService;

    @Operation(summary = "Estrazione codice fiscale per calcolo età e giorno di nascita")
    @GetMapping("/{codiceFiscale}")
    public ResponseEntity<String> getCodiceFiscale(@PathVariable String codiceFiscale) {
        return ResponseEntity.ok(codiceFiscaleService.estrazioneDatiCf(codiceFiscale));
    }
}
