package com.opsmen.klantensysteem.model;

import java.util.List;

public class Medewerker {
    private String sofinummer;
    private Adres adres;
    private String telefoonnummer;
    private List<WeekUrenStaat> weekUrenStaten;

    public List<WeekUrenStaat> getWeekUrenStaten() {
        return weekUrenStaten;
    }

    public void setWeekUrenStaten(List<WeekUrenStaat> weekUrenStaten) {
        this.weekUrenStaten = weekUrenStaten;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getSofinummer() {

        return sofinummer;
    }

    public void setSofinummer(String sofinummer) {
        this.sofinummer = sofinummer;
    }
}
