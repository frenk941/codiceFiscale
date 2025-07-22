package com.example.demo.model;

public class Persona {
    public int anno;
    public int mese;
    public int giorno;

    public Persona(int anno, int mese, int giorno) {
        this.anno = anno;
        this.mese = mese;
        this.giorno = giorno;
    }

    public Persona() {
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getMese() {
        return mese;
    }

    public void setMese(int mese) {
        this.mese = mese;
    }

    public int getGiorno() {
        return giorno;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "anno=" + anno +
                ", mese=" + mese +
                ", giorno=" + giorno +
                '}';
    }
}

