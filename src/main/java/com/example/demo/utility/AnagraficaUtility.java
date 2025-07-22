package com.example.demo.utility;

import com.example.demo.model.Persona;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Logger;

@Component
public class AnagraficaUtility {
    static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    LocalDate today = LocalDate.now();

    //Associazione mese - lettera
    public int determinaMese(String meseCodiceFiscale) {
        int meseNascita = 0;

        switch (meseCodiceFiscale) {
            case "A":
                meseNascita = 1;
                break;
            case "B":
                meseNascita = 2;
                break;
            case "C":
                meseNascita = 3;
                break;
            case "D":
                meseNascita = 4;
                break;
            case "E":
                meseNascita = 5;
                break;
            case "H":
                meseNascita = 6;
                break;
            case "L":
                meseNascita = 7;
                break;
            case "M":
                meseNascita = 8;
                break;
            case "P":
                meseNascita = 9;
                break;
            case "R":
                meseNascita = 10;
                break;
            case "S":
                meseNascita = 11;
                break;
            case "T":
                meseNascita = 12;
                break;
            default:
                throw new IllegalArgumentException("Il mese inserito nel codice fiscale rispetta le lettere della tabella ");
        }
        return meseNascita;
    }

    //Eventuale sottrazione dovuta al sesso della persona
    public int determinaGiorno(String giornoCodiceFiscale) {
        int giornoNascita = Integer.parseInt(giornoCodiceFiscale);
        if (giornoNascita > 40) {
            return giornoNascita - 40;
        } else {
            return giornoNascita;
        }
    }

    /**
     * Calcolo anno di nascita approssimativo in quanto non tiene conto dell'eventuale presenza di
     * persone con piu di 100 di età. Esempio , una persona nata nel 1917 e una persona nata nel 2017
     * avranno entrambe indicato 17 come anno sul loro codice fiscale.
     * Situazione non gestita in quanto non so quale sia il calcolo da parte del codice fiscale per
     * questa evenienza.
     */
    //Determinazione anno di nascita
    public int determinaAnno(String annoCodiceFiscale) {
        int annoNascita = Integer.parseInt(annoCodiceFiscale);
        int annoCorrente = today.getYear() % 100;
        log.info("Seconde due cifre dell'anno corrente : " + annoCorrente);
        if (annoNascita <= annoCorrente) {
            return 2000 + annoNascita;
        } else return 1900 + annoNascita;
    }

    //Calcolo età precisa in base al compleanno.
    public String calcoloEtà(Persona persona) {
        LocalDate birthday = LocalDate.of(persona.getAnno(), persona.getMese(), persona.getGiorno());
        Period period = Period.between(today, birthday);

        return "Il proprietario del codice fiscale ha " + period.getYears() + " anni ed è nato il " + birthday.toString();
    }

    ;
}
