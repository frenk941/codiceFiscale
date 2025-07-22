package com.example.demo.utility;

import com.example.demo.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CodiceFiscaleUtility {
    static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    AnagraficaUtility anagraficaUtility;

    public CodiceFiscaleUtility(AnagraficaUtility anagraficaUtility) {
        this.anagraficaUtility = anagraficaUtility;
    }

    /**
     * Appunti logica codice fiscale :
     * example : TBRFNC94E15H501O
     * anno nascita segnato dalle ultime due cifre dell'anno di nascita
     * lettera che indica mese di nascita
     * giorno nascita
     * Giorno di nascita avrà sempre due cifre( se numero compreso tra 1-9 avrà lo 0 come prima cifra) ,
     * per quanto riguarda le donne a questa cifra andrà sommato +40.
     * Ogni mese associato ad una lettera
     * Anno avrà soltanto le ultime due cifre della data di nascita.
     */

    public String estrazione(String codiceFiscale) {
        if (codiceFiscale == null || codiceFiscale.length() != 16) {
            return "Codice fiscale vuoto o formato non valido";
        } else {
            log.info("Codice fiscale in elaborazione : " + codiceFiscale);

            String giornoEstratto = codiceFiscale.substring(9, 11);
            log.info("giorno estratto : " + giornoEstratto);
            String meseEstratto = codiceFiscale.substring(8, 9).toUpperCase();
            log.info("mese  estratto : " + meseEstratto);
            String annoEstratto = codiceFiscale.substring(6, 8);
            log.info("anno estratto : " + annoEstratto);

            int giornoCalcolato = anagraficaUtility.determinaGiorno(giornoEstratto);
            log.info("giorno calcolato : " + giornoCalcolato);
            int meseCalcolato = anagraficaUtility.determinaMese(meseEstratto);
            log.info("mese  calcolato : " + meseCalcolato);
            int annoCalcolato = anagraficaUtility.determinaAnno(annoEstratto);
            log.info("anno calcolato : " + annoCalcolato);

            Persona persona = new Persona(annoCalcolato, meseCalcolato, giornoCalcolato);
            String result = anagraficaUtility.calcoloEtà(persona);
            return result;
        }
    }
}
