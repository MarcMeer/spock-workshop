package com.opsmen.klantensysteem.model;

import java.util.List;

public class ConsultancyVerkoop implements VerkoopArtikel {
    private Double prijs;
    private String omschrijving;
    private List<UrenRegel> urenRegel;

    public void setPrijs(Double prijs) {
        this.prijs = prijs;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    @Override
    public String getOmschrijving() {
        return omschrijving;
    }

    @Override
    public Double getPrijs() {
        return prijs;
    }
}
