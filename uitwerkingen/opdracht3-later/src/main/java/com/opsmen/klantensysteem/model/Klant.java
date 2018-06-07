package com.opsmen.klantensysteem.model;


import java.util.Date;
import java.util.List;

public class Klant {
    private String klantNummer;
    private Adres bezoekAdres;
    private Adres postAdres;
    private Adres factuurAdres;
    private Adres afleverAdres;
    private List<Adres> adresList;
    private Date klantSinds;

    public Date getKlantSinds() {
        return klantSinds;
    }

    public void setKlantSinds(Date klantSinds) {
        this.klantSinds = klantSinds;
    }

    public Adres getBezoekAdres() {
        return bezoekAdres;
    }

    public void setBezoekAdres(Adres bezoekAdres) {
        this.bezoekAdres = bezoekAdres;
    }

    public Adres getPostAdres() {
        return postAdres;
    }

    public void setPostAdres(Adres postAdres) {
        this.postAdres = postAdres;
    }

    public Adres getFactuurAdres() {
        return factuurAdres;
    }

    public void setFactuurAdres(Adres factuurAdres) {
        this.factuurAdres = factuurAdres;
    }

    public Adres getAfleverAdres() {
        return afleverAdres;
    }

    public void setAfleverAdres(Adres afleverAdres) {
        this.afleverAdres = afleverAdres;
    }

    public List<Adres> getAdresList() {
        return adresList;
    }

    public void setAdresList(List<Adres> adresList) {
        this.adresList = adresList;
    }

    public String getKlantNummer() {
        return klantNummer;
    }

    public void setKlantNummer(String klantNummer) {
        this.klantNummer = klantNummer;
    }
}
